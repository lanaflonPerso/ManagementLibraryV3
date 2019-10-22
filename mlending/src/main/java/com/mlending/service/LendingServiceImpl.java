package com.mlending.service;



import com.mlending.model.Lending;
import com.mlending.repository.ILendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendingServiceImpl implements ILendingService {

    @Autowired
    private ILendingRepository lendingRepository;

    public List<Lending> findAll(){
        return lendingRepository.findAll();
    }

    public void save (Lending lending){
        lendingRepository.save(lending);
    }
}
