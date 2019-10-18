package mbooks.service.books;


import mbooks.model.books.Books;

import java.util.List;

public interface IBooksService {
    Books find(Long id);
    List<Books> list();
    Books save(Books book);
    boolean delete(Long id);
}
