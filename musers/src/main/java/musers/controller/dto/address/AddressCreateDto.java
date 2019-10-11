package musers.controller.dto.address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class AddressCreateDto {

    @NotEmpty(message = "Le numero de la voie est obbligatoire.")
    private Long streetNumber;

    @NotEmpty(message = "Le complément du numéro de voie est obligatoire.")
    private String complementStreetNumber;

    @NotEmpty(message = "Le type de voie est obligatoire.")
    private String streetType;

    @NotEmpty(message = "Le nom de la voie est obligatoire.")
    private String street;

    @NotEmpty(message = "Le complément de voie est obligatoire.")
    private String complementStreet;

    @NotEmpty(message = "La lattitude obligatoire.")
    private String lattitude;

    @NotEmpty(message = "La longitude est obligatoire.")
    private String longitude;
}
