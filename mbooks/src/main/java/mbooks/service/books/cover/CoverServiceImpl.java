package mbooks.service.books.cover;

import mbooks.config.ApplicationPropertiesConfig;
import mbooks.exceptions.MyFileNotFoundException;
import mbooks.model.books.Cover;
import mbooks.repository.book.ICoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Gestion du téléchargement des images et du caroussel d'image de la page d'accueil
 *
 */
@Service
public class CoverServiceImpl implements ICoverService {

    @Autowired
    private ICoverRepository coverRepository;

    @Autowired
    private ApplicationPropertiesConfig appPropertiesConfig;


    public List<Cover> findAll(String coverUse ){ return coverRepository.findAllByUseIs(coverUse ); }

    public List<Cover> findAll(){ return coverRepository.findAll() ;}


    public Cover save(Cover cover) {
        if( cover.getUse() == ""  )
            cover.setUse( appPropertiesConfig.getCoverUse() );

        return coverRepository.save( cover );

    }


    public Cover getCover(String id ) {
        return coverRepository.findById( id )
                .orElseThrow(() -> new MyFileNotFoundException("Fichier non trouvé avec l'id " + id ));
    }

    public boolean delete(String id){
        try {
            coverRepository.deleteById( id );
            return true;
        }catch (DataIntegrityViolationException ee){
            return false;
        }
    }

}
