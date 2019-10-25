package mbooks.repository;


import mbooks.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBooksRepository extends JpaRepository<Books,Long> {
    Books findByIsbn(String isbn);
}
