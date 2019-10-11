package com.library.beans.mbooks.book;


import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@NoArgsConstructor

public  @Data class ThemeBean {

    private Long id;

    private String value;

    private List<BookBean> bookList;
}
