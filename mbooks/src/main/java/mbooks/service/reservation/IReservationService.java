package mbooks.service.reservation;

import mbooks.model.Books;
import mbooks.model.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation find(Long id);

    List<Reservation> list();

    List<Reservation> listInprogress();

    List<Reservation> listCanceled();

    List<Reservation> listCompleted();

    List<Reservation> listInprogress(Books books);

    List<Reservation> listInprogress(Long idUserReservation);

    List<Reservation> listCanceled(Books books);

    List<Reservation> listCanceled(Long idUserReservation);

    List<Reservation> listCompleted(Books books);

    List<Reservation> listCompleted(Long idUserReservation);

    Reservation save(Reservation reservation);

    boolean delete(Long id);
}
