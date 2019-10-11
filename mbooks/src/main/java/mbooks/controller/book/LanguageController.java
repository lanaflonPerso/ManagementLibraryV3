package mbooks.controller.book;


import mbooks.controller.dto.books.language.LanguageCreateDto;
import mbooks.controller.dto.books.language.LanguageUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.books.Language;
import mbooks.service.books.language.ILanguageService;
import mbooks.technical.dto.DTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Language")
public class LanguageController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ILanguageService languageService;


    @GetMapping("/all")
    public List<Language> languageList(){

        List<Language> addressList = languageService.findAll();
        if (addressList.isEmpty()) throw new ResourceNotFoundException( "Aucun langage trouvé");

        log.info("Récupération de la liste des langues");
        return addressList;
    }

    @PostMapping
    public void newLanguage(@DTO(LanguageCreateDto.class) Language language) {
        languageService.save( language );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateLanguage(@DTO(LanguageUpdateDto.class) Language language ){
        languageService.save( language );
    }
}
