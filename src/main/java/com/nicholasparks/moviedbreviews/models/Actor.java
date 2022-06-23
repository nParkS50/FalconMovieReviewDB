package com.nicholasparks.moviedbreviews.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="actor")
public class Actor {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "actor_id")
	private Integer actorId;
	
	private String actorFName;
	
	private String actorLName;
	
	@ElementCollection
	private Set<MovieActor> movieActor = new HashSet<MovieActor>();

	public Actor(Integer actorId, String actorFName, String actorLName) {
		this.actorId = actorId;
		this.actorFName = actorFName;
		this.actorLName = actorLName;
	}

	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	public String getActorFName() {
		return actorFName;
	}

	public void setActorFName(String actorFName) {
		this.actorFName = actorFName;
	}

	public String getActorLName() {
		return actorLName;
	}

	public void setActorLName(String actorLName) {
		this.actorLName = actorLName;
	}
	
	@OneToMany(mappedBy = "actor", 
			cascade = CascadeType.ALL)
	public Set<MovieActor> getMovieActor() {
		return movieActor;
	}
	
	public void setMovieActor(Set<MovieActor> actor) {
		this.movieActor = actor;
	}
	
	public void addMovieActor(MovieActor movieActor) {
		this.movieActor.add(movieActor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(actorFName, actorId, actorLName, movieActor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(actorFName, other.actorFName) && Objects.equals(actorId, other.actorId)
				&& Objects.equals(actorLName, other.actorLName) && Objects.equals(movieActor, other.movieActor);
	}
	
	
	
}
