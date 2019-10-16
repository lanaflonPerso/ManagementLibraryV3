package mbooks.controller.book;


import mbooks.config.ApplicationPropertiesConfig;
import mbooks.controller.dto.books.cover.CoverCreateDto;
import mbooks.controller.dto.books.cover.CoverUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.books.Cover;
import mbooks.service.books.cover.ICoverService;
import mbooks.technical.dto.DTO;
import mbooks.technical.uploadfile.UploadFileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cover")
public class CoverController {

    @Autowired
    private ICoverService coverService;

    @GetMapping("/{id}")
    public Cover getCover(@PathVariable String id) {
        return coverService.getCover( id );
    }

    @GetMapping("/all")
    public List<Cover> coverList(){

        List<Cover> coverList = coverService.findAll();
        if (coverList.isEmpty()) throw new ResourceNotFoundException( "Aucune couverture de livre trouvée");

        return coverList;
    }

    @PostMapping("/save")
    public Cover save(@DTO(CoverCreateDto.class) Cover cover)  {

        return coverService.save( cover );
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@DTO(CoverUpdateDto.class) Cover cover){

        coverService.save( cover );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable String id){

        return coverService.delete( id );
    }





}
