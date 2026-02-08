package com.nasa.asteroid_watch.service;

import com.nasa.asteroid_watch.model.Asteroid;
import com.nasa.asteroid_watch.model.NasaResponse;
import com.nasa.asteroid_watch.repository.AsteroidRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NasaAsteroidService {

        private final AsteroidRepository asteroidRepository;
        @Value("${nasa.api.key}")
        private String apiKey;

        private final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/feed";
        @Scheduled(cron = "*/10 * * * * *")

        public void getAsteroids() {

            LocalDate today = LocalDate.now();
            String todayDate = today.format(DateTimeFormatter.ISO_DATE);
            log.info("Starting NASA check for date: {}" , today);

            String url = String.format("%s?start_date=%send_date=%s&api_key=%s" ,
                                                BASE_URL, today, today, apiKey);

            RestTemplate restTemplate = new RestTemplate();
            try {
                NasaResponse response = restTemplate.getForObject(url, NasaResponse.class);
                if (response != null && response.getNearEarthObjects() != null) {
                    log.info("NASA returned dates: {}"  , response.getNearEarthObjects().keySet());
                    List<Asteroid> todaysAsteroids = response.getNearEarthObjects().get(today);

                    if (todaysAsteroids != null) {
                        for (Asteroid asteroid : todaysAsteroids) {
                            asteroid.setCloseApproachDate(String.valueOf(today));
                            asteroidRepository.save(asteroid);
                            log.info("   💾 Saved: {} (Hazardous: {})", asteroid.getName(), asteroid.isHazardous());
                        }
                    } else {
                        log.warn("Could not find asteroids for date: {}" , today);
                    }
                }
                /* for(Map.Entry<String, List<Asteroid>> entry : response.getNearEarthObjects().entrySet()) {
                    String date = entry.getKey();
                    List<Asteroid> asteroidList = entry.getValue();

                    System.out.println("Checking asteroids for date: " + date);


                } */
            } catch (Exception e) {
                log.error("Failed to fetch data from NASA: " +e.getMessage() );
            }
        }
}
