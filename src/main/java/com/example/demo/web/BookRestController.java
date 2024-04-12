package com.example.demo.web;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class BookRestController {

    // bookrepo
    @Autowired
    BookRepository bookrepo;



    // all books
    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        
        return bookrepo.findAll();
    }

    // book by id
    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> getBookById(@PathVariable("id") Long id) {

        return bookrepo.findById(id);
    }
}
