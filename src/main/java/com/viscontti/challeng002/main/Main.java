package com.viscontti.challeng002.main;

import com.viscontti.challeng002.repository.BooksRepository;
import com.viscontti.challeng002.service.HTTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Main {
    private final String URL_BASE = "https://gutendex.com/";

    @Autowired
    private final HTTPService httpService;
    @Autowired
    private BooksRepository booksRepository;

    public Main(HTTPService httpService,
                BooksRepository booksRepository){
        this.httpService = httpService;
    }

    public String getAllBooks(){
        final String ALL_BOOKS_POSTFIX = "books/";
        String result = httpService.getHttpData(URL_BASE +
                ALL_BOOKS_POSTFIX);
        System.out.printf("Results from main: %s.%n", result);

        return result;
    }
}
