package service;

import model.command.CommandWrapper;

public interface Service {
	
	public void savePost(CommandWrapper command);
	
	public void readUser(CommandWrapper command);
	
	public void wallOf(CommandWrapper command);
	
}
