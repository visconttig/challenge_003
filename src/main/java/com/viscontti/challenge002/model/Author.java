package com.viscontti.challenge002.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private int birth_year;
    private int death_year;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year){
        this.birth_year = birth_year;
    }

    public int getDeath_year() {
        return death_year;
    }

    public void setDeath_year(int death_year){
        this.death_year = death_year;
    }

}
