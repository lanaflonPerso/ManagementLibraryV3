package mbooks.controller.book;

import mbooks.controller.dto.books.edition.EditionCreateDto;
import mbooks.controller.dto.books.edition.EditionUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.books.Edition;
import mbooks.service.books.edition.IEditionService;
import mbooks.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edition")
public class EditionController {

    @Autowired
    private IEditionService editionService;

    @GetMapping("/{id}")
    public Edition find(@PathVariable Long id) {
        return editionService.find( id );
    }

    @GetMapping("/all")
    public List<Edition> list(){

        List<Edition> editionList = editionService.list();
        if (editionList.isEmpty()) throw new ResourceNotFoundException( "Aucune couverture de livre trouvée");

        return editionList;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public Edition save(@DTO(EditionCreateDto.class) @RequestBody Edition edition)  {
        return editionService.save(edition);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Edition update(@DTO(EditionUpdateDto.class) @RequestBody Edition edition){
       return editionService.save( edition );
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return editionService.delete( id );
    }
}
