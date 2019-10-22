package com.mlending.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class LendingCreateDto {

    @NotNull(message = "L''utilisateur est obligatoire.")
    private Long idUser;

    @NotBlank(message = "Le livre est obligatoire.")
    private String isbn;

}
