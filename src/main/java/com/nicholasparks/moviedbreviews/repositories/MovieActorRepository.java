package com.nicholasparks.moviedbreviews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicholasparks.moviedbreviews.models.MovieActor;

public interface MovieActorRepository extends JpaRepository<MovieActor, Long> {

}
