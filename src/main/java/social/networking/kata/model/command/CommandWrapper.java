package social.networking.kata.model.command;


public class CommandWrapper {
	
	private TypeCommand type;
	private String username;
	private String message;
	private String anotherUser;
	
	private CommandWrapper(TypeCommand type, String username) {
		this.type = type;
		this.username = username;
	}
	
	private CommandWrapper(TypeCommand type, String username, String message) {
		this.type = type;
		this.username = username;
		this.message = message;
	}
	
	private CommandWrapper(String username, String anotherUser, TypeCommand type) {
		this.type = type;
		this.username = username;
		this.anotherUser = anotherUser;
	}
	
	public static CommandWrapper buildCommand(String command) {
		return CommandBuilder.buildCommand(command);
	}

	public TypeCommand getType() {
		return type;
	}

	public String getUsername() {
		return username;
	}

	public String getMessage() {
		return message;
	}

	public String getAnotherUser() {
		return anotherUser;
	}
	
	
	private static class CommandBuilder {
		
		public static CommandWrapper buildCommand(String command) {
			
			String[] strings = command.split(" ");
			String username = strings[0];
			
			if (strings.length > 1 && strings[1].equals("->")) {
				String message = retrieveMessage(strings);
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
		
		private static String retrieveMessage(String[] strings) {
			
			StringBuilder message = new StringBuilder();
			for (int i = 1; i < strings.length; i++) {
				message.append(" "+ strings[i]);
				
			}
			
			return message.toString().trim();
		}

	}
	
}
