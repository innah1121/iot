package com.project.IotMiniSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IotMiniSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotMiniSystemApplication.class, args);
	}

}
