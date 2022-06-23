package com.nicholasparks.moviedbreviews.services;

import java.util.List;

import com.nicholasparks.moviedbreviews.models.Movie;

public interface MovieService {

	List<Movie> getAllMovies();
	
	void saveMovie(Movie movie);
	
	Movie getMovieById(Long movieId);
	
	void deleteMovieById(Long movieId);

}
