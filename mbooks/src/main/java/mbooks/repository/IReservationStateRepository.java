package mbooks.repository;

import mbooks.model.ReservationState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationStateRepository extends JpaRepository<ReservationState,Long> {
}
