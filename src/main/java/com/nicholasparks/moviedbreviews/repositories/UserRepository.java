package com.nicholasparks.moviedbreviews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicholasparks.moviedbreviews.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

}
