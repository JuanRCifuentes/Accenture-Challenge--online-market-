package com.accenture.accchallenge;

import com.accenture.accchallenge.persistence.Mundo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccChallengeApplication {

	public static void main(String[] args) {

		new Mundo();

		SpringApplication.run(AccChallengeApplication.class, args);
	}

}
