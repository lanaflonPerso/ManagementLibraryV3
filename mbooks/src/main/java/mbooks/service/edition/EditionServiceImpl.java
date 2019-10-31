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

    /**
     * Permet la recherche de la liste de tous les éditeurs
     * @return La liste de tous les éditeurs
     */
    public List<Edition> list(){return editionRepository.findAll();}

    /**
     * Permet la recherche d'un éditeur
     * @param id
     * @return
     */
    public Edition find(Long id){
        return editionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Editeur non trouvé avec l'id " + id ) );
    }

    /**
     * Permet la création ou la modiciation d'un éditeur
     * @param edition Entity edition à créer ou modifier
     * @return Entity edition
     */
    public Edition save(Edition edition){
        return editionRepository.save( edition );
    }

    /**
     * Permet l'effacement d'un éditeur
     * @param id Identifiant de l'éditeur à effacer
     * @return true si l'effacement a pu se réaliser sinon false
     */
    public boolean delete(Long id){
        try {
            editionRepository.deleteById( id );
            return true;
        }catch (DataIntegrityViolationException ee){
            return false;
        }
    }


}
