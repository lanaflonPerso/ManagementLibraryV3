package mbooks.controller.dto.lending;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class LendingCreateDto {

    @NotNull(message = "L''utilisateur est obligatoire.")
    private Long idUser;

}
