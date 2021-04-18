package com.accenture.accchallenge;

import com.accenture.accchallenge.persistence.World;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccChallengeApplication {

	public static World world = new World();

	public static void main(String[] args) {

		SpringApplication.run(AccChallengeApplication.class, args);
	}

}
