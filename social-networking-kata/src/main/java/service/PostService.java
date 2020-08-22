package service;

import model.command.CommandWrapper;

public interface PostService {
	
	public void savePost(String username, String message);
	
	public void readUser(CommandWrapper command);
	
	public void wallOf(CommandWrapper command);
	
}
