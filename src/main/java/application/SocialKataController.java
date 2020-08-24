package application;

import java.util.List;

import model.command.CommandWrapper;
import model.view.PostView;
import service.FollowKataService;
import service.FollowService;
import service.PostKataService;
import service.PostService;

public class SocialKataController {
	
	private PostService servicePost;
	private FollowService serviceFollow;
	
	
	public SocialKataController() {
		servicePost = new PostKataService();
		serviceFollow = new FollowKataService();
		
	}
	
	public void savePost(CommandWrapper command) {
		servicePost.savePost(command.getUsername(), command.getMessage().replace("->", ""));
		
	}
	
	public List<PostView> readPost(CommandWrapper command){
		return servicePost.getPostView(command.getUsername());
		
	}
	
	public void saveFollowOf(CommandWrapper command) {
		serviceFollow.saveFollow(command.getUsername(), command.getAnotherUser());
		
	}
	
}
