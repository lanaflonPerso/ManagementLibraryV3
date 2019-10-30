package mbooks.controller;


import mbooks.controller.dto.author.AuthorCreateDto;
import mbooks.controller.dto.author.AuthorUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.Author;
import mbooks.service.author.IAuthorService;
import mbooks.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController  implements HealthIndicator {
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

    @Override
    public Health health() {
        List<Author> authorList = authorService.list();
        if (authorList.isEmpty())
            return Health.down().build();

        return Health.up().build();
    }
}
