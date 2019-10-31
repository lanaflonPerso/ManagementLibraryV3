package com.library.service.mbooks;

import com.library.beans.mbooks.book.BookBean;
import com.library.beans.mbooks.book.BookCreateBean;
import com.library.beans.mbooks.book.author.AuthorBean;
import com.library.exception.ResourceNotFoundException;
import com.library.proxies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements IBooksService {

    @Autowired
    private IBooksProxy booksProxy;

    @Autowired
    private ICoverProxy coverProxy;

    @Autowired
    private IAuthorProxy authorProxy;

    @Autowired
    private IEditionProxy editionProxy;

    @Autowired
    private IThemeProxy themeProxy;

    @Autowired
    private ILanguageProxy languageProxy;

    public BookBean find(Long id ){
        return  booksProxy.find(id );
    }

    public String getTitle(String id){
        return booksProxy.find( id ).getTitle() ;
    }

    public List<BookBean> list(){

        try {
            return booksProxy.list();
        }catch (ResourceNotFoundException e){
            return null;
        }
    }

    public BookBean save(BookCreateBean book){

        book.setAuthor( authorProxy.find( book.getAuthor().getId() ) );
        book.setEdition( editionProxy.find( book.getEdition().getId() ) );
        book.setTheme( themeProxy.find( book.getTheme().getId() ) );
        book.setLanguage( languageProxy.find( book.getLanguage().getId() ) );

        return booksProxy.save( book );
    }

    public BookBean save(BookBean book){
        return booksProxy.update( book );
    }

    public boolean delete(Long id){
        return booksProxy.delete( id );
    }

    public boolean isAvailability(BookBean book){
        return ( book.getAvailability() > 0) ;
    }


}
