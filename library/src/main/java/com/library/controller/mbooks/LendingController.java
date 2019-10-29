package com.library.controller.mbooks;

import com.library.beans.mbooks.book.author.AuthorBean;
import com.library.beans.mbooks.lending.LendingBean;
import com.library.beans.mbooks.lending.LendingCreateBean;
import com.library.config.ApplicationPropertiesConfig;
import com.library.service.mbooks.IBooksService;
import com.library.service.mbooks.author.IAuthorService;
import com.library.service.mbooks.lending.ILendingService;
import com.library.service.users.IUsersService;
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
public class LendingController implements ILendingController {
    @Autowired
    private ILendingController lendingController;

    @ModelAttribute
    public ILendingController lendingController(){ return lendingController;}

    public String getDate(Date date){ return lendingService.getDate( date );   }

    public boolean isInProgress(LendingBean lending){
        return lendingService.isInProgress( lending );
    }

    public boolean isOutOfTime(LendingBean lending){ return lendingService.isOutOfTime( lending ); }

    public boolean isReturn(LendingBean lending){ return lendingService.isReturn( lending);   }

    public boolean isRenewable(Integer renewal){ return lendingService.isRenewable( renewal ); }

    public String getFullAuthorName(AuthorBean author){ return authorService.fullAuthorName( author );}


    @Autowired
    private ILendingService lendingService;

    @Autowired
    private IBooksService booksService;

    @Autowired
    private IUsersService usersService;

    @Autowired
    private IAuthorService authorService;

    @Autowired
    private ApplicationPropertiesConfig appPropertiesConfig;

    @ModelAttribute("getCoverPath")
    public String getCoverPath(){return appPropertiesConfig.getCoverPath();}

    @ModelAttribute("cuurentUser")
    public String getCurrentUserFullName(){
        return  usersService.getCurrentUserFullName();
    }

    @GetMapping("/user")
    public String userList(Model model){

        model.addAttribute("title","Liste de mes prêts " );
        List<LendingBean> lendingBeanList = lendingService.list( usersService.getCurrentUserId() );
        model.addAttribute( lendingBeanList );
        return "books/lending/list-lending";
    }

    @GetMapping("/renewal/{id}")
    public String renawal(@PathVariable("id")Long id, Model model){
        lendingService.renewal( id );

        return "redirect:/lending/user";
    }



    @ModelAttribute
    public LendingCreateBean lendingCreateBean(){return new  LendingCreateBean();}


    @GetMapping("/all")
    public String allList(Model model){
        List<LendingBean> lendingBeanList = lendingService.list();
        model.addAttribute( lendingBeanList );

        model.addAttribute("title","Liste de tous les prêts.");
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
