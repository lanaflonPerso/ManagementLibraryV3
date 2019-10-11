package memails.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
public class EmailCreateDto {
    @NotEmpty(message = "Le nom du message est obligatoire.")
    private String name;

    @NotEmpty(message = "L''objet du message est obligatoire.")
    private String objet;

    @NotEmpty(message = "Le contenu du message est obligatoire.")
    private String content;
}
