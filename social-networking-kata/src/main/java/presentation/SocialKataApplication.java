package presentation;
import java.util.Scanner;

import model.command.CommandBuilder;
import model.command.CommandWrapper;


public class SocialKataApplication {
	
	public static void main() {
		
		System.out.println("Welcome on Social Networking Kata!");
		String input = readInput();
		manageInput(input);
	}
	
	private static void manageInput(String input) {
		SocialKataController controller = new SocialKataController();
		CommandWrapper command = CommandBuilder.buildCommand(input);
	}
	
	private static String readInput() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

}
