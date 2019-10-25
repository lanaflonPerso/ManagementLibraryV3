package com.library.controller.mbooks;

import com.library.beans.mbooks.book.language.LanguageBean;
import com.library.beans.mbooks.book.language.LanguageCreateBean;
import com.library.service.mbooks.language.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private ILanguageService languageService;


    @ModelAttribute
    private LanguageCreateBean languageCreateBean(){return new LanguageCreateBean();}

    @GetMapping("/all")
    public String list(Model model){
        return "books/language/list-language";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") long id, Model model){
        model.addAttribute( "idlanguage", id);

        return "books/language/info-language";
    }

    @GetMapping("/add")
    public String add(){return "books/language/add-language";}

    @PostMapping("/save")
    public String save(@ModelAttribute @Valid LanguageCreateBean languageCreateBean, BindingResult result, Model model){

        if ( result.hasErrors() )
            return "books/language/add-language";

        return "redirect:/language/info/" + languageService.save( languageCreateBean ).getId();

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){

        LanguageBean languageBean = languageService.find( id );

        model.addAttribute( languageBean);

        return "/books/language/update-language";

    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid LanguageBean languageBean, BindingResult result){
        if ( result.hasErrors() )
            return "/books/language/update-language";

        return "redirect:/language/info/" + languageService.save( languageBean ).getId();

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id,Model model)  {

        if ( languageService.delete( id ) )
            model.addAttribute("delete","delete");
        else
            model.addAttribute("delete","err");

        return "books/language/list-language";
    }
    
}
