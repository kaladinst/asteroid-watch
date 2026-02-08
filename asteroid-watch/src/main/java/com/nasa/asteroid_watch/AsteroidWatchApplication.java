package com.nasa.asteroid_watch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AsteroidWatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsteroidWatchApplication.class, args);
	}


	/*
	@Bean
	public CommandLineRunner run(NasaAsteroidService myNasaService) {
		return args -> {
			myNasaService.getAsteroids();
		};
	} */
}
