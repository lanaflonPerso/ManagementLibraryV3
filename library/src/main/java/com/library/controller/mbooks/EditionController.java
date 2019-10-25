package com.library.controller.mbooks;

import com.library.beans.mbooks.book.edition.EditionBean;
import com.library.beans.mbooks.book.edition.EditionCreateBean;
import com.library.service.mbooks.edition.IEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/edition")
public class EditionController {
    @Autowired
    private IEditionService editionService;

    @ModelAttribute
    private EditionCreateBean editionCreateBean(){return new EditionCreateBean();}

    @GetMapping("/all")
    public String list(Model model){
        return "books/edition/list-edition";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") long id, Model model){
        model.addAttribute( "idEdition", id);

        return "books/edition/info-edition";
    }

    @GetMapping("/add")
    public String add(){return "books/edition/add-edition";}

    @PostMapping("/save")
    public String save(@ModelAttribute @Valid EditionCreateBean editionCreateBean, BindingResult result, Model model){

        if ( result.hasErrors() )
            return "books/edition/add-edition";

        return "redirect:/edition/info/" + editionService.save( editionCreateBean ).getId();

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){

        EditionBean editionBean = editionService.find( id );

        model.addAttribute( editionBean);

        return "/books/edition/update-edition";

    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid EditionBean editionBean, BindingResult result){
        if ( result.hasErrors() )
            return "/books/edition/update-edition";

        return "redirect:/edition/info/" + editionService.save( editionBean ).getId();

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id,Model model)  {

        if ( editionService.delete( id ) )
            model.addAttribute("delete","delete");
        else
            model.addAttribute("delete","err");

        return "books/edition/list-edition";
    }
}
