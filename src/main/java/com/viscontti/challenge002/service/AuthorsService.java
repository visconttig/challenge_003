package com.viscontti.challenge002.service;

import com.viscontti.challenge002.main.Main;
import com.viscontti.challenge002.model.Author;
import com.viscontti.challenge002.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorsService {
    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsService(AuthorsRepository authorsRepository){
        this.authorsRepository = authorsRepository;
    }

    public List<Author> getAllAuthors(){
        return authorsRepository.findAll();
    }

    public void saveAuthor(Author author){
        authorsRepository.save(author);
    }

    public List<Author> findByAliveInYear(Integer year){
       return authorsRepository.findAuthorsAliveInYear(year);
    }

    public void printAllAuthors(List<Author> authors){
        for(Author author : authors){
            Main.printMessage(String.format("\tName: %s%n" +
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
                                                    .toList()));
        }
    }
}
