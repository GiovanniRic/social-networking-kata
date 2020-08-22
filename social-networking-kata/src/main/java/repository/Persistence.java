package repository;

import java.util.List;

interface Persistence<T> {
	
	public T getDataOf(String username);
	
	public void savePost(String username, String post);
	
	public List<String> readPostOf(String username);

}
