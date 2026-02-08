package com.nasa.asteroid_watch.service;

import com.nasa.asteroid_watch.model.Asteroid;
import com.nasa.asteroid_watch.model.NasaResponse;
import com.nasa.asteroid_watch.repository.AsteroidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NasaAsteroidService {

        private final AsteroidRepository asteroidRepository;
        @Value("${nasa.api.key}")
        private String apiKey;

        private final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/feed";
        public void getAsteroids() {
            RestTemplate restTemplate = new RestTemplate();

            LocalDate today = LocalDate.now();
            String todayDate = today.format(DateTimeFormatter.ISO_DATE);

            NasaResponse response = restTemplate.getForObject(NASA_URL, NasaResponse.class);
            if (response != null && response.getNearEarthObjects() != null) {
                for(Map.Entry<String, List<Asteroid>> entry : response.getNearEarthObjects().entrySet()) {
                    String date = entry.getKey();
                    List<Asteroid> asteroidList = entry.getValue();

                    System.out.println("Checking asteroids for date: " + date);

                    for(Asteroid asteroid : asteroidList) {
                        asteroid.setCloseApproachDate(date);

                        asteroidRepository.save(asteroid);

                        System.out.println("Saved Asteroid to DB: " + asteroid.getName());
                    }
                }
            }
        }
}
