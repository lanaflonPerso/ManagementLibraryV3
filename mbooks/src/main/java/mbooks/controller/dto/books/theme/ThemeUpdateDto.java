package mbooks.controller.dto.books.theme;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
public class ThemeUpdateDto {

    @Id
    private Long id;

    @NotEmpty(message = "Le thème est obligatoire.")
    private String value;
}
