package com.viscontti.challenge002.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO {
    private int id;
    private String title;
    private List<AuthorDTO> authors;

    private List<String> summaries;
    private List<String> subjects;
    private List<String> languages;

    @JsonProperty("download_count")
    private int downloadCount;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
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


    public List<String> getLanguages(){
        return languages;
    }


    public int getDownload_count() {
        return downloadCount;
    }

}
