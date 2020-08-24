package repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import claranet.italia.social.networking.kata.repository.FollowKataRepository;
import claranet.italia.social.networking.kata.repository.FollowRepository;

public class FollowKataRepositoryTest {
	
	private final String USER = "Tom_test";
	private final String ANOTHER_USER = "Ken";
	
	private FollowRepository repository;
	
	@Before
	public void setUp() {
		repository = new FollowKataRepository();
		
	}
	
	@Test
	public void saveFollowTest() {
		
		repository.saveFollow(USER, ANOTHER_USER);
		
		List<String> users = repository.getFollowFor(USER);
		
		assertTrue(users.stream().anyMatch(user -> user.equals(ANOTHER_USER)));
		
		
	}
	

}
