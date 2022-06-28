package com.nicholasparks.moviedbreviews;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

import com.nicholasparks.moviedbreviews.models.Director;
import com.nicholasparks.moviedbreviews.repositories.DirectorRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class DirectorRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private DirectorRepository directorRepo;
	
	@Test
	public void testCreatNewDirector() {
		Director director = new Director();
		director.setDirectorName("Peter Porker");
		
		Director savedDirector = directorRepo.save(director);
		
		Director existDirector = entityManager.find(Director.class, savedDirector.getDirectorId());
		
		assertThat(director.getDirectorName()).isEqualTo(existDirector.getDirectorName());
	}

}
