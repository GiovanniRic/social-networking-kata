package social.networking.kata.repository;

import org.junit.Before;
import org.junit.Test;
import social.networking.kata.model.Post;
import social.networking.kata.model.User;
import social.networking.kata.utils.DateTimeHandler;

import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;

public class PostKataRepositoryTest {

	private PostKataRepository repository;

	private final String MESSAGE = "Post test";
	private Post post;
	private final String USERNAME = "Bob_test";
	private String date;// = "2020-08-23 13:00:00";

	@Before
	public void setup() {
		Storage<Post> persistence = new StorageKataPost();
		repository = new PostKataRepository(persistence);
		date =  DateTimeHandler.getDateFormated(LocalDateTime.now());
		post = new Post(MESSAGE, DateTimeHandler.getDateParsed(date));
	}

	@Test
	public void testSavePost() {

		repository.savePost(USERNAME, post);

		User user = repository.readUser(USERNAME);

		assertTrue(user.getPost().stream().map(Post::getMessage)
				.anyMatch(message -> message.equals(post.getMessage())));

		assertTrue(user.getPost().stream().map(Post::getTimestampPost)
				.anyMatch(dataTime -> DateTimeHandler.getDateFormated(dataTime).equals(date)));

	}
}
