package com.viscontti.challenge002.main;

import com.viscontti.challenge002.service.BooksHttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Main {
    private final BooksHttpService booksHttpService;

    @Autowired
    public Main(BooksHttpService booksHttpService){
       this.booksHttpService = booksHttpService;
    }

    public void run(){
        // for testing
       booksHttpService.searchBooksByTitle("alice");
    }

}
