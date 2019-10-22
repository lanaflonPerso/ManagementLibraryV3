package mbooks.service.edition;

import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.Edition;
import mbooks.repository.IEditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditionServiceImpl implements IEditionService {

    @Autowired
    private IEditionRepository editionRepository;

    public List<Edition> list(){return editionRepository.findAll();}

    public Edition find(Long id){
        return editionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Editeur non trouvé avec l'id " + id ) );
    }

    public Edition save(Edition edition){
        return editionRepository.save( edition );
    }

    public boolean delete(Long id){
        try {
            editionRepository.deleteById( id );
            return true;
        }catch (DataIntegrityViolationException ee){
            return false;
        }
    }


}
