package repository;



import static org.junit.Assert.assertTrue;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import model.User;


public class PostKataRepositoryTest {
	
	private PostKataRepository repository;
	
	private String post = "Post test";
	private String username  = "Bob";
	
	@Before
	public void setup() {
		repository = new PostKataRepository();
	}
	
	
	@Test
	public void testSavePost() {
		
		repository.savePost(username, post);
		
		User user = repository.readPostOf(username);
		
		assertTrue(user.getPost().stream()
				.map(post -> post.getMessage())
				.anyMatch( message -> message.equals(post)));
		
		
		
	}
	

}
