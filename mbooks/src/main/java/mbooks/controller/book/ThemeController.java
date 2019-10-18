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

    @GetMapping("/{id}")
    public Theme find(@PathVariable Long id) {
        return themeService.find( id );
    }

    @GetMapping("/all")
    public List<Theme> list(){

        List<Theme> themeList = themeService.list();
        if (themeList.isEmpty()) throw new ResourceNotFoundException( "Aucune couverture de livre trouvée");

        return themeList;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public Theme save(@DTO(ThemeCreateDto.class) @RequestBody Theme theme)  {
        return themeService.save(theme);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Theme update(@DTO(ThemeUpdateDto.class) @RequestBody Theme theme){
        return themeService.save( theme );
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return themeService.delete( id );
    }

}
