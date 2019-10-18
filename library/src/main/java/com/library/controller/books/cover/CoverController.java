package com.library.controller.books.cover;

import com.library.beans.mbooks.cover.CoverBean;
import com.library.beans.mbooks.cover.CoverCreateBean;
import com.library.config.ApplicationPropertiesConfig;
import com.library.proxies.ICoverProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cover")
public class CoverController {

    @Autowired
    private ICoverProxy coverProxy;

    @Autowired
    private ApplicationPropertiesConfig appPropertiesConfig;

    @ModelAttribute("coverPath")
    public String coverPath(){return appPropertiesConfig.getCoverPath();}

    @ModelAttribute
    private CoverCreateBean coverCreateBean(){return new CoverCreateBean(); }

    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") String id,Model model){

       CoverBean coverBean =  coverProxy.find(id );

       model.addAttribute( coverBean );

        return "books/cover/info-cover";
    }

    @GetMapping("/all")
    public String list(Model model){
        List<CoverBean> coverBeanList = coverProxy.list();

        model.addAttribute( coverBeanList);

        return "books/cover/list-cover";
    }



}
