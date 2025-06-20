package com.viscontti.challenge002.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private int birthYear;
    private int deathYear;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear){
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear){
        this.deathYear = deathYear;
    }

    public void addBook(Book book) {
       if(!(books.contains(book))){
           books.add(book);
       }
    }

    public List<Book> getAllBooks() {
        return books;
    }
}
