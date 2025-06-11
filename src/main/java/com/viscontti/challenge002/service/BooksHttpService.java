package com.viscontti.challenge002.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksHttpService {
    private final String BASE_URL = "https://gutendex.com/";
    private final HttpService httpService;

    @Autowired
    public BooksHttpService(HttpService httpService){
        this.httpService = httpService;
    }

    public String getAllBooks(){
        final String ALL_BOOKS_POSTFIX = "books/";
        String result = httpService.getHttpData(BASE_URL +
                ALL_BOOKS_POSTFIX);
        System.out.printf("Results from main: %s.%n", result);

        return result;
     }

     public String searchBooksByTitle(String title){
        String  SEARCH_PATH_URL = "books/?search=";
        String SEARCH_URL = BASE_URL + SEARCH_PATH_URL + title;
        String result;

        result = httpService.getHttpData(SEARCH_URL);
        System.out.printf("Search by title results: %n%n\t\t%s", result);

        return result;
     }
}
