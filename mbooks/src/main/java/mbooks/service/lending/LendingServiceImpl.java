package mbooks.service.lending;

import mbooks.config.ApplicationPropertiesConfig;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.Books;
import mbooks.model.Lending;
import mbooks.repository.ILendingRepository;
import mbooks.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Service
public class LendingServiceImpl implements ILendingService {

    @Autowired
    private ILendingRepository lendingRepository;

    @Autowired
    private IBooksService booksService;

    @Autowired
    private ApplicationPropertiesConfig appPropertiesConfig;

    public void renewal(Long id){
    Lending lending = this.find( id );

        if(lending.getRenewal() < appPropertiesConfig.getRenewalNumber() ){
            lending.setRenewal( lending.getRenewal() + 1);
            Calendar c = Calendar.getInstance();
            c.setTime( lending.getEndDate() );
            c.add(Calendar.DAY_OF_MONTH, appPropertiesConfig.getRenewalDay() );
            lending.setEndDate( c.getTime() );
            lendingRepository.save( lending );
        }
    }

    public Lending find(Long id){
        return lendingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prêt non trouvé avec l'id " + id ) );
    }

    public List<Lending> list(){
        return lendingRepository.findAll();
    }

    public List<Lending> list(String isbn){
        Books book = booksService.find( isbn );
        return  lendingRepository.findAllByBook( book );
    }

    public List<Lending> list(Long idUser){
        return lendingRepository.findAllByIdUser( idUser );
    }

    public Lending  save(Lending lending){ return lendingRepository.save( lending ); }

    public boolean delete(Long id){
        try {
            lendingRepository.deleteById( id );
            return true;
        }catch (DataIntegrityViolationException ee){
            return false;
        }
    }
}
