package com.sarkariblackboard;


import org.slf4j.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "nimda";
		String encodedPassword = encoder.encode(rawPassword);

		System.out.println(encodedPassword);


		doStuff("jump");

	}



	private static final Logger LOGGER = LoggerFactory.getLogger(PasswordGenerator.class);
	public static void doStuff(final String value) {

		LOGGER.trace("doStuff needed more information - {}", value);
		LOGGER.debug("doStuff needed to debug - {}", value);
		LOGGER.info("doStuff took input - {}", value);
		LOGGER.warn("doStuff needed to warn - {}", value);
		LOGGER.error("doStuff encountered an error with value - {}", value);
	}

}
