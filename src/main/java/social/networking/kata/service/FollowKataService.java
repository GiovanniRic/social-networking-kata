package social.networking.kata.service;

import social.networking.kata.repository.FollowRepository;

import java.util.List;

public class FollowKataService implements FollowService {
	
	private final FollowRepository repository;

	public FollowKataService(FollowRepository repository) {
		this.repository = repository;
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
