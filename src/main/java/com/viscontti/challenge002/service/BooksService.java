package com.viscontti.challenge002.service;

import com.viscontti.challenge002.model.Author;
import com.viscontti.challenge002.model.Book;
import com.viscontti.challenge002.repository.BookRepository;
import com.viscontti.challenge002.util.ConsolePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BooksService {
    private final BookRepository bookRepository;

    @Autowired
    public BooksService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getBooksByLanguage(String languageCode){
        return bookRepository.findByLanguageCode(languageCode);
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }

    public void printBookInfo(Book book){
        if(book == null) {
            throw new IllegalArgumentException("You must provide a valid Book.");
        }
        ConsolePrinter.printFormatted("--> Book title: %s%n" +
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

    public void printAllBooks(List<Book> books){
        for(Book book : books){
            this.printBookInfo(book);
        }
    }
}
