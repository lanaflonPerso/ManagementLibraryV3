package mbooks.controller.dto.books.language;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
public class LanguageUpdateDto {

    @Id
    private Long id;

    @NotEmpty(message = "Le nom de langue est obligatoire.")
    private String value;
}
