package social.networking.kata.repository;

import java.util.List;

public class FollowKataRepository implements FollowRepository {

	private final Storage<String> persistence;

	public FollowKataRepository(Storage<String> persistence) {
		this.persistence = persistence;
	}

	@Override
	public void saveFollow(String user, String anotherUser) {

		List<String> followUser = getFollowFor(user);
		if (!followUser.stream().anyMatch(follow -> follow.equals(anotherUser))) {

			persistence.save(user, anotherUser);
		}
	}

	@Override
	public List<String> getFollowFor(String user) {
		return persistence.read(user);
	}

}
