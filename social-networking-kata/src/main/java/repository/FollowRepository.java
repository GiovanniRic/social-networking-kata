package repository;

import java.util.List;

interface FollowRepository {
	
	public void saveFollow(String user, String anotherUser);
	
	public List<String> getFollowFor(String user);

}
