package com.viscontti.challenge002.config;

import com.viscontti.challenge002.model.Book;
import com.viscontti.challenge002.service.BooksService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartupRunner {


    @Bean
    public CommandLineRunner demoData(BooksService booksService){
        return args -> {
            Book book1 = new Book();
            book1.setName("Moby Dick");
            book1.setAuthor("Jhon Dere");
            Book book2 = new Book();
            book2.setName("Lolita");
            book2.setAuthor("Miguel de Cervantes jaja");

            booksService.saveBook(book1);
            booksService.saveBook(book2);

            System.out.println("Books saved ---");
        };
    }
}
