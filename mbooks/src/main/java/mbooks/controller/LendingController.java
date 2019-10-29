package mbooks.controller;

import mbooks.controller.dto.lending.LendingCreateDto;
import mbooks.controller.dto.lending.LendingUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.Lending;
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



    @GetMapping("/{id}")
    public Lending find(@PathVariable Long id) {
        return lendingService.find( id );
    }

    @GetMapping("/all")
    public List<Lending> list(){

        List<Lending> lendingList = lendingService.list();
        if (lendingList.isEmpty()) throw new ResourceNotFoundException( "Aucun prêt trouvé.");

        return lendingList;
    }

    @GetMapping("/user/{id}")
    public List<Lending> list(@PathVariable Long id){

        List<Lending> lendingList = lendingService.list( id );
        if (lendingList.isEmpty()) throw new ResourceNotFoundException( "Aucun prêt trouvé.");

        return lendingList;
    }

    @GetMapping("/book/{id}")
    public List<Lending> list(@PathVariable String id){

        List<Lending> lendingList = lendingService.list( id );
        if (lendingList.isEmpty()) throw new ResourceNotFoundException( "Aucun prêt trouvé.");

        return lendingList;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public Lending save(@DTO(LendingCreateDto.class) @RequestBody Lending lending)  {
        return lendingService.save(lending);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Lending update(@DTO(LendingUpdateDto.class) @RequestBody Lending lending){
        return lendingService.save( lending );
    }
    @PutMapping("/renewal")
    @ResponseStatus(HttpStatus.OK)
    public void renewal(@RequestBody Long id){
        lendingService.renewal(id );
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return lendingService.delete( id );
    }

    @GetMapping("/email/sendRevival")
    public void sendRevival(){
        lendingService.revival();
    }
}
