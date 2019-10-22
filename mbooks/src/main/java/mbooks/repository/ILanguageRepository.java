package mbooks.repository;


import mbooks.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILanguageRepository extends JpaRepository<Language,Long> {
}
