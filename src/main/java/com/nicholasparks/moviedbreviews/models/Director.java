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
	private Integer directorId;
	private String directorFName;
	private String directorLNname;
	
	@ElementCollection
	private Set<Movie> movie = new HashSet<Movie>();
	
	
	public Director(Integer directorId, String directorFName, String directorLNname) {
		this.directorId = directorId;
		this.directorFName = directorFName;
		this.directorLNname = directorLNname;
	}

	public Director() {
		
	}

	public Integer getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
	}

	public String getDirectorFName() {
		return directorFName;
	}

	public void setDirectorFName(String directorFName) {
		this.directorFName = directorFName;
	}

	public String getDirectorLNname() {
		return directorLNname;
	}

	public void setDirectorLNname(String directorLNname) {
		this.directorLNname = directorLNname;
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
