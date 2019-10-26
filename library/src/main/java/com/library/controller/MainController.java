package com.library.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

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
