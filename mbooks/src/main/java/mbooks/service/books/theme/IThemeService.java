package mbooks.service.books.theme;

import mbooks.model.books.Theme;

import java.util.List;

public interface IThemeService {
    List<Theme> findAll();
    void save(Theme theme);
}

