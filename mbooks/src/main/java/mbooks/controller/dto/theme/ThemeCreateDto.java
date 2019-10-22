package mbooks.controller.dto.theme;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
public class ThemeCreateDto {
    @NotEmpty(message = "Le thème est obligatoire.")
    private String value;
}
