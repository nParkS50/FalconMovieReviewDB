package com.nicholasparks.moviedbreviews.services;

import java.util.List;

import com.nicholasparks.moviedbreviews.models.Actor;

public interface ActorService {

	List<Actor> getAllActors();
	
	void saveActor(Actor actor);
	
	Actor getActorById(Long actorId);
	
	void deleteActorById(Long actorId);
}
