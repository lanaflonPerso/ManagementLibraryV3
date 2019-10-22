package mbooks.repository;

import mbooks.model.Edition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEditionRepository extends JpaRepository<Edition,Long> {
}
