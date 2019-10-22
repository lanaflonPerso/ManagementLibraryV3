package com.library.controller.books.author;

import com.library.beans.mbooks.book.author.AuthorBean;
import com.library.beans.mbooks.book.author.AuthorCreateBean;
import com.library.service.books.author.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;



    @ModelAttribute
    private AuthorCreateBean authorCreateBean(){return new AuthorCreateBean();}

    @GetMapping("/all")
    public String list(Model model){
        return "books/author/list-author";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") long id, Model model){
        model.addAttribute( "idAuthor", id);

        return "books/author/info-author";
    }

    @GetMapping("/add")
    public String add(){return "books/author/add-author";}

    @PostMapping("/save")
    public String save(@ModelAttribute @Valid AuthorCreateBean authorCreateBean, BindingResult result,Model model){

        if ( result.hasErrors() )
            return "books/author/add-author";

        return "redirect:/author/info/" + authorService.save( authorCreateBean ).getId();

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){

        AuthorBean authorBean = authorService.find( id );

        model.addAttribute( authorBean);

        return "/books/author/update-author";

    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid AuthorBean authorBean, BindingResult result){
        if ( result.hasErrors() )
            return "/books/author/update-author";

        return "redirect:/author/info/" + authorService.save( authorBean ).getId();

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id,Model model)  {

        if ( authorService.delete( id ) )
            model.addAttribute("delete","delete");
        else
            model.addAttribute("delete","err");

        return "books/author/list-author";
    }
}
