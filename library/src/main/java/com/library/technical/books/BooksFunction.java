package com.library.technical.books;

import com.library.beans.mbooks.book.BookBean;
import com.library.beans.mbooks.book.author.AuthorBean;
import com.library.beans.mbooks.lending.LendingBean;
import com.library.config.ApplicationPropertiesConfig;
import com.library.service.mbooks.BooksServiceImpl;
import com.library.service.mbooks.IBooksService;
import com.library.service.mbooks.author.AuthorServiceImpl;
import com.library.service.mbooks.author.IAuthorService;
import com.library.service.mbooks.lending.ILendingService;
import com.library.service.mbooks.lending.LendingServiceImpl;
import com.library.technical.date.SimpleDate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public interface BooksFunction {

    IAuthorService authorService = new AuthorServiceImpl();
    IBooksService booksService = new BooksServiceImpl();
    ILendingService lendingService = new LendingServiceImpl();
    SimpleDate simpleDate = new SimpleDate();
    ApplicationPropertiesConfig appPropertiesConfig = new ApplicationPropertiesConfig();


    static String getFullAuthorName(AuthorBean author){ return  authorService.fullAuthorName( author );}

    static boolean isAvailability(BookBean book) {return booksService.isAvailability( book ) ;}

    static boolean isInProgress(LendingBean lending){return lendingService.isInProgress( lending ); }

    static boolean isOutOfTime(LendingBean lending){return lendingService.isOutOfTime( lending );}

    static boolean isReturn(LendingBean lending){return lendingService.isReturn( lending);}

    static String getDate(Date date){return simpleDate.getDate( date ); }





}
