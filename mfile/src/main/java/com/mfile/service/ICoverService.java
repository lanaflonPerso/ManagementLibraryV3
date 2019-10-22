package com.mfile.service;





import com.mfile.model.Cover;

import java.util.List;

public interface ICoverService {

    Cover find(String id );
    List<Cover> findAll();
    List<Cover> findAll(String coverUse );

    Cover save(Cover cover);


    boolean delete(String id);
}
