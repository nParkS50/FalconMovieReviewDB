package com.nicholasparks.moviedbreviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer movieId;
	private String movieTitle;
	private Integer movieYear;
	private Integer movieLength;
	private String movieCountry;
	private String genre;
	private String rating;
	
	
	public Movie(Integer movieId, String movieTitle, Integer movieYear, Integer movieLength, String movieCountry,
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

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
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

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", movieYear=" + movieYear
				+ ", movieLength=" + movieLength + ", movieCountry=" + movieCountry + ", genre=" + genre + ", rating="
				+ rating + "]";
	}
	

}
