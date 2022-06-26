package com.nicholasparks.moviedbreviews.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicholasparks.moviedbreviews.models.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
	
	List<Actor> findMovieByActorLName(String actorLName);
}
