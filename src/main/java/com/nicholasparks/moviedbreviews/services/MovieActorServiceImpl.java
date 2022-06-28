package com.nicholasparks.moviedbreviews.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.nicholasparks.moviedbreviews.models.MovieActor;
import com.nicholasparks.moviedbreviews.repositories.MovieActorRepository;

public class MovieActorServiceImpl implements MovieActorService {

	@Autowired
	private MovieActorRepository movieActorRepo;
	
	@Override
	public void saveMovieActor(MovieActor movieActor) {
		movieActorRepo.save(movieActor);
		
	}

}
