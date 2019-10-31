package mbooks.service.theme;


import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.Theme;
import mbooks.repository.IThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements IThemeService {

    @Autowired
    private IThemeRepository themeRepository;

    /**
     * Permet de rechercher la liste de tous les thèmes de livre
     * @return La liste de tous les thèmes de  livre
     */
    public List<Theme> list(){return themeRepository.findAll();}

    /**
     * Permet la recherche d'un thème de livre
     * @param id Identifiant du thème
     * @return Entity theme si le thème est existant
     */
    public Theme find(Long id){
        return themeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Editeur non trouvé avec l'id " + id ) );
    }

    /**
     * Permet la création ou la modification d'un thème de livre
     * @param theme Entity theme à créer ou à modifier
     * @return Entity theme
     */
    public Theme save(Theme theme){
        return themeRepository.save( theme );
    }

    /**
     * Permet l'effacement d'un thème
     * @param id Identifiant du thème à effacer
     * @return true si l'effacement à pu se réaliser sinon false
     */
    public boolean delete(Long id){
        try {
            themeRepository.deleteById( id );
            return true;
        }catch (DataIntegrityViolationException ee){
            return false;
        }
    }
}
