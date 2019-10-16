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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NonNull
    private String fileName;

    @NonNull
    private String use;

    @OneToMany(mappedBy = "cover")
    private List<Books> bookList;



}
