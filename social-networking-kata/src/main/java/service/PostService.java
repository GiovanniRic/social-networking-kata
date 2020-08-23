package service;

import java.util.List;

import model.PostView;

public interface PostService {
	
	public void savePost(String username, String message);
	
	public List<PostView> getPostView(String username);
	
	public void wallOf(String username);
	
}
