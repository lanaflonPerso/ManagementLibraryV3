package mbooks.controller.dto.edition;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class EditionCreateDto {
    @NotBlank(message = "Le nom de l''éditeur est obligatoire.")
    private String name;
}
