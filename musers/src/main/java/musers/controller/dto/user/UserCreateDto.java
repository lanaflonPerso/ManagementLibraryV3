package musers.controller.dto.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import musers.technical.fieldmatch.FieldMatch;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "Les mots de passe doivent correspondre"),
        @FieldMatch(first = "email", second = "confirmEmail", message = "Les E-mails doivent correspondre")
})
@Getter
@Setter
@NoArgsConstructor
public class UserCreateDto {

    @NotEmpty(message = "Le nom est obligatoire")
    private String nom;

    @NotEmpty(message = "Le prénom est obligatoire")
    private String prenom;

    @NotEmpty(message = "Le numéro de téléphone est obligatoire")
    private String telephone;

    @NotEmpty(message = "Le mot de passe est obligatoire")
    private String password;


    @NotEmpty(message = "Le mot de passe est obligatoire")
    private String confirmPassword;

    @Email
    @NotEmpty(message = "L''adresse eMail est obligatoire")
    private String email;

    @Email
    @NotEmpty(message = "L''adresse eMail est obligatoire")
    private String confirmEmail;

    @AssertTrue(message = "Vous devez confirmer votre accord.")
    private Boolean terms;





}