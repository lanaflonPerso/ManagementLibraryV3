package mbooks.controller.dto.books;

import com.books.model.book.Cover;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class BooksCreateDto {
    @Id
    @NotEmpty(message = "Le numéro isbn est obligatoire.")
    private String isbn;

    @NotEmpty(message = "Le titre est obligatoire.")
    private String title;

    @NotEmpty(message = "Le resumé du livre est obligatoire")
    private String summary;

    @NotNull(message = "Le nombre d''éxamplaire est obligatoire.")
    private Long review;

    @NotNull(message = "Le nombre d''examplaire disponible est obligatoire.")
    private Long availability;

    @NotNull
    private Cover cover;
}
