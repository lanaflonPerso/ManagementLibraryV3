package mbooks.repository.book;

import mbooks.model.books.Edition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEditionRepository extends JpaRepository<Edition,Long> {
}
