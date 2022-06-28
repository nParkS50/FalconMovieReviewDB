package com.nicholasparks.moviedbreviews.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicholasparks.moviedbreviews.models.Director;

public interface DirectorRepository extends JpaRepository<Director, Long> {
	
	List<Director> findDirectorByDirectorName(String directorName);

}
