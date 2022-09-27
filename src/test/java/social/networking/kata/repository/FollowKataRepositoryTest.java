package social.networking.kata.repository;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FollowKataRepositoryTest {

	private final String USER = "Tom_test";
	private final String ANOTHER_USER = "Ken";

	private FollowRepository repository;

	@Before
	public void setUp() {

		Storage<String> persistence = new StorageKataFollow();
		repository = new FollowKataRepository(persistence);

	}

	@Test
	public void saveFollowTest() {

		repository.saveFollow(USER, ANOTHER_USER);

		List<String> users = repository.getFollowFor(USER);

		assertTrue(users.stream().reduce((first, second) -> second).get().equals(ANOTHER_USER));

	}

}
