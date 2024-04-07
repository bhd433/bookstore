package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class CategoryController {
    
    @Autowired
    CategoryRepository repo;

    // kategorialista
    @RequestMapping("/categorylist")
    public String categoryList(Model model) {

        model.addAttribute("categories", repo.findAll());
        return "categorylist";
    }
    

    // lisää kategoria
    @RequestMapping("/addcategory")
    public String addCategory(Model model) {

        model.addAttribute("kategoria", new Category());
        return "addcategory";
    }


    // tallenna lisätty kategoria
    @PostMapping("/savecategory")
    public String saveCategory(Category kategoria) {
       
        repo.save(kategoria);
        return "redirect:/categorylist";
    }
    
    
}
/*
 * 
 * 
 * 
 * <td><a th:href="@{/delete/{id}(id=${book.id})}" class="btn btn-danger">Poista</a></td>
 * <td><a th:href="@{/edit/{id}(id=${book.id})}" class="btn btn-info">Muokkaa</a></td>
 * 
 */
