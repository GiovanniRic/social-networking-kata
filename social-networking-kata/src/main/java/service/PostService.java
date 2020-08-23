package service;



public interface PostService {
	
	public void savePost(String username, String message);
	
	public void readUser(String username);
	
	public void wallOf(String username);
	
}
