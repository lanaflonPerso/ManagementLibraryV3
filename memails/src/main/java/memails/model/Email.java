package memails.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public @Data class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @Column(columnDefinition = "TEXT")
    private String subject;

    @NonNull
    @Column(columnDefinition = "TEXT")
    private String content;
}
