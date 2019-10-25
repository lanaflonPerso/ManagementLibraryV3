package mbooks.controller.dto.lending;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mbooks.model.Books;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class LendingCreateDto {

    @NotNull(message = "L''utilisateur est obligatoire.")
    private Long idUser;

    @NotNull(message = "Le livre est obligatoire.")
    private Books book;

}
