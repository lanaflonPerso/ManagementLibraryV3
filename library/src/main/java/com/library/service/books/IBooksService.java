package com.library.service.books;

import com.library.beans.mbooks.book.BookBean;
import com.library.beans.mbooks.book.BookCreateBean;

import java.util.List;

public interface IBooksService {
    BookBean find(Long id );
    List<BookBean> list();
    BookBean save(BookCreateBean book);
    BookBean save(BookBean book);
    boolean delete(Long id);

}
