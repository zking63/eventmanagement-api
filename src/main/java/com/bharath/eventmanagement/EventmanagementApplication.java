package com.bharath.eventmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
@EntityScan(basePackageClasses = { EventmanagementApplication.class, Jsr310Converters.class })
public class EventmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}

}
