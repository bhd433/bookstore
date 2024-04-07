package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			// Your code...add some demo data to db
			Category x = new Category("Superhero");
			Category y = new Category("Fantasy");
			Category z = new Category("Religious");
			categoryRepository.save(x);
			categoryRepository.save(y);
			categoryRepository.save(z);


			Book a = new Book("harry potter", "J.K Rowling", 2005, "54321", 19.95, y);
			Book b = new Book("lord of the rings", "J.R Tolkien", 1954, "12345", 39.95, y);
			Book c = new Book("raamattu", "jeesus", 1982, "24680", 15.50, z);
			bookRepository.save(a);
			bookRepository.save(b);
			bookRepository.save(c);
		};
	}
}
