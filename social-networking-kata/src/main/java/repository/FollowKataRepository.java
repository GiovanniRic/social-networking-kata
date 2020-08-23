package repository;

import java.util.List;

public class FollowKataRepository implements FollowRepository {
	
	private Persistence<String> persistence;
	
	 public FollowKataRepository() {
		 persistence = new PersistenceFollowFile();
	}

	@Override
	public void saveFollow(String user, String anotherUser) {
		persistence.save(user, anotherUser);
		
	}

	@Override
	public List<String> getFollowFor(String user) {
		return persistence.read(user);
	}

}
