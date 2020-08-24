package repository;



import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Post;
import model.User;
import utils.DateHandler;


public class PostKataRepositoryTest {
	
	private PostKataRepository repository;
	
	private final String MESSAGE = "Post test";
	private Post post;
	private final String USERNAME  = "Bob_test";
	private final String DATE = "2020-08-23 13:00:00";
	
	@Before
	public void setup() {
		repository = new PostKataRepository();
		post = new Post(MESSAGE, DateHandler.getDateParsed(DATE));
	}
	
	
	@Test
	public void testSavePost() {
		
		repository.savePost(USERNAME, post);
		
		User user = repository.readUser(USERNAME);
		
		assertTrue(user.getPost().stream()
				.map(post -> post.getMessage())
				.anyMatch( message -> message.equals(post.getMessage())));
		
		assertTrue(user.getPost().stream()
				.map(post -> post.getTimestampPost())
				.anyMatch( dataTime -> DateHandler.getDateFormated(dataTime).equals(DATE)));
		
		
		
	}
	

}
