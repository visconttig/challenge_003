package com.viscontti.challenge002.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO {
    private int id;
    private String title;
    private List<AuthorDTO> authors;

    private List<String> summaries;
    private List<String> subjects;

    private int download_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AuthorDTO> getAuthors() {
        return authors;
    }


    public List<String> getSummaries() {
        return summaries;
    }


    public List<String> getSubjects() {
        return subjects;
    }


    public int getDownload_count() {
        return download_count;
    }

}
