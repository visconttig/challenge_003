package com.viscontti.challenge002.repository;

import com.viscontti.challenge002.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b join b.languages l where l.languageCode = ?1")
    List<Book> findByLanguageCode(String languageCode);

}
