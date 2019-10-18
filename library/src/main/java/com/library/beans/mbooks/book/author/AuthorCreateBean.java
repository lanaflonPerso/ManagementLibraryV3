package com.library.beans.mbooks.book.author;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
public @Data class AuthorCreateBean {
    @NotBlank(message = "Le nom de l''auteur est obligatoire.")
    private String lastName;

    @NotBlank(message = "Le prénom de l''auteur est obligatoire.")
    private String firstName;
}
