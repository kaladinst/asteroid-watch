package com.nasa.asteroid_watch;

import com.nasa.asteroid_watch.service.NasaAsteroidService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AsteroidWatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsteroidWatchApplication.class, args);
	}


	@Bean
	public CommandLineRunner run(NasaAsteroidService myNasaService) {
		return args -> {
			myNasaService.getAsteroids();
		};
	}
}
