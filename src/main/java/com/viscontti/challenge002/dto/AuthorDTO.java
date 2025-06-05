package com.viscontti.challenge002.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorDTO {
    private String name;
    private int birth_year;
    private int death_year;

    public String getName(){
        return name;
    }

    public int getBirth_year(){
        return birth_year;
    }

    public int getDeath_year(){
        return death_year;
    }
}
