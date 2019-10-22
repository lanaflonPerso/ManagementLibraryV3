package com.mlending.controller;



import com.mlending.controller.dto.LendingCreateDto;
import com.mlending.controller.dto.LendingUpdateDto;
import com.mlending.exceptions.ResourceNotFoundException;
import com.mlending.model.Lending;
import com.mlending.service.ILendingService;
import com.mlending.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lending")
public class LendingController {
    @Autowired
    private ILendingService lendingService;

    @GetMapping("/all")
    public List<Lending> lendingList(){

        List<Lending> lendingList = lendingService.findAll();
        if (lendingList.isEmpty()) throw new ResourceNotFoundException( "Aucun utilisateur trouvé");

        return lendingList;
    }

    @PostMapping
    public void newLending(@DTO(LendingCreateDto.class) Lending lending) {
        lendingService.save( lending );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateLending(@DTO(LendingUpdateDto.class) Lending lending ){
        lendingService.save( lending );
    }
}
