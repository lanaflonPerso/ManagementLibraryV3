package mbooks.service.books.author;


import mbooks.model.books.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> findAll();
    void save(Author author);
}
