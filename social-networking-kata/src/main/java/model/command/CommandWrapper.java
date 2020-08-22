package model.command;


public class CommandWrapper {
	
	private TypeCommand type;
	private String username;
	private String message;
	private String anotherUser;
	
	public CommandWrapper(TypeCommand type, String username) {
		this.type = type;
		this.username = username;
	}
	
	public CommandWrapper(TypeCommand type, String username, String message) {
		this.type = type;
		this.username = username;
		this.message = message;
	}
	
	public CommandWrapper(String username, String anotherUser, TypeCommand type) {
		this.type = type;
		this.username = username;
		this.anotherUser = anotherUser;
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
	
}
