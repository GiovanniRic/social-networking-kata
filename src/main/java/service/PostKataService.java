package service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Post;
import model.User;
import model.view.PostView;
import repository.PostKataRepository;
import repository.PostRepository;
import utils.DateHandler;

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
		
		String dataTime = DateHandler.getDateFormated(LocalDateTime.now());
		Post post = new Post(message,DateHandler.getDateParsed(dataTime));
		
		repository.savePost(username, post);
		
	}

	@Override
	public List<PostView> getPostView(String username) {
		User readUser = repository.readUser(username);
		
		List<PostView> post = new ArrayList<>();
		
		readUser.getPost().stream().
		map(p -> post.add(
			new PostView(readUser.getUsername(), p.getMessage(), DateHandler.getDateFormated(p.getTimestampPost()))))
		.collect(Collectors.toList());
		
		return post;
	}

	@Override
	public void wallOf(String username) {
		// TODO Auto-generated method stub
		
	}

}
