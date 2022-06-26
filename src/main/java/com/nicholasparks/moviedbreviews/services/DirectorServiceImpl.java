package com.nicholasparks.moviedbreviews.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicholasparks.moviedbreviews.models.Director;
import com.nicholasparks.moviedbreviews.repositories.DirectorRepository;

@Service
public class DirectorServiceImpl implements DirectorService {

	@Autowired
	private DirectorRepository directorRepository;
	
	@Override
	public List<Director> getAllDirectors() {
		return directorRepository.findAll();
	}

	@Override
	public void saveDirector(Director director) {
		this.directorRepository.save(director);
		
	}

	@Override
	public Director getDirectorById(Long directorId) {
		Optional<Director> optional = directorRepository.findById(directorId);
		Director director = null;
		if(optional.isPresent()) {
			director = optional.get();
		}else {
			throw new RuntimeException("Director not found for id: " + directorId);
		}
		return director;
	}

	@Override
	public void deleteDirectorById(Long directorId) {
		this.directorRepository.deleteById(directorId);
		
	}

}
