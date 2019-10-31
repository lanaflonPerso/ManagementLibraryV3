package mbooks.service.language;

import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.Language;
import mbooks.repository.ILanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements ILanguageService  {

    @Autowired
    private ILanguageRepository languageRepository;

    /**
     * Permet la recherche d'une langue
     * @param id Identifiant de la langue à chercher
     * @return Entity Language
     */
    public Language find(Long id){
        return languageRepository.findById( id )
                .orElseThrow(() -> new ResourceNotFoundException("Langage non trouvé avec l'id " + id ) );
    }

    /**
     * Permet la recherche de la liste de toutes les langues
     * @return Liste de toutes les langues
     */
    public List<Language> list(){
        return languageRepository.findAll();
    }

    /**
     * Permet la création ou la modification d'un langue
     * @param language Entity language à créer ou à modifier
     * @return Entity language
     */
    public Language save (Language language){ return languageRepository.save(language);
    }

    /**
     * Permet l'effacement d'une langue
     * @param id Identifiant de la langue à effacer
     * @return true si l'effacement à pu se  réaliser sinon false
     */
    public boolean delete(Long id){
        try {
            languageRepository.deleteById( id );
            return true;
        }catch (DataIntegrityViolationException ee){
            return false;
        }
    }
}
