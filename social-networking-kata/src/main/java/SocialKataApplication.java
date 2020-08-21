import java.util.Scanner;

import domain.model.command.CommandBuilder;
import domain.model.command.CommandWrapper;


public class SocialKataApplication {
	
	public static void main() {
		
		System.out.println("Welcome on Social Networking Kata!");
		String input = readCommand();
		manageInput(input);
	}
	
	private static void manageInput(String input) {
		SocialKataController controller = new SocialKataController();
		CommandWrapper command = CommandBuilder.buildCommand(input);
	}
	
	private static String readCommand() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

}
