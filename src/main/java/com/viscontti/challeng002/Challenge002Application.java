package com.viscontti.challeng002;

import com.viscontti.challeng002.service.HTTPService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.viscontti.challeng002.AppConfig;
import com.viscontti.challeng002.main.Main;

@SpringBootApplication
public class Challenge002Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Challenge002Application.class, args);

		context.getBean(Main.class).getAllBooks();

	}

}
