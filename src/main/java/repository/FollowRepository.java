package repository;

import java.util.List;

public interface FollowRepository {
	
	public void saveFollow(String user, String anotherUser);
	
	public List<String> getFollowFor(String user);

}
