package com.library.controller;

import com.library.beans.mbooks.book.LanguageBean;
import com.library.proxies.IMicroserviceBooksProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class ClientController {

    @Autowired
    private IMicroserviceBooksProxy microserviceBooksProxy;

    @RequestMapping("/")
    public String accueil(Model model){
        List<LanguageBean> languageList = microserviceBooksProxy.languageList();
        model.addAttribute("languageList",languageList);
        return "Accueil";
    }

}
