package mbooks.service.books.author;


import mbooks.model.books.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> list();
    Author find(Long id);
    Author save(Author author);
    boolean delete(Long id);
}
