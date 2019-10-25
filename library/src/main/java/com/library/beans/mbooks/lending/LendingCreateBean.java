package com.library.beans.mbooks.lending;

import com.library.beans.mbooks.book.BookBean;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
public @Data class LendingCreateBean {

    @NotNull(message = "L''utlisateur est obligatoire")
    private Long idUser;

    @NotNull(message = "Le choix du livre est obligatoire")
    private BookBean book;
}
