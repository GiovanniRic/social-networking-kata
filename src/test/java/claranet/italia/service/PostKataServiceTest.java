package claranet.italia.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import claranet.italia.social.networking.kata.model.Post;
import claranet.italia.social.networking.kata.model.User;
import claranet.italia.social.networking.kata.model.view.PostView;
import claranet.italia.social.networking.kata.repository.PostKataRepository;
import claranet.italia.social.networking.kata.service.PostKataService;
import claranet.italia.social.networking.kata.service.PostService;
import claranet.italia.social.networking.kata.utils.DateTimeHandler;

public class PostKataServiceTest {

	private final String USERNAME = "Bob_test";
	private final String MESSAGE = "test post";
	private final String DATA_TIME = "2020-08-18 18:00:00";
	private final String MESSAGE_2 = "test post2";
	private final String DATA_TIME_2 = "2020-08-15 19:00:00";
	
	private List<Post> postList;
	private PostKataRepository repository;
	private PostService service;
	
	User user;

	@Before
	public void setUp() {

		repository = mock(PostKataRepository.class);

		service = new PostKataService(repository);
		user = new User("Bob_test");
		postList = new ArrayList<Post>();
		postList.add(new Post(MESSAGE, DateTimeHandler.getDateParsed(DATA_TIME)));
		user.setPost(postList);

	}

	@Test
	public void getUserPostTest() {
		when(repository.readUser(USERNAME)).thenReturn(user);

		List<PostView> postView = service.getPostView(USERNAME);

		String post = USERNAME + "-> " + MESSAGE + " (1 week ago)";
		assertTrue(postView.get(0).getPostView().equals(post));

	}
	
	@Test
	public void getUserWithMultiplePostTest() {
		
		postList = new ArrayList<Post>();
		postList.add(new Post(MESSAGE_2, DateTimeHandler.getDateParsed(DATA_TIME_2)));
		postList.add(new Post(MESSAGE, DateTimeHandler.getDateParsed(DATA_TIME)));
		user.setPost(postList);
		
		when(repository.readUser(USERNAME)).thenReturn(user);

		List<PostView> postView = service.getPostView(USERNAME);

		List<PostView> postMock = getPostViewMock();
		
		assertTrue(postView.get(0).getPostView()
				.equals(postMock.get(0).getPostView()));
		
		assertTrue(postView.get(1).getPostView()
				.equals(postMock.get(1).getPostView()));

		
	}
	
	
	private List<PostView> getPostViewMock() {
		
		PostView post1 = new PostView(USERNAME, MESSAGE, DATA_TIME);
		PostView post2 = new PostView(USERNAME, MESSAGE_2, DATA_TIME_2);
		
		List<PostView> post = new ArrayList<PostView>();
		
		post.add(post1);
		post.add(post2);
		
		return post;
		
	}
}
