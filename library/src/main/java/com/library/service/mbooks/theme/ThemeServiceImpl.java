package com.library.service.mbooks.theme;

import com.library.beans.mbooks.book.theme.ThemeBean;
import com.library.beans.mbooks.book.theme.ThemeCreateBean;
import com.library.exception.ResourceNotFoundException;
import com.library.proxies.IThemeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements IThemeService {

    @Autowired
    private IThemeProxy themeProxy;

    public ThemeBean find(Long id ){

        try {
            return  themeProxy.find(id );
        }catch (ResourceNotFoundException e){
            return null;
        }
    }

    public List<ThemeBean> list(){

        try {
            return themeProxy.list();
        }catch (ResourceNotFoundException e){
            return null;
        }
    }

    public ThemeBean save(ThemeCreateBean theme){
        return themeProxy.save( theme );
    }

    public ThemeBean save(ThemeBean theme){
        return themeProxy.update( theme );
    }

    public boolean delete(Long id){
        return themeProxy.delete( id );
    }
}
