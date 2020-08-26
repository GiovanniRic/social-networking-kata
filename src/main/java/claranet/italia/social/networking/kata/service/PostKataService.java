package claranet.italia.social.networking.kata.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import claranet.italia.social.networking.kata.model.Post;
import claranet.italia.social.networking.kata.model.User;
import claranet.italia.social.networking.kata.model.view.PostView;
import claranet.italia.social.networking.kata.repository.PostKataRepository;
import claranet.italia.social.networking.kata.repository.PostRepository;
import claranet.italia.social.networking.kata.utils.DateTimeHandler;

public class PostKataService implements PostService {

	private PostRepository repository;

	private FollowService followService;

	public PostKataService() {
		repository = new PostKataRepository();
		followService = new FollowKataService();
	}

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
