package com.mlending.service;





import com.mlending.model.Lending;

import java.util.List;

public interface ILendingService {

    List<Lending> findAll();
    void save(Lending lending);
}
