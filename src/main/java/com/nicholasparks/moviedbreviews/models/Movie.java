package com.nicholasparks.moviedbreviews.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "movie_id")
	private Long movieId;
	private String movieTitle;
	private Integer movieYear;
	private Integer movieLength;
	private String movieCountry;
	private String genre;
	private String rating;
	
	@ElementCollection
	private Set<MovieActor> movieActor = new HashSet<MovieActor>();
	@ElementCollection
	private Set<Director> director = new HashSet<Director>();
	
	
	public Movie(Long movieId, String movieTitle, Integer movieYear, Integer movieLength, String movieCountry,
			String genre, String rating) {
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.movieYear = movieYear;
		this.movieLength = movieLength;
		this.movieCountry = movieCountry;
		this.genre = genre;
		this.rating = rating;
	}
	
	public Movie() {
		
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public Integer getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(Integer movieYear) {
		this.movieYear = movieYear;
	}

	public Integer getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(Integer movieLength) {
		this.movieLength = movieLength;
	}

	public String getMovieCountry() {
		return movieCountry;
	}

	public void setMovieCountry(String movieCountry) {
		this.movieCountry = movieCountry;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	@OneToMany(mappedBy = "movie",
			cascade = CascadeType.ALL)
	public Set<MovieActor> getMovieActor(){
		return movieActor;
	}
	
	public void setMovieActor(Set<MovieActor> actor) {
		this.movieActor = actor;
	}
	
	public void addMovieActor(MovieActor movieActor) {
		this.movieActor.add(movieActor);
	}
	
	@ManyToMany(mappedBy = "movie")
	public Set<Director> getDirector() {
		return director;
	}
	
	public void addDirector(Director director) {
		this.director.add(director);
	}
	

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", movieYear=" + movieYear
				+ ", movieLength=" + movieLength + ", movieCountry=" + movieCountry + ", genre=" + genre + ", rating="
				+ rating + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(genre, movieActor, movieCountry, movieId, movieLength, movieTitle, movieYear, rating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(genre, other.genre) && Objects.equals(movieActor, other.movieActor)
				&& Objects.equals(movieCountry, other.movieCountry) && Objects.equals(movieId, other.movieId)
				&& Objects.equals(movieLength, other.movieLength) && Objects.equals(movieTitle, other.movieTitle)
				&& Objects.equals(movieYear, other.movieYear) && Objects.equals(rating, other.rating);
	}
	

}
