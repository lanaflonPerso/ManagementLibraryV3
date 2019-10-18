package com.library.beans.mbooks.book.edition;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
public @Data class EditionCreateBean {

    @NotBlank(message = "Le nom de l''éditeur est obligatoire.")
    private String name;
}
