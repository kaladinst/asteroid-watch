package com.nasa.asteroid_watch.repository;

import com.nasa.asteroid_watch.model.Asteroid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsteroidRepository extends JpaRepository<Asteroid, String> {

}
