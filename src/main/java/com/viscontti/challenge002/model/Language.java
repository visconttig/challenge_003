package com.viscontti.challenge002.model;

import jakarta.persistence.*;

@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "language_code",
    unique = true,
    nullable = false)
    private String languageCode;

    public Language(String languageCode){
        this.languageCode = languageCode;
    }

    public String getLanguageCode(){
        return languageCode;
    }

    public void setLanguageCode(String languageCode){
        this.languageCode = languageCode;
    }
}
