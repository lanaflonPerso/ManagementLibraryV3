package mbooks.controller.lending;


import mbooks.controller.dto.lending.LendingCreateDto;
import mbooks.controller.dto.lending.LendingUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.lending.Lending;
import mbooks.service.lending.ILendingService;
import mbooks.technical.dto.DTO;
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
