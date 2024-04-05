package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {

			// Your code...add some demo data to db
			Book a = new Book("harry potter", "J.K Rowling", 2005, "54321", 19.95);
			Book b = new Book("lord of the rings", "J.R Tolkien", 1954, "12345", 39.95);
			Book c = new Book("raamattu", "jeesus", 1982, "24680", 15.50);
			repository.save(a);
			repository.save(b);
			repository.save(c);
		};
	}
}
