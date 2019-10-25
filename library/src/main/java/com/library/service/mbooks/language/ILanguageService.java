package com.library.service.mbooks.language;

import com.library.beans.mbooks.book.language.LanguageBean;
import com.library.beans.mbooks.book.language.LanguageCreateBean;

import java.util.List;

public interface ILanguageService {

    LanguageBean find(Long id );
    List<LanguageBean> list();

    LanguageBean save(LanguageCreateBean language);
    LanguageBean save(LanguageBean language);

    boolean delete(Long id);
}
