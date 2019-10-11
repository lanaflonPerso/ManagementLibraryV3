package mbooks.controller.book;


import mbooks.controller.dto.books.BooksCreateDto;
import mbooks.controller.dto.books.BooksUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.books.Books;
import mbooks.service.books.IBooksService;
import mbooks.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class BooksController {

    @Autowired
    private IBooksService booksService;

    @GetMapping("/all")
    public List<Books> bookList(){

        List<Books> booksList = booksService.findAll();
        if (booksList.isEmpty()) throw new ResourceNotFoundException( "Aucun utilisateur trouvé");

        return booksList;
    }

    @PostMapping
    public void newBook(@DTO(BooksCreateDto.class) Books books) {
        booksService.save( books );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@DTO(BooksUpdateDto.class) Books books ){
        booksService.save( books );
    }
}
