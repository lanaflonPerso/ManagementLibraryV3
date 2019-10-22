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

    public List<Author> list(){return authorRepository.findAll();}

    public Author find(Long id){
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Editeur non trouvé avec l'id " + id ) );
    }

    public Author save(Author author){
        return authorRepository.save( author );
    }

    public boolean delete(Long id){
        try {
            authorRepository.deleteById( id );
            return true;
        }catch (DataIntegrityViolationException ee){
            return false;
        }
    }
}
