package mbooks.service.theme;

import mbooks.model.Theme;

import java.util.List;

public interface IThemeService {

    Theme find(Long id);
    List<Theme> list();
    Theme save(Theme theme);
    boolean delete(Long id);

}

