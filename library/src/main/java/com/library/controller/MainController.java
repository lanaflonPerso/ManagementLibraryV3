package com.library.controller;



import com.library.service.users.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MainController {


    @Autowired
    private IUsersService usersService;

    @ModelAttribute("cuurentUser")
    public String getCurrentUserFullName(){
        return  usersService.getCurrentUserFullName();
    }



    @GetMapping("/erreur")
    public String erreur(Model model){
        return "error/denied";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "user/login";
    }

    @GetMapping("/")
    public String accueil(Model model){return "index"; }

    @GetMapping("/apropos")
    public String apropos(Model model){return "infos/apropos";}

}
