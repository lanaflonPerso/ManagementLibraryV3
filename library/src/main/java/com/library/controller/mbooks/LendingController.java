package com.library.controller.mbooks;

import com.library.beans.mbooks.book.BookBean;
import com.library.beans.mbooks.lending.LendingBean;
import com.library.beans.mbooks.lending.LendingCreateBean;
import com.library.config.ApplicationPropertiesConfig;
import com.library.service.mbooks.IBooksService;
import com.library.service.mbooks.lending.ILendingService;
import com.library.service.users.IUsersService;
import com.library.technical.date.SimpleDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/lending")
public class LendingController {

    @Autowired
    private ILendingService lendingService;

    @ModelAttribute
    public ILendingService lendingService(){return lendingService;}

    @Autowired
    private IBooksService booksService;

    @ModelAttribute
    public IBooksService booksService(){return booksService;}

    @Autowired
    private IUsersService usersService;

    @Autowired
    private ApplicationPropertiesConfig appPropertiesConfig;

    @ModelAttribute("getCoverPath")
    public String getCoverPath(){return appPropertiesConfig.getCoverPath();}

    @ModelAttribute
    public LendingCreateBean lendingCreateBean(){return new  LendingCreateBean();}



    /*

    @ModelAttribute
    public String getDate(Date date){ return lendingService.getDate( date );   }

    @ModelAttribute
    public boolean isInProgress(LendingBean lending){
        return lendingService.isInProgress( lending );
    }




    @ModelAttribute
    public boolean isOutOfTime(LendingBean lending){
        return lendingService.isOutOfTime( lending );
    }

    @ModelAttribute
    public boolean isReturn(LendingBean lending){ return lendingService.isReturn( lending);   }

    @ModelAttribute
    public boolean isRenewable(Long renewal){ return lendingService.isRenewable( renewal ); }

    @ModelAttribute
    public String fullAuthorName(BookBean book){ return booksService.fullAuthorName( book );}



     */

    @GetMapping("/all")
    public String list(Model model){
        List<LendingBean> lendingBeanList = lendingService.list();
        model.addAttribute( lendingBeanList );

        model.addAttribute("title","Liste de tous les prêts.");
        return "books/lending/list-lending";
    }


    @GetMapping("/user/{id}")
    public String list(@PathVariable("id") Long id,Model model){

        model.addAttribute("title","Liste des prêts de l'utilisateur : " + usersService.fullName( id ) );
        List<LendingBean> lendingBeanList = lendingService.list( id );
        model.addAttribute( lendingBeanList );
        return "books/lending/list-lending";
    }

    @GetMapping("/book/{id}")
    public String list(@PathVariable("id") String id,Model model){

        model.addAttribute("title","Liste des prêts du livre : " + booksService.getTitle( id ));
        List<LendingBean> lendingBeanList = lendingService.list( id );
        model.addAttribute( lendingBeanList );
        return "books/lending/list-lending";
    }


    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") long id, Model model){
        model.addAttribute( "idLending", id);

        return "books/lending/info-lending";
    }

    @GetMapping("/add")
    public String add(Model model){return "books/lending/add-lending";}

    @PostMapping("/save")
    public String save(@ModelAttribute @Valid LendingCreateBean lendingCreateBean, BindingResult result, Model model){



        if ( result.hasErrors() )
            return "books/lending/add-lending";


        return "redirect:/lending/info/" + lendingService.save( lendingCreateBean ).getId();

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){

        LendingBean lendingBean = lendingService.find( id );

        model.addAttribute( lendingBean);

        return "/books/lending/update-lending";

    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid LendingBean lendingBean, BindingResult result){
        if ( result.hasErrors() )
            return "/books/lending/lending-book";

        return "redirect:/book/info/" + lendingService.save( lendingBean ).getId();

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id,Model model)  {

        if ( lendingService.delete( id ) )
            model.addAttribute("delete","delete");
        else
            model.addAttribute("delete","err");

        return "books/lending/list-lending";
    }
}
