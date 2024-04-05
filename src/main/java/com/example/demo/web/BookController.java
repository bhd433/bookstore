package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository; // booklistiä varten


    // tervetuloa
    @GetMapping("/index")
    public String index() {
        // TODO: process POST request

        return "tervetuloa";
    }


    // kirjalista
    @RequestMapping("/booklist")
    public String booklist(Model model) {

        model.addAttribute("books", repository.findAll());

        return "booklist";
    }


    // kirjan poisto
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String kirjanPoisto(@PathVariable("id") long id) {

        repository.deleteById(id);
        return "redirect:../booklist";
    }


    // kirjan lisäys
    @RequestMapping(value = "/add")
    public String kirjanLisays(Model model) {

        model.addAttribute("Book", new Book());
        return "addbook";
    }


    // kirjan tallennus
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book Book) {

        repository.save(Book);
        return "redirect:booklist";
    }

    
    // kirjan muokkaus
    @RequestMapping("/edit/{id}")
    public String kirjanMuokkaus(@PathVariable("id") Long id, Model model) {

        model.addAttribute("Book", repository.findById(id));
        return "addbook";
    }
}
