package com.viscontti.challeng002.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class HTTPService {

    public String getHttpData(String url){
       String result = "";
       try {
           HttpClient client = HttpClient.newBuilder().build();
           HttpRequest req = HttpRequest.newBuilder()
                   .uri(URI.create(url))
                   .build();
           result = client.send(req, HttpResponse.BodyHandlers.ofString()).body();
       } catch (UncheckedIOException |
                IllegalArgumentException |
                IOException |
               InterruptedException e){
           System.out.println("There was an error: " + e);
       }

        return result;
    }
}
