package com.nicholasparks.moviedbreviews.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="actor")
public class Actor {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer actorId;
	
	@Column(name = "act_first_name")
	private String actorFName;
	
	@Column(name = "act_first_name")
	private String actorLName;

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
	
	
}
