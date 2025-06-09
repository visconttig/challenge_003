package com.viscontti.challenge002.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GutendexDTO {
    private int count;
    private List<BookDTO> results;

    public List<BookDTO> getResults(){
        return results;
    }

    @Override
    public String toString() {
        return "GutendexDTO{" +
                "count=" + count +
                ", results=" + results +
                '}';
    }
}
