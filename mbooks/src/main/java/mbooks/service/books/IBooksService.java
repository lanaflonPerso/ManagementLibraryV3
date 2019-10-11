package mbooks.service.books;


import mbooks.model.books.Books;

import java.util.List;

public interface IBooksService {
    List<Books> findAll();
    void  save(Books book);
}
