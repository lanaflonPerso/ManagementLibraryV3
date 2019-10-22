package com.library.beans.mbooks.cover;

import com.library.beans.mbooks.book.BookBean;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public  @Data class CoverBean {

    @Id
    private String id;

    @NotBlank(message = "Le nom de l''image est obligatoire.")
    private String fileName;

    @NotBlank(message = "Le type d''image est obligatoire.")
    private String fileType;

    @NotBlank(message = "La taille de l''image est obligatoire.")
    private Long fileSize;

    @NotBlank(message = "L''image est obligatoire.")
    private byte[] data;

    @NotBlank(message = "Le type d''utilisation de l''image est obligatoire.")
    private String use;

    private List<BookBean> bookList;
}
