package com.viscontti.challenge002.repository;

import com.viscontti.challenge002.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
