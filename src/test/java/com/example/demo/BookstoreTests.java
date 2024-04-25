package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;
import com.example.demo.web.BookController;



@ExtendWith(SpringExtension.class)   // JUnit5 eli Jupiter
@SpringBootTest
public class BookstoreTests {


@Autowired
private BookController bookController;
@Autowired
private BookRepository bookRepository;
@Autowired
private CategoryRepository categoryRepository;


@Test // lataako book controlleri
public void bookControllerLoads() throws Exception {
assertThat(bookController).isNotNull();
} 


@Test // toimiiko uuden kirjan luonti ja tallennus book repositoryyn
public void createNewBook() {
Book book = new Book();


//assertThat(bookRepository.save(book)).isNotNull();
bookRepository.save(book);
assertThat(book.getId()).isNotNull();
} 


@Test // toimiiko kategorian luonti ja tallennus category repositoryyn
public void createCategory() {
Category category = new Category();
categoryRepository.save(category);
assertThat(category.getCategoryid()).isNotNull();
} 
}