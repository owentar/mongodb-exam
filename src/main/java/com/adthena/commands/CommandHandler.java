package com.adthena.commands;

import java.util.Map;

/**
 * Handles all supported commands by the application
 */
public class CommandHandler {

	private Map<String, Command> commandMap;

	public CommandHandler(Map<String, Command> commandMap) {
		this.commandMap = commandMap;
	}

	public void handle(String command) {
		getCommand(command).execute();
	}

	private Command getCommand(String command) {
		if (!commandMap.containsKey(command)) {
			throw new RuntimeException("Commmand not supported");
		}

		return commandMap.get(command);
	}

}
