package com.wilsonburns.shifter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//This is the server. It uses the application.properties to set the port to 23456
@SpringBootApplication
public class LightfeatherShifterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LightfeatherShifterServiceApplication.class, args);
	}

}
