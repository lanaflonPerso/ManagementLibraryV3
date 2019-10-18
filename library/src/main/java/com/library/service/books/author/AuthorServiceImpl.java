package com.library.service.books.author;

import com.library.beans.mbooks.book.author.AuthorBean;
import com.library.beans.mbooks.book.author.AuthorCreateBean;
import com.library.proxies.IAuthorProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    private IAuthorProxy authorProxy;

    public AuthorBean find(Long id ){
        return  authorProxy.find(id );
    }

    public List<AuthorBean> list(){
        return authorProxy.list();
    }

    public AuthorBean save(AuthorCreateBean author){
        return authorProxy.save( author );
    }

    public AuthorBean save(AuthorBean author){
        return authorProxy.update( author );
    }

    public boolean delete(Long id){
        return authorProxy.delete( id );
    }
}
