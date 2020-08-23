package service;

import repository.FollowKataRepository;
import repository.FollowRepository;

public class FollowKataService implements FollowService {
	
	private FollowRepository repository;
	
	public FollowKataService() {
		repository = new FollowKataRepository();
	}

	@Override
	public void saveFollow(String user, String anotherUser) {
		repository.saveFollow(user, anotherUser);
		
	}

}
