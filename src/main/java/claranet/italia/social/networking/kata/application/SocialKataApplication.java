package claranet.italia.social.networking.kata.application;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import claranet.italia.social.networking.kata.model.command.CommandWrapper;
import claranet.italia.social.networking.kata.model.command.TypeCommand;
import claranet.italia.social.networking.kata.model.view.PostView;
import claranet.italia.social.networking.kata.utils.DateHandler;

public class SocialKataApplication {

	public static void main(String args[]) {

		System.out.println("Welcome on Social Networking Kata!");
		System.out.println();

		while (true) {

			String dataTime = "2020-08-20 13:00:00";
			LocalDateTime datePast = DateHandler.getDateParsed(dataTime);
			LocalDateTime dateNow = DateHandler.getDateParsed(DateHandler.getDateFormated(LocalDateTime.now()));
			
			
	
			
			
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
