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
import claranet.italia.social.networking.kata.utils.DateHandler;

public class PostKataServiceTest {

	private final String USERNAME = "Bob_test";
	private final String MESSAGE = "test post";
	private final String DATA_TIME = "2020-08-24 18:00:00";
	
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
		postList.add(new Post(MESSAGE, DateHandler.getDateParsed(DATA_TIME)));
		user.setPost(postList);

	}

	@Test
	public void getUserPostTest() {
		when(repository.readUser(USERNAME)).thenReturn(user);

		List<PostView> postView = service.getPostView(USERNAME);

		String post = USERNAME + "->" + MESSAGE;
		assertTrue(postView.get(0).getPostView().equals(post));

	}
}
