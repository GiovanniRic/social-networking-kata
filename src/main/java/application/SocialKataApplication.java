package application;

import java.util.List;
import java.util.Scanner;

import model.command.CommandWrapper;
import model.command.TypeCommand;
import model.view.PostView;

public class SocialKataApplication {

	public static void main(String args[]) {

		System.out.println("Welcome on Social Networking Kata!");
		System.out.println();

		while (true) {
			String input = readInput();
			manageInput(input);
		}
	}

	private static void manageInput(String input) {
		SocialKataController controller = new SocialKataController();
		CommandWrapper command = CommandWrapper.buildCommand(input);

		if (command.getType().equals(TypeCommand.POSTING)) {
			controller.savePost(command);
		} else if (command.getType().equals(TypeCommand.READING)) {
			List<PostView> post = controller.readPost(command);
			post.stream().forEach(p -> System.out.println(p.getPostView()));
		} else if (command.getType().equals(TypeCommand.FOLLOWING)) {
			controller.saveFollowOf(command);
		}

	}

	private static String readInput() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

}
