package com.nicholasparks.moviedbreviews.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicholasparks.moviedbreviews.models.Actor;
import com.nicholasparks.moviedbreviews.repositories.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {
	
	@Autowired
	private ActorRepository actorRepository;

	@Override
	public List<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@Override
	public void saveActor(Actor actor) {
		this.actorRepository.save(actor);
		
	}

	@Override
	public Actor getActorById(Long actorId) {
		Optional<Actor> optional = actorRepository.findById(actorId);
		Actor actor = null;
		if(optional.isPresent()) {
			actor = optional.get();
		}else {
			throw new RuntimeException("Actor not found for id: " + actorId);
		}
		return actor;
	}

	@Override
	public void deleteActorById(Long actorId) {
		this.actorRepository.deleteById(actorId);
		
	}

}
