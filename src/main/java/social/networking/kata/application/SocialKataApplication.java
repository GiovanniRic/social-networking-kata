package social.networking.kata.application;

import java.util.List;
import java.util.Scanner;

import social.networking.kata.model.Post;
import social.networking.kata.model.command.CommandWrapper;
import social.networking.kata.model.command.TypeCommand;
import social.networking.kata.model.view.PostView;
import social.networking.kata.repository.*;
import social.networking.kata.service.FollowKataService;
import social.networking.kata.service.FollowService;
import social.networking.kata.service.PostKataService;

public class SocialKataApplication {
	
	private static SocialKataController controller;
	

	public static void main(String args[]) {

		Storage<String> persistenceString = new StorageKataFollow();
		FollowRepository repository = new FollowKataRepository(persistenceString);
		Storage<Post> persistence = new StorageKataPost();
		PostRepository postRepository = new PostKataRepository(persistence);
		FollowService followService = new FollowKataService(repository);
		PostKataService postKataService = new PostKataService(postRepository, followService);

		controller = new SocialKataController(postKataService, followService);
		
		System.out.println("Welcome on Social Networking Kata!");
		System.out.println();

		while (true) {
			
			String input = readInput();
			
			if(input.equals("exit")) {
				
				System.out.println("Bye bye!!");
				break;
				
			}
			manageInput(input);
		}
	}

	private static void manageInput(String input) {
		
		CommandWrapper command = CommandWrapper.buildCommand(input);

		if (command.getType().equals(TypeCommand.POSTING)) {
			controller.posting(command);
			
		} else if (command.getType().equals(TypeCommand.READING)) {
			
			List<PostView> post = controller.reading(command);
			post.forEach(p -> System.out.println(p.getPostView()));
			
		} else if (command.getType().equals(TypeCommand.FOLLOWING)) {
			
			controller.following(command);
			
		} else if(command.getType().equals(TypeCommand.WALL)){
			
			List<PostView> wall = controller.wall(command);
			wall.forEach(w -> System.out.println(w.getPostView()));
			
		}

	}

	private static String readInput() {
		return  new Scanner(System.in).nextLine();	
	}

}
