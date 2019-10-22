package com.library.controller;


import com.library.proxies.IBooksProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private IBooksProxy microserviceBooksProxy;

    @GetMapping("/erreur")
    public String erreur(Model model){
        return "error/denied";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "user/login";
    }

    @GetMapping("/")
    private String accueil(Model model){


        return "index";

    }

}
