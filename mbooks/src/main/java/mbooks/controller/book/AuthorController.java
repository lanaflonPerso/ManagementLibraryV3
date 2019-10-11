package mbooks.controller.book;


import mbooks.controller.dto.books.author.AuthorCreateDto;
import mbooks.controller.dto.books.author.AuthorUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.books.Author;
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

    @GetMapping("/all")
    public List<Author> authorList(){

        List<Author> authorList = authorService.findAll();
        if (authorList.isEmpty()) throw new ResourceNotFoundException( "Aucun utilisateur trouvé");

        return authorList;
    }

    @PostMapping
    public void newAuthor(@DTO(AuthorCreateDto.class) Author author) {
        authorService.save( author );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateAuthor(@DTO(AuthorUpdateDto.class) Author author ){
        authorService.save( author );
    }
}
