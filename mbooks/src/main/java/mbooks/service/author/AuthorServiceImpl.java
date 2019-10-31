package mbooks.service.author;


import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.Author;
import mbooks.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    private IAuthorRepository authorRepository;

    /**
     * Permet la recherche de la liste de tous les auteurs
     * @return la liste de tous les auteurs
     */
    public List<Author> list(){return authorRepository.findAll();}

    /**
     * Permet de rechercher un auteur
     * @param id Identifiant de l'auteur que l'on recherche
     * @return L'entity Author
     */
    public Author find(Long id){
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Auteur non trouvé avec l'id " + id ) );
    }

    /**
     * Permet la sauvegarde de la création ou de la modificaiton d'un auteur.
     * @param author Entity Author à créér ou à modifier
     * @return L'entity Author
     */
    public Author save(Author author){
        return authorRepository.save( author );
    }

    /**
     * Permet l'effacement d'un auteur
     * @param id Identifiant de l'auteur à effacer
     * @return true si l'effacement a pu se faire sinon false
     */
    public boolean delete(Long id){
        try {
            authorRepository.deleteById( id );
            return true;
        }catch (DataIntegrityViolationException ee){
            return false;
        }
    }
}
