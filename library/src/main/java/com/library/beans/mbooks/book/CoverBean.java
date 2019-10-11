package com.library.beans.mbooks.book;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
public  @Data class CoverBean {

    private String id;

    private String fileName;

    private String fileType;

    private byte[] data;

    private String use;

    private List<BookBean> bookList;
}
