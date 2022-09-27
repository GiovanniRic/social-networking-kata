package social.networking.kata.service;

import social.networking.kata.model.Post;
import social.networking.kata.model.User;
import social.networking.kata.model.view.PostView;
import social.networking.kata.repository.PostRepository;
import social.networking.kata.utils.DateTimeHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PostKataService implements PostService {

	private final PostRepository repository;

	private final FollowService followService;


	public PostKataService(PostRepository repository, FollowService followService) {
		this.repository = repository;
		this.followService = followService;
	}

	@Override
	public void savePost(String username, String message) {

		String dataTime = DateTimeHandler.getDateFormated(LocalDateTime.now());
		Post post = new Post(message, DateTimeHandler.getDateParsed(dataTime));

		repository.savePost(username, post);

	}

	@Override
	public List<PostView> getPostView(String username) {

		User readUser = repository.readUser(username);

		List<PostView> post = new ArrayList<>();

		readUser.getPost().stream().map(p -> post.add(new PostView(readUser.getUsername(), p.getMessage(),
				DateTimeHandler.getDateFormated(p.getTimestampPost())))).collect(Collectors.toList());

		return sortPostViewForDateTime(post);
	}

	@Override
	public List<PostView> wallOf(String username) {

		List<PostView> wall = new ArrayList<>();

		wall.addAll(getPostView(username));

		List<String> followOfUsername = followService.getFollowFor(username);

		followOfUsername.stream().forEach(follow -> wall.addAll(getPostView(follow)));

		return sortPostViewForDateTime(wall);

	}

	private List<PostView> sortPostViewForDateTime(List<PostView> post) {

		Comparator<PostView> postViewComparator = (post1, post2) -> DateTimeHandler.getDateParsed(post2.getDateTime())
				.compareTo(DateTimeHandler.getDateParsed(post1.getDateTime()));

		return post.stream().sorted(postViewComparator).collect(Collectors.toList());
	}

}
