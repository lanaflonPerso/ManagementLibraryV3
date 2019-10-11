package mbooks.model.books;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import mbooks.model.lending.Lending;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public @Data class Books {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String isbn;

    @NonNull
    private String title;

    @NonNull
    @Column(columnDefinition = "TEXT")
    private String summary;

    @NonNull
    private Long review;

    @NonNull
    private Long availability;

    @ManyToOne
    @JoinColumn(name="id_cover", referencedColumnName="id")
    @NonNull
    private Cover cover;

    @ManyToMany
    @JoinTable(
            name="book_lending",
            joinColumns=@JoinColumn(name="isbn", referencedColumnName="isbn"),
            inverseJoinColumns=@JoinColumn(name="id_lending", referencedColumnName="id")
    )
    private List<Lending> lendingList;

    @ManyToOne
    @JoinColumn(name="id_language", referencedColumnName="id")
    @NonNull
    private Language language;

    @ManyToOne
    @JoinColumn(name="id_author", referencedColumnName="id")
    @NonNull
    private Author author;

    @ManyToOne
    @JoinColumn(name="id_theme", referencedColumnName="id")
    @NonNull
    private Theme theme;

}
