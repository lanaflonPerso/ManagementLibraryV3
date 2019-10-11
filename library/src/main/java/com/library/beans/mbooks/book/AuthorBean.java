package com.library.beans.mbooks.book;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
public @Data class AuthorBean {
    private Long id;

    private String lastName;

    private String firstName;

    private List<BookBean> bookList;
}
