package com.trustarc.VirtualStandUp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VirtualStandUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualStandUpApplication.class, args);
	}

}
