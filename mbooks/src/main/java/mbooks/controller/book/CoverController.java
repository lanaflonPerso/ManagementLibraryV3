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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    @ResponseStatus(HttpStatus.OK)
    public String save(@DTO(CoverCreateDto.class) @RequestBody Cover cover)  {

        System.out.println( cover.getFileName() );

        Cover cover1= coverService.save( cover );

        return cover1.getId();

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@DTO(CoverUpdateDto.class) @RequestBody Cover cover){

                coverService.save( cover );
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){

        return coverService.delete( id );
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(  @RequestParam("file") MultipartFile file){

        return "ok";
    }

    @GetMapping("/download/{id}")
    public MultipartFile[] download(  @PathVariable String id){

        return null;
    }





}
