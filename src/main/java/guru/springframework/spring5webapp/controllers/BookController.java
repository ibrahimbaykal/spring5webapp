package guru.springframework.spring5webapp.controllers;


import guru.springframework.spring5webapp.repositories.BookRepositoory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepositoory bookRepositoory;

    public BookController(BookRepositoory bookRepositoory) {
        this.bookRepositoory = bookRepositoory;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books",bookRepositoory.findAll());

        return "books";
    }
}
