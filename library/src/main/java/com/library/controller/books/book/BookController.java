package com.library.controller.books.book;

import com.library.beans.mbooks.book.BookBean;
import com.library.beans.mbooks.book.BookCreateBean;
import com.library.service.books.IBooksService;
import com.library.service.books.author.IAuthorService;
import com.library.service.books.edition.IEditionService;
import com.library.service.books.language.ILanguageService;
import com.library.service.books.theme.IThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBooksService booksService;

    @ModelAttribute
    public IBooksService booksService(){return booksService;}

    @Autowired
    private IAuthorService authorService;

    @ModelAttribute
    public IAuthorService authorService(){return authorService;}

    @Autowired
    private IEditionService editionService;

    @ModelAttribute
    public IEditionService editionService(){return editionService;}

    @Autowired
    private ILanguageService languageService;

    @ModelAttribute
    public ILanguageService languageService(){return languageService;}

    @Autowired
    private IThemeService themeService;

    @ModelAttribute
    public IThemeService themeService(){return themeService;}



    @ModelAttribute
    private BookCreateBean bookCreateBean(){return new BookCreateBean();}

    @GetMapping("/all")
    public String list(Model model){
        return "books/book/list-book";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") long id, Model model){
        model.addAttribute( "idBook", id);

        return "books/book/info-book";
    }

    @GetMapping("/add")
    public String add(){return "books/book/add-book";}

    @PostMapping("/save")
    public String save(@ModelAttribute @Valid BookCreateBean bookCreateBean, BindingResult result, Model model){

        if ( result.hasErrors() )
            return "books/book/add-book";

        return "redirect:/book/info/" + booksService.save( bookCreateBean ).getId();

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){

        BookBean bookBean = booksService.find( id );

        model.addAttribute( bookBean);

        return "/books/book/update-book";

    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid BookBean bookBean, BindingResult result){
        if ( result.hasErrors() )
            return "/books/book/update-book";

        return "redirect:/book/info/" + booksService.save( bookBean ).getId();

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id,Model model)  {

        if ( booksService.delete( id ) )
            model.addAttribute("delete","delete");
        else
            model.addAttribute("delete","err");

        return "books/book/list-book";
    }
}
