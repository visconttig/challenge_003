package com.viscontti.challenge002.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viscontti.challenge002.dto.BookDTO;
import com.viscontti.challenge002.dto.GutendexDTO;
import com.viscontti.challenge002.model.Author;
import com.viscontti.challenge002.model.Book;
import com.viscontti.challenge002.service.BooksService;
import com.viscontti.challenge002.service.HTTPService;
import com.viscontti.challenge002.util.BookMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StartupRunner {


    @Bean
    public CommandLineRunner demoData(BooksService booksService){
        return args -> {

            HTTPService httpService = new HTTPService();
            ObjectMapper mapper = new ObjectMapper();
            BookMapper bookMapper = new BookMapper();

            String allBooks = httpService.getHttpData("https://gutendex.com/books/");
            GutendexDTO guten = mapper.readValue(allBooks, GutendexDTO.class);
            List<BookDTO> books = guten.getResults();
            for(BookDTO bookDTO : books){
                Book book = bookMapper.toEntity(bookDTO);
                booksService.saveBook(book);
            }
            System.out.println("Books saved.");

        };
    }
}
