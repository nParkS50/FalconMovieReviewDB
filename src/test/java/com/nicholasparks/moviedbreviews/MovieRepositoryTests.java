package com.nicholasparks.moviedbreviews;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.nicholasparks.moviedbreviews.models.Movie;
import com.nicholasparks.moviedbreviews.repositories.MovieRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class MovieRepositoryTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Test
	public void testCreateNewMovie() {
		Movie movie = new Movie();
		movie.setMovieTitle("Test Title");
		movie.setMovieYear(1997);
		movie.setMovieLength(60);
		movie.setMovieCountry("Test");
		movie.setGenre("Test");
		movie.setRating("Good");
		
		Movie savedMovie = movieRepository.save(movie);
		
		Movie existMovie = entityManager.find(Movie.class, savedMovie.getMovieId());
		
		assertThat(movie.getMovieTitle()).isEqualTo(existMovie.getMovieTitle());
		assertThat(movie.getMovieYear()).isEqualTo(existMovie.getMovieYear());
		assertThat(movie.getMovieLength()).isEqualTo(existMovie.getMovieLength());
		assertThat(movie.getMovieCountry()).isEqualTo(existMovie.getMovieCountry());
		assertThat(movie.getGenre()).isEqualTo(existMovie.getGenre());
		assertThat(movie.getRating()).isEqualTo(existMovie.getRating());
		
	}
	
}
