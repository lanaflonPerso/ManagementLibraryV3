package mbooks.service.reservation;

import mbooks.model.ReservationState;
import mbooks.repository.IReservationStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationStateServiceImpl implements IReservationStateService {

    @Autowired
    private IReservationStateRepository reservationStateRepository;

    public ReservationState find(Long id){
       return reservationStateRepository.getOne( id );
    }

    public List<ReservationState> list(){
        return  reservationStateRepository.findAll();
    }

    public ReservationState save(ReservationState reservationState){
        return reservationStateRepository.save( reservationState );
    }

    public boolean delete(Long id){
        try {
            reservationStateRepository.deleteById( id );
            return true;
        }catch (DataIntegrityViolationException ee){
            return false;
        }
    }
}
