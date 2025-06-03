package com.viscontti.challenge002.service;

import com.viscontti.challenge002.model.Book;
import com.viscontti.challenge002.repository.BooksRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    public List<Book> getAllBooks(){
        return booksRepository.findAll();
    }

    public void saveBook(Book book){
        booksRepository.save(book);
    }
}
