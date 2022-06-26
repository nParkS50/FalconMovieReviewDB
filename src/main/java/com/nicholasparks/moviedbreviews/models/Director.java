package com.nicholasparks.moviedbreviews.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="director")
public class Director {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "director_id")
	private Long directorId;
	private String directorFName;
	private String directorLName;
	
	@ElementCollection
	private Set<Movie> movie = new HashSet<Movie>();
	
	
	public Director(Long directorId, String directorFName, String directorLName) {
		this.directorId = directorId;
		this.directorFName = directorFName;
		this.directorLName = directorLName;
	}

	public Director() {
		
	}

	public Long getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Long directorId) {
		this.directorId = directorId;
	}

	public String getDirectorFName() {
		return directorFName;
	}

	public void setDirectorFName(String directorFName) {
		this.directorFName = directorFName;
	}

	public String getDirectorLName() {
		return directorLName;
	}

	public void setDirectorLName(String directorLName) {
		this.directorLName = directorLName;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "movie_director", 
			joinColumns = @JoinColumn(name = "movie_id"), 
			inverseJoinColumns = @JoinColumn(name = "director_id"))
	public Set<Movie> getMovie(){
		return movie;
	}
	
	public void addMovie(Movie movie) {
		this.movie.add(movie);
	}
	
}
