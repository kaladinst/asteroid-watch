package com.nasa.asteroid_watch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "asteroids")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asteroid {

    @JsonAlias("id")
    @Id
    private String id;
    @JsonAlias("name")
    private String name;

    @JsonProperty("is_potentially_hazardous_asteroid")
    private boolean isHazardous;

    private String closeApproachDate;
}
