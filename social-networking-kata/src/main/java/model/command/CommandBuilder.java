package model.command;

public class CommandBuilder {

	public CommandBuilder() {}

	public static CommandWrapper buildCommand(String command) {
		
		String[] strings = command.split(" ");
		String username = strings[0];
		
		if (strings.length > 1 && strings[1].equals("->")) {
			String message = strings[1] + " " + strings[2];
			return new CommandWrapper(TypeCommand.POSTING, username, message);
		}
		
		if (strings.length > 1 && strings[1].equals("wall")) {
			return new CommandWrapper(TypeCommand.WALL, username);
		}
		
		if (strings.length == 1) {
			return new CommandWrapper(TypeCommand.READING, username);
		}
		
		if (strings.length > 1 && strings[1].equals("following")) {
			String anotherUser = strings[2];
			return new CommandWrapper(username, anotherUser, TypeCommand.FOLLOWING);
		}

		return new CommandWrapper(TypeCommand.READING, username);
	}

}
