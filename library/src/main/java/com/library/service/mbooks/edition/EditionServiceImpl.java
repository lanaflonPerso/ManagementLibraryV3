package com.library.service.mbooks.edition;

import com.library.beans.mbooks.book.edition.EditionBean;
import com.library.beans.mbooks.book.edition.EditionCreateBean;
import com.library.exception.ResourceNotFoundException;
import com.library.proxies.IEditionProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditionServiceImpl implements IEditionService {

    @Autowired
    private IEditionProxy editionProxy;

    /**
     * Permet la recherhe d'un éditeur
     * @param id Identifiant de l'éditeur à rechercher
     * @return Entity EditionBean si trouvé sinon null
     */
    public EditionBean find(Long id ){

        try {
            return  editionProxy.find(id );
        }catch (ResourceNotFoundException e){
            return null;
        }
    }

    /**
     * Permet la recherche de la liste de tous les éditeurs
     * @return La liste de tous les éditeurs si trouvé sinon null
     */
    public List<EditionBean> list(){

        try {
            return editionProxy.list();
        }catch (ResourceNotFoundException e){
            return null;
        }
    }

    /**
     * Permet la création d'un éditeur
     * @param edition Entity à créer
     * @return Entity edition
     */
    public EditionBean save(EditionCreateBean edition){
        return editionProxy.save( edition );
    }

    /**
     * Permet la modification d'un éditeur
     * @param edition Entity à modifier
     * @return Entity edition
     */
    public EditionBean save(EditionBean edition){
        return editionProxy.update( edition );
    }

    /**
     * Permet l'effacement d'un éditeur
     * @param id Identifiant de l'éditeur à effacer
     * @return true si l'effacement à pu se réaliser sinon false
     */
    public boolean delete(Long id){
        return editionProxy.delete( id );
    }
}
