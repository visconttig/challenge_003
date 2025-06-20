package com.viscontti.challenge002.repository;

import com.viscontti.challenge002.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Long> {

}
