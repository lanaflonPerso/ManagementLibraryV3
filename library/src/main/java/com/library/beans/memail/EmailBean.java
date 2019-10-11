package com.library.beans.memail;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class EmailBean {

    private Long id;

    private String name;

    private String objet;

    private String content;
}
