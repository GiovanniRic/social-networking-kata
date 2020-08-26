package claranet.italia.social.networking.kata.service;

import java.util.List;

import claranet.italia.social.networking.kata.repository.FollowKataRepository;
import claranet.italia.social.networking.kata.repository.FollowRepository;

public class FollowKataService implements FollowService {
	
	private FollowRepository repository;
	
	public FollowKataService() {
		repository = new FollowKataRepository();
	}
	
	public FollowKataService(FollowRepository repository) {
		repository = this.repository;
	}

	@Override
	public void saveFollow(String user, String anotherUser) {
		repository.saveFollow(user, anotherUser);
		
	}

	@Override
	public List<String> getFollowFor(String user) {
		return repository.getFollowFor(user);
	}

}
