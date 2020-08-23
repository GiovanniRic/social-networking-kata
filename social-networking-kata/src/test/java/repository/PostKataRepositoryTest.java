package repository;



import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Post;
import model.User;
import utils.DateHandler;


public class PostKataRepositoryTest {
	
	private PostKataRepository repository;
	
	private final String message = "Post test";
	private Post post;
	private final String username  = "Bob";
	private final String DATE = "2020-08-23 13:00:00";
	
	@Before
	public void setup() {
		repository = new PostKataRepository();
		post = new Post(message, DateHandler.getDateParsed(DATE));
	}
	
	
	@Test
	public void testSavePost() {
		
		repository.savePost(username, post);
		
		User user = repository.readUser(username);
		
		assertTrue(user.getPost().stream()
				.map(post -> post.getMessage())
				.anyMatch( message -> message.equals(post.getMessage())));
		
		assertTrue(user.getPost().stream()
				.map(post -> post.getTimestampPost())
				.anyMatch( dataTime -> DateHandler.getDateFormated(dataTime).equals(DATE)));
		
		
		
	}
	

}
