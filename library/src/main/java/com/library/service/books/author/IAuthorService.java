package com.library.service.books.author;

import com.library.beans.mbooks.book.author.AuthorBean;
import com.library.beans.mbooks.book.author.AuthorCreateBean;

import java.util.List;

public interface IAuthorService {

    AuthorBean find(Long id );
    List<AuthorBean> list();

    AuthorBean save(AuthorCreateBean author);
    AuthorBean save(AuthorBean author);

    boolean delete(Long id);
}
