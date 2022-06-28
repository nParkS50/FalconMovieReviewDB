package com.nicholasparks.moviedbreviews;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

import com.nicholasparks.moviedbreviews.models.Actor;
import com.nicholasparks.moviedbreviews.repositories.ActorRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class ActorRepositoryTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ActorRepository actorRepo;
	
	@Test
	public void testCreateNewActor() {
		Actor actor = new Actor();
		actor.setActorFName("Peter");
		actor.setActorLName("Parker");
		
		Actor savedActor = actorRepo.save(actor);
		
		Actor existActor = entityManager.find(Actor.class, savedActor.getActorId());
		
		assertThat(actor.getActorFName()).isEqualTo(existActor.getActorFName());
		assertThat(actor.getActorLName()).isEqualTo(existActor.getActorLName());
	}

}
