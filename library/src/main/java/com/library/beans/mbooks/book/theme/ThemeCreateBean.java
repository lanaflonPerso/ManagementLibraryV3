package com.library.beans.mbooks.book.theme;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
public @Data class ThemeCreateBean {
    @NotBlank(message = "Le thème est obligatoire.")
    private String value;
}
