package social.networking.kata.service;

import java.util.List;

import social.networking.kata.model.view.PostView;

public interface PostService {
	
	public void savePost(String username, String message);
	
	public List<PostView> getPostView(String username);
	
	public List<PostView> wallOf(String username);
	
}
