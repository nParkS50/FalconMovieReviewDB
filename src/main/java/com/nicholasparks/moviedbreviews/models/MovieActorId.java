package com.nicholasparks.moviedbreviews.models;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
// Class to create composite key
@Embeddable
public class MovieActorId {

	private Movie movie;
	private Actor actor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Movie getMovie() {
		return movie;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Actor getActor() {
		return actor;
	}
	
	public void setActor(Actor actor) {
		this.actor = actor;
	}
}
