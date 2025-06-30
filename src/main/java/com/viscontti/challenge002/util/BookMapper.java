package com.viscontti.challenge002.util;

import com.viscontti.challenge002.dto.AuthorDTO;
import com.viscontti.challenge002.dto.BookDTO;
import com.viscontti.challenge002.model.Author;
import com.viscontti.challenge002.model.Book;
import com.viscontti.challenge002.model.Language;
import com.viscontti.challenge002.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    private final LanguageService languageService;

    @Autowired
    public BookMapper(LanguageService languageService){
        this.languageService = languageService;
    }


    public Book toEntity(BookDTO bookDTO){
        Book book = new Book();
        book.setName(bookDTO.getTitle());

        List<Author> authors = bookDTO
                .getAuthors()
                .stream()
                .map(this::toEntity)
                .peek((author) -> author.addBook(book))
                .collect(Collectors.toList());
        book.setAuthors(authors);

        List<Language> languages = bookDTO
                .getLanguages()
                        .stream()
                                .map((language) -> {
                                    return languageService.findOrCreateLanguage(language);
                                }).collect(Collectors.toList());

        book.setLanguages(languages);

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
