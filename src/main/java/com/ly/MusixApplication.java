package com.ly;

import com.ly.controller.MusixController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusixApplication {

	static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		MusixApplication musixApplication = new MusixApplication();
		musixApplication.checkInput(args);
		SpringApplication.run(MusixApplication.class, args);
	}

	private void checkInput(String[] args) {
		//check for api key
		if (args == null || args.length < 1) {
			logger.fatal("Missing Musix' API Key");
			System.exit(1);
		}
		MusixController.apiKey = args[0];
	}

}
