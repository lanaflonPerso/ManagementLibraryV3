package mbooks.controller.book;


import mbooks.controller.dto.books.cover.CoverCreateDto;
import mbooks.controller.dto.books.cover.CoverUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.books.Cover;
import mbooks.service.books.cover.ICoverService;
import mbooks.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cover")
public class CoverController {

    @Autowired
    private ICoverService coverService;

    @GetMapping("/all")
    public List<Cover> coverList(){

        List<Cover> coverList = coverService.findAll();
        if (coverList.isEmpty()) throw new ResourceNotFoundException( "Aucune couverture de livre trouvée");

        return coverList;
    }

    @PostMapping
    public void newCover(@DTO(CoverCreateDto.class) Cover cover) {

    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateCover(@DTO(CoverUpdateDto.class) Cover cover ){

    }
}
