package mbooks.service.author;


import mbooks.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> list();
    Author find(Long id);
    Author save(Author author);
    boolean delete(Long id);
}
