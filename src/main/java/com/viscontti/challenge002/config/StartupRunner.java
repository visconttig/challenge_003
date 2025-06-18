package com.viscontti.challenge002.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viscontti.challenge002.dto.BookDTO;
import com.viscontti.challenge002.dto.GutendexDTO;
import com.viscontti.challenge002.model.Book;
import com.viscontti.challenge002.service.BooksService;
import com.viscontti.challenge002.service.HttpService;
import com.viscontti.challenge002.util.BookMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class StartupRunner {

    @Order(1)
    @Bean
    public CommandLineRunner demoData(BooksService booksService){
        return args -> {

            HttpService httpService = new HttpService();
            ObjectMapper mapper = new ObjectMapper();
            BookMapper bookMapper = new BookMapper();

            String allBooks = httpService.getHttpData("https://gutendex.com/books/");
            GutendexDTO guten = mapper.readValue(allBooks, GutendexDTO.class);
            List<BookDTO> books = guten.getResults();
            for(BookDTO bookDTO : books){
                Book book = bookMapper.toEntity(bookDTO);
                booksService.saveBook(book);
            }

            var separator = "##############################################";
            System.out.printf("%n%n%s%nDatabase pre-populated with some books.%n%s%n%n", separator, separator);

        };
    }

}
