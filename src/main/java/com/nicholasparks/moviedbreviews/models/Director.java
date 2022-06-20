package com.nicholasparks.moviedbreviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="director")
public class Director {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer directorId;
	private String directorFName;
	private String directorLNname;
	
	
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
	
	
	
}
