package mbooks.controller.book;


import mbooks.controller.dto.books.author.AuthorCreateDto;
import mbooks.controller.dto.books.author.AuthorUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.books.Author;
import mbooks.model.books.Language;
import mbooks.service.books.author.IAuthorService;
import mbooks.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private IAuthorService authorService;

    @GetMapping("/{id}")
    public Author find(@PathVariable Long id) {
        return authorService.find( id );
    }

    @GetMapping("/all")
    public List<Author> list(){

        List<Author> authorList = authorService.list();
        if (authorList.isEmpty()) throw new ResourceNotFoundException( "Aucun auteur trouvé.");

        return authorList;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public Author save(@DTO(AuthorCreateDto.class) @RequestBody Author author)  {
        return authorService.save(author);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Author update(@DTO(AuthorUpdateDto.class) @RequestBody Author author){
        return authorService.save( author );
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return authorService.delete( id );
    }
}
