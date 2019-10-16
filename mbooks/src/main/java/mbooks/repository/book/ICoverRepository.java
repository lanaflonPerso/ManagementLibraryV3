package mbooks.repository.book;




import mbooks.model.books.Cover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JPA Initialisation de l'entity Photo
 */
@Repository
public interface ICoverRepository extends JpaRepository<Cover, Long> {


    List<Cover> findAllByUseIs(String use);
}
