package com.library.beans.mbooks.book.author;

import com.library.beans.mbooks.book.BookBean;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
public @Data class AuthorBean {
    private Long id;

    @NotBlank(message = "Le nom de l''auteur est obligatoire.")
    private String lastName;

    @NotBlank(message = "Le prénom de l''auteur est obligatoire.")
    private String firstName;


}
