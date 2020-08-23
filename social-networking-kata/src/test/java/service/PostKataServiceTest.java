package service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Post;
import model.PostView;
import model.User;
import repository.PostKataRepository;

public class PostKataServiceTest {

	private String USERNAME = "Bob_test";
	private String MESSAGE = "test post";
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
		postList.add(new Post(MESSAGE, null));
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
