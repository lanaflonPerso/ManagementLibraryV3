package mbooks.service.reservation;

import mbooks.config.ApplicationPropertiesConfig;
import mbooks.model.Books;
import mbooks.model.Reservation;
import mbooks.model.ReservationState;
import mbooks.repository.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
    private IReservationRepository reservationRepository;

    @Autowired
    private ApplicationPropertiesConfig appProperties;

    @Autowired
    private ReservationStateServiceImpl reservationStateService;

    public Reservation find(Long id){
        return  reservationRepository.getOne( id );
    }

    public List<Reservation> list(){
        return reservationRepository.findAll();
    }

    public List<Reservation> listInprogress(){
        ReservationState reservationState = reservationStateService.find( appProperties.getReservationInprogress() );
        return reservationRepository.findAllByReservationStateOrderByReservationDate( reservationState );
    }

    public List<Reservation> listCanceled(){
        ReservationState reservationState = reservationStateService.find( appProperties.getReservationCanceled() );
        return reservationRepository.findAllByReservationStateOrderByReservationDate( reservationState );
    }

    public List<Reservation> listCompleted(){
        ReservationState reservationState = reservationStateService.find( appProperties.getReservationCompleted() );
        return reservationRepository.findAllByReservationStateOrderByReservationDate( reservationState );
    }

    public List<Reservation> listInprogress(Books books){
        ReservationState reservationState = reservationStateService.find( appProperties.getReservationInprogress() );
        return reservationRepository.findAllByBookAndReservationStateOrderByReservationDate( books,reservationState );
    }

    public List<Reservation> listInprogress(Long idUserReservation){
        ReservationState reservationState = reservationStateService.find( appProperties.getReservationInprogress() );
        return reservationRepository.findAllByIdUserReservationAndReservationStateOrderByReservationDate(idUserReservation,reservationState );
    }

    public List<Reservation> listCanceled(Books books){
        ReservationState reservationState = reservationStateService.find( appProperties.getReservationCanceled() );
        return reservationRepository.findAllByBookAndReservationStateOrderByReservationDate( books,reservationState );
    }

    public List<Reservation> listCanceled(Long idUserReservation){
        ReservationState reservationState = reservationStateService.find( appProperties.getReservationCanceled() );
        return reservationRepository.findAllByIdUserReservationAndReservationStateOrderByReservationDate(idUserReservation,reservationState );
    }

    public List<Reservation> listCompleted(Books books){
        ReservationState reservationState = reservationStateService.find( appProperties.getReservationCompleted() );
        return reservationRepository.findAllByBookAndReservationStateOrderByReservationDate( books,reservationState );
    }

    public List<Reservation> listCompleted(Long idUserReservation){
        ReservationState reservationState = reservationStateService.find( appProperties.getReservationCompleted() );
        return reservationRepository.findAllByIdUserReservationAndReservationStateOrderByReservationDate(idUserReservation,reservationState );
    }

    public Reservation save(Reservation reservation){

        return  reservationRepository.save( reservation );
    }

    public boolean delete(Long id){
        try {
            reservationRepository.deleteById( id );
            return true;
        }catch (DataIntegrityViolationException ee){
            return false;
        }
    }

}
