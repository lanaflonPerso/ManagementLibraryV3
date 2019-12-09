package mbooks.repository;

import mbooks.model.Books;
import mbooks.model.Reservation;
import mbooks.model.ReservationState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation,Long> {

   List< Reservation > findAllByReservationStateOrderByReservationDate(ReservationState reservationState );

   List< Reservation > findAllByBookAndReservationStateOrderByReservationDate(Books books, ReservationState reservationState );

   List< Reservation > findAllByIdUserReservationAndReservationStateOrderByReservationDate(Long idUserReservation, ReservationState reservationState );
}
