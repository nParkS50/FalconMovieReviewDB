package com.nicholasparks.moviedbreviews;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.nicholasparks.moviedbreviews.models.User;
import com.nicholasparks.moviedbreviews.repositories.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository repo;

	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("test@test.com");
		user.setPassword("password");
		user.setFirstName("Steven");
		user.setLastName("Test");
		
		User savedUser = repo.save(user);
		
		User existUser = entityManager.find(User.class, savedUser.getId());
		
		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
	}
}
