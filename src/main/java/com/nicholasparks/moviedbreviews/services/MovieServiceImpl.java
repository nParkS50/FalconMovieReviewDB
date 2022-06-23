package com.nicholasparks.moviedbreviews.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicholasparks.moviedbreviews.models.Movie;
import com.nicholasparks.moviedbreviews.repositories.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public void saveMovie(Movie movie) {
		this.movieRepository.save(movie);
	}

	@Override
	public Movie getMovieById(Long movieId) {
		Optional<Movie> optional = movieRepository.findById(movieId);
		Movie movie = null;
		if(optional.isPresent()) {
			movie = optional.get();
		}else {
			throw new RuntimeException("Movie not found for id: " + movieId);
		}
		return movie;
	}

	@Override
	public void deleteMovieById(Long movieId) {
		this.movieRepository.deleteById(movieId);
		
	}
}
