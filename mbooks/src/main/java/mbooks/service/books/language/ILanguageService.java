package mbooks.service.books.language;

import mbooks.model.books.Language;

import java.util.List;

public interface ILanguageService {
    List<Language> findAll();
    void save(Language language);
}
