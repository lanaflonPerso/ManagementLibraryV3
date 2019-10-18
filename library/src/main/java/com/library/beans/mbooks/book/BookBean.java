package com.library.beans.mbooks.book;

import com.library.beans.mbooks.book.author.AuthorBean;
import com.library.beans.mbooks.book.language.LanguageBean;
import com.library.beans.mbooks.book.theme.ThemeBean;
import com.library.beans.mbooks.cover.CoverBean;
import com.library.beans.mbooks.lending.LendingBean;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
public  @Data class BookBean {

    private Long id;

    @NotBlank(message = "Le numéro ISBN est obligatoire.")
    private String isbn;

    @NotBlank(message = "Le titre du livre est obligatoire.")
    private String title;

    @NotBlank(message = "Le résumé du livre est obligaoire")
    private String summary;

    @NotBlank(message ="Le nombre d'examplaire est obligatoire.")
    private Long review;

    @NotBlank(message = "Le nombre de livre disponible est obligatoire.")
    private Long availability;

    @NotNull(message = "Le choix de la couverture est obligatoire.")
    private CoverBean cover;

    @NotNull(message = "Le choix du langage est obligatoire.")
    private LanguageBean language;

    @NotNull(message = "Le choix de l''auteut est obligatoire.")
    private AuthorBean author;

    @NotNull(message = "Le choix du thème est obligatoire.")
    private ThemeBean theme;

    private List<LendingBean> lendingList;

}
