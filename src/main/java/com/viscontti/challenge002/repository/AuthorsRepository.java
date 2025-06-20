package com.viscontti.challenge002.repository;

import com.viscontti.challenge002.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long> {

    @Query("SELECT DISTINCT a FROM Author a WHERE (a.birthYear < ?1) AND (a.deathYear > ?1 OR a.deathYear IS NULL)")
    public List<Author> findAuthorsAliveInYear(Integer year);
}
