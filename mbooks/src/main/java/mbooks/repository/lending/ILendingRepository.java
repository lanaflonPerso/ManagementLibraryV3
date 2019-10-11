package mbooks.repository.lending;


import mbooks.model.lending.Lending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILendingRepository extends JpaRepository<Lending,Long> {
}
