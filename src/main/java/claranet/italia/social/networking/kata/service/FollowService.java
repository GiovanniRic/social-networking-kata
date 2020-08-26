package claranet.italia.social.networking.kata.service;

import java.util.List;

public interface FollowService {
	
	public void saveFollow(String user, String anotherUser);
	
	public List<String> getFollowFor(String user);

}
