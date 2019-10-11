package mbooks.repository.book;


import mbooks.model.books.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBooksRepository extends JpaRepository<Books,Long> {
}
