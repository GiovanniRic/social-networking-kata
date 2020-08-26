package claranet.italia.social.networking.kata.application;

import java.util.List;
import java.util.Scanner;

import claranet.italia.social.networking.kata.model.command.CommandWrapper;
import claranet.italia.social.networking.kata.model.command.TypeCommand;
import claranet.italia.social.networking.kata.model.view.PostView;

public class SocialKataApplication {
	
	private static SocialKataController controller;
	

	public static void main(String args[]) {

		controller = new SocialKataController();
		
		System.out.println("Welcome on Social Networking Kata!");
		System.out.println();

		while (true) {
			String input = readInput();
			manageInput(input);
		}
	}

	private static void manageInput(String input) {
		
		CommandWrapper command = CommandWrapper.buildCommand(input);

		if (command.getType().equals(TypeCommand.POSTING)) {
			controller.posting(command);
			
		} else if (command.getType().equals(TypeCommand.READING)) {
			
			List<PostView> post = controller.reading(command);
			post.stream().forEach(p -> System.out.println(p.getPostView()));
			
		} else if (command.getType().equals(TypeCommand.FOLLOWING)) {
			controller.following(command);
		} else if(command.getType().equals(TypeCommand.WALL)){
			
			List<PostView> wall = controller.wall(command);
			wall.stream().forEach(w -> System.out.println(w.getPostView()));
			
		}

	}

	private static String readInput() {
		return  new Scanner(System.in).nextLine();
		
	}

}
