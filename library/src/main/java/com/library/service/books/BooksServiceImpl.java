package com.library.service.books;

import com.library.beans.mbooks.book.BookBean;
import com.library.beans.mbooks.book.BookCreateBean;
import com.library.proxies.IBooksProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements IBooksService {

    @Autowired
    private IBooksProxy booksProxy;

    public BookBean find(Long id ){
        return  booksProxy.find(id );
    }

    public List<BookBean> list(){
        return booksProxy.list();
    }

    public BookBean save(BookCreateBean book){
        return booksProxy.save( book );
    }

    public BookBean save(BookBean book){
        return booksProxy.update( book );
    }

    public boolean delete(Long id){
        return booksProxy.delete( id );
    }
}
