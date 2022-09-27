package social.networking.kata.application;

import social.networking.kata.model.command.CommandWrapper;
import social.networking.kata.model.view.PostView;
import social.networking.kata.service.FollowService;
import social.networking.kata.service.PostService;

import java.util.List;

public class SocialKataController {
	
	private final PostService servicePost;
	private final FollowService serviceFollow;

	public SocialKataController(PostService servicePost, FollowService serviceFollow) {
		this.servicePost =servicePost;
		this.serviceFollow = serviceFollow;
		
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
