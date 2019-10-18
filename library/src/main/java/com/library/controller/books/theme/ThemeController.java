package com.library.controller.books.theme;

import com.library.beans.mbooks.book.theme.ThemeBean;
import com.library.beans.mbooks.book.theme.ThemeCreateBean;
import com.library.service.books.theme.IThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/theme")
public class ThemeController {
    @Autowired
    private IThemeService themeService;

    @ModelAttribute
    public IThemeService themeService(){return themeService;}

    @ModelAttribute
    private ThemeCreateBean themeCreateBean(){return new ThemeCreateBean();}

    @GetMapping("/all")
    public String list(Model model){
        return "books/theme/list-theme";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") long id, Model model){
        model.addAttribute( "idtheme", id);

        return "books/theme/info-theme";
    }

    @GetMapping("/add")
    public String add(){return "books/theme/add-theme";}

    @PostMapping("/save")
    public String save(@ModelAttribute @Valid ThemeCreateBean themeCreateBean, BindingResult result, Model model){

        if ( result.hasErrors() )
            return "books/theme/add-theme";

        return "redirect:/theme/info/" + themeService.save( themeCreateBean ).getId();

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){

        ThemeBean themeBean = themeService.find( id );

        model.addAttribute( themeBean);

        return "/books/theme/update-theme";

    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid ThemeBean themeBean, BindingResult result){
        if ( result.hasErrors() )
            return "/books/theme/update-theme";

        return "redirect:/theme/info/" + themeService.save( themeBean ).getId();

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id,Model model)  {

        if ( themeService.delete( id ) )
            model.addAttribute("delete","delete");
        else
            model.addAttribute("delete","err");

        return "books/theme/list-theme";
    }
}
