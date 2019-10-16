package mbooks.controller.dto.books.cover;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class CoverUpdateDto {

    @Id
    private String id;

    @NotBlank(message = "Le nom de l''image est obligatoire.")
    private String fileName;

    @NotBlank(message = "Le type d''utilisation de l''image est obligatoire.")
    private String use;
}
