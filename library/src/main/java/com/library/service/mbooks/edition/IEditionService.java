package com.library.service.mbooks.edition;

import com.library.beans.mbooks.book.edition.EditionBean;
import com.library.beans.mbooks.book.edition.EditionCreateBean;

import java.util.List;

public interface IEditionService {

    EditionBean find(Long id );
    List<EditionBean> list();

    EditionBean save(EditionCreateBean edition);
    EditionBean save(EditionBean edition);

    boolean delete(Long id);
}
