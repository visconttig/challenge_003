package com.viscontti.challenge002.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorDTO {
    private String name;
    @JsonProperty("birth_year")
    private int birthYear;
    @JsonProperty("death_year")
    private int deathYear;

    public String getName(){
        return name;
    }

    public int getBirthYear(){
        return birthYear;
    }

    public int getDeathYear(){
        return deathYear;
    }
}
