package mbooks.model.books;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Hibernate :
 * Permet la création en base de données de la table Photo
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public @Data class Cover {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NonNull
    private String fileName;

    @NonNull
    private String fileType;

    @NonNull
    private String fileSize;

    @NonNull
    @Lob
    private byte[] data;

    @NonNull
    private String use;

    @OneToMany(mappedBy = "cover")
    private List<Books> bookList;



}
