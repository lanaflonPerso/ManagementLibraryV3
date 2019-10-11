package musers.controller.dto.city;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class CityDto {

    @Id
    @NotEmpty(message = "Le code insee est obligatoire.")
    private String insee;

    @NotEmpty(message = "Le code postal est obligatoire.")
    private String postalCode;

    @NotEmpty(message = "Le nom de la commune est obligatoire.")
    private String name;
}
