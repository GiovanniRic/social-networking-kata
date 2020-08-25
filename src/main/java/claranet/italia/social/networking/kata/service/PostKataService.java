package claranet.italia.social.networking.kata.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import claranet.italia.social.networking.kata.model.Post;
import claranet.italia.social.networking.kata.model.User;
import claranet.italia.social.networking.kata.model.view.PostView;
import claranet.italia.social.networking.kata.repository.PostKataRepository;
import claranet.italia.social.networking.kata.repository.PostRepository;
import claranet.italia.social.networking.kata.utils.DateTimeHandler;

public class PostKataService implements PostService{
	
	private PostRepository repository;
	
	public PostKataService() {
		repository = new PostKataRepository();
	}
	
	public PostKataService(PostRepository repository) {
		this.repository = repository;
	}

	@Override
	public void savePost(String username, String message) {
		
		String dataTime = DateTimeHandler.getDateFormated(LocalDateTime.now());
		Post post = new Post(message,DateTimeHandler.getDateParsed(dataTime));
		
		repository.savePost(username, post);
		
	}

	@Override
	public List<PostView> getPostView(String username) {
		User readUser = repository.readUser(username);
		
		List<PostView> post = new ArrayList<>();
		
		readUser.getPost().stream().
		map(p -> post.add(
			new PostView(readUser.getUsername(), p.getMessage(), DateTimeHandler.getDateFormated(p.getTimestampPost()))))
		.collect(Collectors.toList());
		
		return post;
	}

	@Override
	public void wallOf(String username) {
		// TODO Auto-generated method stub
		
	}

}
