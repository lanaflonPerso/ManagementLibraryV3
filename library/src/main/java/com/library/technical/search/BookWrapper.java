package com.library.technical.search;

import com.library.beans.mbooks.book.BookBean;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BookWrapper {
    List<BookBean> bookBeanList;
}
