package com.library.service.mbooks.author;

import com.library.beans.mbooks.book.author.AuthorBean;
import com.library.beans.mbooks.book.author.AuthorCreateBean;
import com.library.exception.ResourceNotFoundException;
import com.library.proxies.IAuthorProxy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    private IAuthorProxy authorProxy;

    /**
     * Permet la recherche d'un auteur
     * @param id Idenitifiant de l'auteur à rechercher
     * @return Entity authorbean si trouvé sinon null
     */
    public AuthorBean find(Long id ){

        try {
            return  authorProxy.find(id );
        }catch (ResourceNotFoundException e){
            return null;
        }
    }

    /**
     * Permet la recherche de liste de tous les auteurs
     * @return Liste de tous les auteurs si trouvé sinon null
     */
    public List<AuthorBean> list(){

        try {
            return authorProxy.list();
        }catch (ResourceNotFoundException e){
            return null;
        }
    }

    /**
     * Permet la création d'un auteur
     * @param author Entity à créer
     * @return Entity authorbean
     */
    public AuthorBean save(AuthorCreateBean author){
        return authorProxy.save( author );
    }
    /**
     * Permet la modification d'un auteur
     * @param author Entity à modifier
     * @return Entity authorbean
     */
    public AuthorBean save(AuthorBean author){
        return authorProxy.update( author );
    }

    /**
     * Permet l'effacement d'un auteur
     * @param id Identifiant de l'auteur à effacer
     * @return true si l'effacement à pu se réaliser sinon false
     */
    public boolean delete(Long id){
        return authorProxy.delete( id );
    }

    /**
     * Permet de mettre en forme le nom complet d'un auteur
     * @param author Entity author à mettre en forme
     * @return Nom complet de l'auteur
     */
    public String fullAuthorName(AuthorBean author){
        return author.getFirstName() + ' ' + author.getLastName();
    }
}
