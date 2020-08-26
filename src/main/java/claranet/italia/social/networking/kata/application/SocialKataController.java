package claranet.italia.social.networking.kata.application;

import java.util.List;

import claranet.italia.social.networking.kata.model.command.CommandWrapper;
import claranet.italia.social.networking.kata.model.view.PostView;
import claranet.italia.social.networking.kata.service.FollowKataService;
import claranet.italia.social.networking.kata.service.FollowService;
import claranet.italia.social.networking.kata.service.PostKataService;
import claranet.italia.social.networking.kata.service.PostService;

public class SocialKataController {
	
	private PostService servicePost;
	private FollowService serviceFollow;
	

	public SocialKataController() {
		servicePost = new PostKataService();
		serviceFollow = new FollowKataService();
		
	}
	
	public void posting(CommandWrapper command) {
		servicePost.savePost(command.getUsername(), command.getMessage().replace("->", ""));
		
	}
	
	public List<PostView> reading(CommandWrapper command){
		return servicePost.getPostView(command.getUsername());
		
	}
	
	public void following(CommandWrapper command) {
		serviceFollow.saveFollow(command.getUsername(), command.getAnotherUser());
		
	}
	
	public List<PostView> wall(CommandWrapper command) {
		return servicePost.wallOf(command.getUsername());
	}
	
}
