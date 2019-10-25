package mbooks.service.lending;

import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.Books;
import mbooks.model.Lending;
import mbooks.repository.ILendingRepository;
import mbooks.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LendingServiceImpl implements ILendingService {

    @Autowired
    private ILendingRepository lendingRepository;

    @Autowired
    private IBooksService booksService;

    public Lending find(Long id){
        return lendingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livre non trouvé avec l'id " + id ) );
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
