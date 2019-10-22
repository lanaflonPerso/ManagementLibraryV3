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

    public List<Theme> list(){return themeRepository.findAll();}

    public Theme find(Long id){
        return themeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Editeur non trouvé avec l'id " + id ) );
    }

    public Theme save(Theme theme){
        return themeRepository.save( theme );
    }

    public boolean delete(Long id){
        try {
            themeRepository.deleteById( id );
            return true;
        }catch (DataIntegrityViolationException ee){
            return false;
        }
    }
}
