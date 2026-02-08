package com.nasa.asteroid_watch.controller;

import com.nasa.asteroid_watch.model.Asteroid;
import com.nasa.asteroid_watch.repository.AsteroidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AsteroidController {

    private final AsteroidRepository asteroidRepository;

    @GetMapping("/asteroids")
    public List<Asteroid> getAllAsteroids() {

        return asteroidRepository.findAll();
    }
}
