/**
 * 
 */
package com.nicholasparks.moviedbreviews.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Nicholas Parks
 * 
 */

@Entity
@Table(name = "MOVIE_ACTORS")
public class MovieActor {
	
	private Long id;
	private Movie movie;
	private Actor actor;
	
	private String Role;

	@Id
	@GeneratedValue
	@Column(name = "movie_actor_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "movie_id")
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "actor_id")
	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
	

	
}
