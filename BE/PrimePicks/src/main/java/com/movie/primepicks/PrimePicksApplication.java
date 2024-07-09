package com.movie.primepicks;

import com.movie.primepicks.service.PreferenceService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimePicksApplication {
	@Autowired
	PreferenceService preferenceService;

	public static void main(String[] args) {
		SpringApplication.run(PrimePicksApplication.class, args);
		System.out.println("PrimePicks Application Started");
	}

}
