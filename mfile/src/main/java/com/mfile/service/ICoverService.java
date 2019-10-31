package com.mfile.service;





import com.mfile.model.Cover;

import java.util.List;

public interface ICoverService {

    Cover find(String id );
    List<Cover> findAll();


    Cover save(Cover cover);


    boolean delete(String id);
}
