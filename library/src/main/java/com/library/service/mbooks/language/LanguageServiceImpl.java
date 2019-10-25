package com.library.service.mbooks.language;

import com.library.beans.mbooks.book.language.LanguageBean;
import com.library.beans.mbooks.book.language.LanguageCreateBean;
import com.library.proxies.ILanguageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements ILanguageService {

    @Autowired
    private ILanguageProxy languageProxy;

    public LanguageBean find(Long id ){
        return  languageProxy.find(id );
    }

    public List<LanguageBean> list(){
        return languageProxy.list();
    }

    public LanguageBean save(LanguageCreateBean language){
        return languageProxy.save( language );
    }

    public LanguageBean save(LanguageBean language){
        return languageProxy.update( language );
    }

    public boolean delete(Long id){
        return languageProxy.delete( id );
    }
}
