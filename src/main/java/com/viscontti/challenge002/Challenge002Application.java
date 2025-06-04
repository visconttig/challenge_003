package com.viscontti.challenge002;

import com.viscontti.challenge002.model.Book;
import com.viscontti.challenge002.service.BooksService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.viscontti.challenge002.main.Main;

@SpringBootApplication
public class Challenge002Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Challenge002Application.class, args);

	//	context.getBean(Main.class).getAllBooks();

	}

}
