package mbooks.repository.book;


import mbooks.model.books.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILanguageRepository extends JpaRepository<Language,Long> {
}
