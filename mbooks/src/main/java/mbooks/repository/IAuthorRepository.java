package mbooks.repository;


import mbooks.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author,Long> {
}
