package com.library.service.mbooks.cover;


import com.library.beans.mbooks.cover.CoverCreateBean;
import com.library.config.ApplicationPropertiesConfig;
import com.library.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Gestion du téléchargement des images et du caroussel d'image de la page d'accueil
 *
 */
@Service
public class CoverServiceImpl implements ICoverService {


    @Autowired
    private ApplicationPropertiesConfig appPropertiesConfig;



    /**
     * Gère la sauvegarde du fichier en base de données. On vérifie si le fichier est existant et dans le cas contraire
     * le fichier est sauvegardé dans la base de données
     * @param file le fichier à sauvegarder
     *
     * @return On retourne le fichier si présent en base de données
     * sinon on retourne le nouveau fichier : (entity) Photo
     */
    public CoverCreateBean storeFile(MultipartFile file)  {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if( fileName.contains("..") )  throw new FileStorageException("Le chemin d'accès au fichier "+ fileName + " est invalide.");

            String contentType = file.getContentType();
            byte[] data = file.getBytes();

           CoverCreateBean coverCreateBean = new CoverCreateBean();
           coverCreateBean.setFileName( fileName );
           coverCreateBean.setFileType( contentType );
           coverCreateBean.setData( data );
           coverCreateBean.setFileSize( file.getSize() );
           coverCreateBean.setUse( appPropertiesConfig.getCoverUse() );
           return coverCreateBean;

        } catch (IOException ex) {
            throw new FileStorageException("Impossible de stocker ou de trouver  le fichier " + fileName + ". Veuillez réessayer!", ex);

        }

    }



    /**
     * Getter
     * @return Retourne le timer du caroussel. Paramètre par défaut  application.properties : data.interval
     */
    public Long getCarousselInterval() {
        return appPropertiesConfig.getCarousselInterval();
    }
}
