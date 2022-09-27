package social.networking.kata.service;

import org.junit.Before;
import org.junit.Test;
import social.networking.kata.model.Post;
import social.networking.kata.model.User;
import social.networking.kata.model.view.PostView;
import social.networking.kata.repository.PostKataRepository;
import social.networking.kata.utils.DateTimeHandler;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostKataServiceTest {

	private final String USERNAME_BOB = "Bob_test";
	private final String MESSAGE_BOB = "test message of Bob";
	private final String DATA_TIME = "2010-08-18 18:00:00";
	private final String MESSAGE_BOB_2 = "test message of Bob2";
	private final String DATA_TIME_2 = "2020-08-15 19:00:00";
	private final String DATA_TIME_3 = "2020-08-14 19:00:00";
	private final String DATA_TIME_4 = "2020-08-16 19:00:00";
	private final String DATA_TIME_5 = "2020-08-20 17:00:00";

	private final String USERNAME_KEN = "Ken_test";
	private final String USERNAME_TOM = "Tom_test";
	private final String MESSAGE_KEN = "test messsate of Ken";
	private final String MESSAGE_TOM = "test message of Tom";

	private List<Post> postList;
	private List<Post> postList2;
	private List<Post> postList3;

	private PostKataRepository repository;
	private FollowKataService followService;
	private PostService service;

	private User user;
	private User user2;
	private User user3;

	@Before
	public void setUp() {

		repository = mock(PostKataRepository.class);
		followService = mock(FollowKataService.class);

		service = new PostKataService(repository, followService);

		postList = new ArrayList<>();
		postList.add(new Post(MESSAGE_BOB, DateTimeHandler.getDateParsed(DATA_TIME)));

		user = new User(USERNAME_BOB);
		user.setPost(postList);

		user2 = new User(USERNAME_KEN);
		postList2 = new ArrayList<>();
		postList2.add(new Post(MESSAGE_KEN, DateTimeHandler.getDateParsed(DATA_TIME_3)));
		user2.setPost(postList2);

		user3 = new User(USERNAME_TOM);
		postList3 = new ArrayList<>();
		postList3.add(new Post(MESSAGE_TOM, DateTimeHandler.getDateParsed(DATA_TIME_4)));
		user3.setPost(postList3);

	}

	@Test
	public void getUserPostTest() {
		when(repository.readUser(USERNAME_BOB)).thenReturn(user);

		List<PostView> postView = service.getPostView(USERNAME_BOB);

		String post = USERNAME_BOB + "-> " + MESSAGE_BOB;
		assertTrue(postView.get(0).getPostView().contains(post));

	}

	@Test
	public void getUserWithMultiplePostTest() {

		postList = new ArrayList<>();
		postList.add(new Post(MESSAGE_BOB, DateTimeHandler.getDateParsed(DATA_TIME)));
		postList.add(new Post(MESSAGE_BOB_2, DateTimeHandler.getDateParsed(DATA_TIME_2)));

		user.setPost(postList);

		when(repository.readUser(USERNAME_BOB)).thenReturn(user);

		List<PostView> postView = service.getPostView(USERNAME_BOB);

		List<PostView> postViewExpected = getPostViewMock();

		assertEquals(postView.get(0).getPostView(), postViewExpected.get(0).getPostView());

		assertEquals(postView.get(1).getPostView(), postViewExpected.get(1).getPostView());

	}

	@Test
	public void wallTest() {

		postList = new ArrayList<>();
		postList.add(new Post(MESSAGE_BOB, DateTimeHandler.getDateParsed(DATA_TIME)));
		postList.add(new Post(MESSAGE_BOB_2, DateTimeHandler.getDateParsed(DATA_TIME_5)));
		user.setPost(postList);

		when(repository.readUser(USERNAME_BOB)).thenReturn(user);
		when(repository.readUser(USERNAME_KEN)).thenReturn(user2);
		when(repository.readUser(USERNAME_TOM)).thenReturn(user3);

		List<String> followsMock = getFollowMock();
		when(followService.getFollowFor(USERNAME_BOB)).thenReturn(followsMock);

		List<PostView> postView = service.wallOf(USERNAME_BOB);

		List<PostView> postViewExpected = getWallMock();

		assertEquals(postView.get(0).getPostView(), postViewExpected.get(0).getPostView());
		assertEquals(postView.get(1).getPostView(), postViewExpected.get(1).getPostView());
		assertEquals(postView.get(2).getPostView(), postViewExpected.get(2).getPostView());

	}

	private List<String> getFollowMock() {
		String user1 = "Ken_test";
		String user2 = "Tom_test";

		List<String> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);

		return users;

	}

	private List<PostView> getWallMock() {

		PostView post1 = new PostView(USERNAME_BOB, MESSAGE_BOB_2, DATA_TIME_5);
		PostView post2 = new PostView(USERNAME_TOM, MESSAGE_TOM, DATA_TIME_4);
		PostView post3 = new PostView(USERNAME_KEN, MESSAGE_KEN, DATA_TIME_3);
		PostView post4 = new PostView(USERNAME_BOB, MESSAGE_BOB, DATA_TIME);

		List<PostView> post = new ArrayList<>();

		post.add(post1);
		post.add(post2);
		post.add(post3);
		post.add(post4);

		return post;

	}

	private List<PostView> getPostViewMock() {

		PostView post1 = new PostView(USERNAME_BOB, MESSAGE_BOB_2, DATA_TIME_2);
		PostView post2 = new PostView(USERNAME_BOB, MESSAGE_BOB, DATA_TIME);

		List<PostView> post = new ArrayList<>();

		post.add(post1);
		post.add(post2);

		return post;

	}
}
