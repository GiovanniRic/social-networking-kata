package repository;


import java.util.ArrayList;
import java.util.List;

import model.Post;
import model.User;



public class PostKataRepository implements PostRepository {
	
	private Persistence persistence;
	
	
	public PostKataRepository() {
		persistence = new PersistenceFile();
	}

	@Override
	public void savePost(String username, String post) {
		persistence.savePost( username, post);
		
	}

	@Override
	public User readPostOf(String username) {
		List<String> post = persistence.readPostOf(username);
		
		List<Post> postModel = new ArrayList<>();
		
		User user = new User(username);
		post.stream().forEach(p -> postModel.add(new Post(p, null)));
		
		user.setPost(postModel);
		
		return user;

	}
	

	}


