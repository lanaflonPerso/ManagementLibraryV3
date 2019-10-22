package mbooks.controller.dto.author;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
public class AuthorCreateDto {
    @NotEmpty(message = "Le nom est obligatoire.")
    private String lastName;

    @NotEmpty(message = "Le prénom est obligatoire.")
    private String firstName;
}
