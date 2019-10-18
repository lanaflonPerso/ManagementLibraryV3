package mbooks.service.books.theme;

import mbooks.model.books.Theme;

import java.util.List;

public interface IThemeService {

    Theme find(Long id);
    List<Theme> list();
    Theme save(Theme theme);
    boolean delete(Long id);

}

