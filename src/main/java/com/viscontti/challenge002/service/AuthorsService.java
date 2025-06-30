package com.viscontti.challenge002.service;

import com.viscontti.challenge002.model.Author;
import com.viscontti.challenge002.repository.AuthorRepository;
import com.viscontti.challenge002.util.ConsolePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorsService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorsService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public void saveAuthor(Author author){
        authorRepository.save(author);
    }

    public List<Author> findByAliveInYear(Integer year){
       return authorRepository.findAuthorsAliveInYear(year);
    }

    public void printAllAuthors(List<Author> authors){
        for(Author author : authors){
            ConsolePrinter.printFormatted("\tName: %s%n" +
                                               "\t\t- Birth Date: %d%n" +
                                               "\t\t- Death Date: %d%n" +
                                            "\t\t- Books: %s%n%n",
                                            author.getName(),
                                            author.getBirthYear(),
                                            author.getDeathYear(),
                                            author.getAllBooks()
                                                    .stream()
                                                    .map((book -> {
                                                      return   book.getName();
                                                    }))
                                                    .sorted()
                                                    .toList());
        }
    }
}
