package claranet.italia.social.networking.kata.service;

import claranet.italia.social.networking.kata.repository.FollowKataRepository;
import claranet.italia.social.networking.kata.repository.FollowRepository;

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
