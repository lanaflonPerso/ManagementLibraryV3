package mbooks.controller.book;


import mbooks.controller.dto.language.LanguageCreateDto;
import mbooks.controller.dto.language.LanguageUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.Language;
import mbooks.service.language.ILanguageService;
import mbooks.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private ILanguageService languageService;



    @GetMapping("/{id}")
    public Language find(@PathVariable Long id) {
        return languageService.find( id );
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @GetMapping("/all")
    public List<Language> list(){


        List<Language> languageList = languageService.list();
        if (languageList.isEmpty()) throw new ResourceNotFoundException( "Aucun langage trouvé.");

        return languageList;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public Language save(@DTO(LanguageCreateDto.class) @RequestBody Language language)  {
        return languageService.save(language);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Language update(@DTO(LanguageUpdateDto.class) @RequestBody Language language){
        return languageService.save( language );
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return languageService.delete( id );
    }
}
