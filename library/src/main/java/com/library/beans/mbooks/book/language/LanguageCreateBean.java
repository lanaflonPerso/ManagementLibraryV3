package com.library.beans.mbooks.book.language;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
public @Data class LanguageCreateBean {
    @NotBlank(message = "Le langage est obligatoire.")
    private String value;
}
