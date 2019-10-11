package musers.controller.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import musers.technical.fieldmatch.FieldMatch;

import javax.validation.constraints.NotEmpty;

@FieldMatch.List({
        @FieldMatch(first = "newPassword", second = "confirmPassword", message = "Les mots de passe doivent correspondre")
})
@Getter
@Setter
@NoArgsConstructor
public class UserPasswordUpdateDto {

    @NotEmpty(message = "Le mot de passe est obligatoire")
    private String oldPassword;

    @NotEmpty(message = "Le mot de passe est obligatoire")
    private String newPassword;


    @NotEmpty(message = "Le mot de passe est obligatoire")
    private String confirmPassword;
}
