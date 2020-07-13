package com.springbootdemo.ticketsystem;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TicketsystemApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TicketsystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicketsystemApplication.class, args);
		LOGGER.info("Welcome to the Ticket Application");
	}

}
