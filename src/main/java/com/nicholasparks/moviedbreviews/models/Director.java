package com.nicholasparks.moviedbreviews.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="director")
public class Director {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "director_id")
	private Long directorId;
	
	@Column(nullable = false, length = 60)
	private String directorName;
	
	@ElementCollection
	private Set<Movie> movie = new HashSet<Movie>();
	
	
	public Director(Long directorId, String directorName) {
		this.directorId = directorId;
		this.directorName = directorName;
	}

	public Director() {
		
	}

	public Long getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Long directorId) {
		this.directorId = directorId;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	
	@Override
	public String toString() {
		return this.directorName;
	}
}
