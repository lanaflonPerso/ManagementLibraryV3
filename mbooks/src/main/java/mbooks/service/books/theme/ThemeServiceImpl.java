package mbooks.service.books.theme;


import mbooks.model.books.Theme;
import mbooks.repository.book.IThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements IThemeService {

    @Autowired
    private IThemeRepository themeRepository;

    public List<Theme> findAll(){
        return  themeRepository.findAll();
    }

    public void save(Theme theme){
        themeRepository.save( theme );
    }
}
