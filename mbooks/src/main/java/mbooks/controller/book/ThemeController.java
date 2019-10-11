package mbooks.controller.book;


import mbooks.controller.dto.books.theme.ThemeCreateDto;
import mbooks.controller.dto.books.theme.ThemeUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.books.Theme;
import mbooks.service.books.theme.IThemeService;
import mbooks.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private IThemeService themeService;

    @GetMapping("/all")
    public List<Theme> themeList(){

        List<Theme> themeList = themeService.findAll();
        if (themeList.isEmpty()) throw new ResourceNotFoundException( "Aucun utilisateur trouvé");

        return themeList;
    }

    @PostMapping
    public void newTheme(@DTO(ThemeCreateDto.class) Theme theme) {
        themeService.save( theme );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateTheme(@DTO(ThemeUpdateDto.class) Theme theme ){
        themeService.save( theme );
    }

}
