package com.mfile.controller.dto.cover;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class CoverUpdateDto {

    @Id
    private String id;

    @NotBlank(message = "Le nom de l''image est obligatoire.")
    private String fileName;

    @NotBlank(message = "Le type d''image est obligatoire.")
    private String fileType;

    @NotBlank(message = "La taille de l''image est obligatoire.")
    private String fileSize;

    @NotBlank(message = "L''image est obligatoire.")
    private byte[] data;

    @NotBlank(message = "Le type d''utilisation de l''image est obligatoire.")
    private String use;
}
