package mbooks.service.language;

import mbooks.model.Language;

import java.util.List;

public interface ILanguageService {

    Language find(Long id);
    List<Language> list();
    Language save(Language language);
    boolean delete(Long id);
}
