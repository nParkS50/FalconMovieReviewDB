package com.nicholasparks.moviedbreviews.services;

import java.util.List;

import com.nicholasparks.moviedbreviews.models.Director;

public interface DirectorService {

	List<Director> getAllDirectors();
	
	void saveDirector(Director director);
	
	Director getDirectorById(Long directorId);
	
	void deleteDirectorById(Long directorId);
}
