package com.library.service.mbooks.theme;

import com.library.beans.mbooks.book.theme.ThemeBean;
import com.library.beans.mbooks.book.theme.ThemeCreateBean;

import java.util.List;

public interface IThemeService {

    ThemeBean find(Long id );
    List<ThemeBean> list();

    ThemeBean save(ThemeCreateBean theme);
    ThemeBean save(ThemeBean theme);

    boolean delete(Long id);
}
