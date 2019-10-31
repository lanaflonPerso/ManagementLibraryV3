package com.mfile.service;


import com.mfile.config.ApplicationPropertiesConfig;
import com.mfile.exceptions.MyFileNotFoundException;
import com.mfile.model.Cover;
import com.mfile.repository.ICoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CoverServiceImpl implements ICoverService {

    @Autowired
    private ICoverRepository coverRepository;

    @Autowired
    private ApplicationPropertiesConfig appPropertiesConfig;


    /**
     * Permet la récupération de toutes les images de couvertures
     * @return La liste de tous les images de couverture
     */
    public List<Cover> findAll(){ return coverRepository.findAll() ;}

    /**
     * Permet la création ou la modification de l'image d'une couverture de livre
     * @param cover Entity cover à créer ou à modifier
     * @return Entity cover
     */
    public Cover save(Cover cover) {
        if( cover.getUse() == ""  )
            cover.setUse( appPropertiesConfig.getCoverUse() );

        return coverRepository.save( cover );

    }

    /**
     * permet la récherche l'image de la couverture d'un livre
     * @param id Identifiant de l'image à rechercher
     * @return Entity cover
     */
    public Cover find(String id ) {
        return coverRepository.findById( id )
                .orElseThrow(() -> new MyFileNotFoundException("Fichier non trouvé avec l'id " + id ));
    }

    /**
     * Permet l'effacement de l'image de la couverture d'un livre
     * @param id Identifiant de l'image à effacer
     * @return true si l'effacement a pu se réaliser sinon false
     */
    public boolean delete(String id){
        try {
            coverRepository.deleteById( id );
            return true;
        }catch (DataIntegrityViolationException ee){
            return false;
        }
    }

}
