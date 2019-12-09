package mbooks.service.reservation;

import mbooks.model.ReservationState;

import java.util.List;

public interface IReservationStateService {
    ReservationState find(Long id);

    List<ReservationState> list();

    ReservationState save(ReservationState reservationState);

    boolean delete(Long id);
}
