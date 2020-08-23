package repository;

import java.util.List;

interface Persistence {
	
	public void savePost(String username, String post);
	
	public List<String> readPostOf(String username);

}
