package mbooks.service.books.language;

import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.books.Language;
import mbooks.repository.book.ILanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements ILanguageService  {

    @Autowired
    private ILanguageRepository languageRepository;

    public Language find(Long id){
        return languageRepository.findById( id )
                .orElseThrow(() -> new ResourceNotFoundException("Langage non trouvé avec l'id " + id ) );
    }

    public List<Language> list(){
        return languageRepository.findAll();
    }

    public Language save (Language language){ return languageRepository.save(language);
    }

    public boolean delete(Long id){
        try {
            languageRepository.deleteById( id );
            return true;
        }catch (DataIntegrityViolationException ee){
            return false;
        }
    }
}
