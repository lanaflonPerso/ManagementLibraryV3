package com.library.service.mbooks.language;

import com.library.beans.mbooks.book.language.LanguageBean;
import com.library.beans.mbooks.book.language.LanguageCreateBean;
import com.library.exception.ResourceNotFoundException;
import com.library.proxies.ILanguageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements ILanguageService {

    @Autowired
    private ILanguageProxy languageProxy;

    /**
     * Permet la recherche d'une langue
     * @param id identifiant de la langue recherchée
     * @return Entity language si trouvé sinon null
     */
    public LanguageBean find(Long id ){

        try {
            return  languageProxy.find(id );
        }catch (ResourceNotFoundException e){
            return null;
        }
    }

    /**
     * Permet la recherche de la liste de tous les langues
     * @return La liste de toutes les langues si trouvé sinon null
     */
    public List<LanguageBean> list(){

        try {
            return languageProxy.list();
        }catch (ResourceNotFoundException e){
            return null;
        }
    }

    /**
     * Permet la création d'une langue
     * @param language Entity à créer
     * @return Entity language
     */
    public LanguageBean save(LanguageCreateBean language){
        return languageProxy.save( language );
    }

    /**
     * Permet la modification d'une langue
     * @param language Entity à modifier
     * @return Entity language
     */
    public LanguageBean save(LanguageBean language){
        return languageProxy.update( language );
    }

    /**
     * Permet l'effacement d'une langue
     * @param id Idenitifiant de la langue à effacer
     * @return true si l'effacer à pu se réaliser sinon false
     */
    public boolean delete(Long id){
        return languageProxy.delete( id );
    }
}
