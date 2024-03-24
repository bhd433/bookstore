package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class BookController {
    

    @GetMapping("/index")
    public String index() {
        //TODO: process POST request
        
        return "tervetuloa";
    }
    
    

}
