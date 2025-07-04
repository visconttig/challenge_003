package com.viscontti.challenge002.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 3000)
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
    fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @ManyToMany(cascade = {CascadeType.MERGE},
    fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_language",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages;

    private int downloadCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setLanguages(List<Language> languages){
        this.languages = languages;
    }

    public List<Language> getLanguages(){
        return languages;
    }

    public long getId() {
        return id;
    }

    public int getDownloadCount(){
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount){
        this.downloadCount = downloadCount;
    }

}
