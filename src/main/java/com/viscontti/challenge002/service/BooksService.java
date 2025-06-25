package com.viscontti.challenge002.service;

import com.viscontti.challenge002.model.Author;
import com.viscontti.challenge002.model.Book;
import com.viscontti.challenge002.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    public List<Book> getAllBooks(){
        return booksRepository.findAll();
    }

    public void saveBook(Book book){
        booksRepository.save(book);
    }

    public void printBookInfo(Book book){
        if(book == null) {
            throw new IllegalArgumentException("You must provide a valid Book.");
        }
        System.out.printf("--> Book title: %s%n" +
                                  "\tAuthor(s): %s%n%n",
                          book.getName(),
                          book.getAuthors()
                                  .stream()
                                  .map(Author::getName)
                                  .collect(Collectors.toList()));
    }

    public void printAllBooks(){
            for(Book book : this.getAllBooks()){
                this.printBookInfo(book);
            }
    }
}
