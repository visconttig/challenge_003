package com.viscontti.challenge002.util;

import com.viscontti.challenge002.dto.AuthorDTO;
import com.viscontti.challenge002.dto.BookDTO;
import com.viscontti.challenge002.model.Author;
import com.viscontti.challenge002.model.Book;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public Book toEntity(BookDTO bookDTO){
        Book book = new Book();
        book.setName(bookDTO.getTitle());

        List<Author> authors = bookDTO
                .getAuthors()
                .stream()
                .map(this::toEntity)
                .map((author) -> {
                    author.addBook(book);
                    return author;
                })
                .collect(Collectors.toList());

        book.setAuthors(authors);
        return book;
    }

    public Author toEntity(AuthorDTO authorDTO){
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setBirthYear(authorDTO.getBirthYear());
        author.setDeathYear(authorDTO.getDeathYear());
        return author;
    }
}
