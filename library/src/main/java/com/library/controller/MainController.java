package com.library.controller;

import com.library.beans.mbooks.book.LanguageBean;
import com.library.proxies.IMicroserviceBooksProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private IMicroserviceBooksProxy microserviceBooksProxy;

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
        List<LanguageBean> languageList = microserviceBooksProxy.languageList();
        model.addAttribute("languageList",languageList);

        return "index";

    }

}
