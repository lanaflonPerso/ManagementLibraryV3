package com.library.service.mbooks.edition;

import com.library.beans.mbooks.book.edition.EditionBean;
import com.library.beans.mbooks.book.edition.EditionCreateBean;
import com.library.proxies.IEditionProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditionServiceImpl implements IEditionService {

    @Autowired
    private IEditionProxy editionProxy;

    public EditionBean find(Long id ){
        return  editionProxy.find(id );
    }

    public List<EditionBean> list(){
        return editionProxy.list();
    }

    public EditionBean save(EditionCreateBean edition){
        return editionProxy.save( edition );
    }

    public EditionBean save(EditionBean edition){
        return editionProxy.update( edition );
    }

    public boolean delete(Long id){
        return editionProxy.delete( id );
    }
}
