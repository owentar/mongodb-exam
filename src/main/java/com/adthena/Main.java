package com.adthena;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.adthena.commands.CommandHandler;

public class Main {
	
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		setUpApplication();

		executeApplication(args);
	}

	private static void setUpApplication() {
		applicationContext = new GenericXmlApplicationContext("ApplicationContext.xml");
	}

	private static void executeApplication(String[] args) {
		verifyArguments(args);
		
		CommandHandler commandHandler = applicationContext.getBean(CommandHandler.class);
		commandHandler.handle(args[0]);
	}

	private static void verifyArguments(String[] args) {
		if (args.length != 1) {
			throw new RuntimeException("Invalid arguments");
		}
	}

}
