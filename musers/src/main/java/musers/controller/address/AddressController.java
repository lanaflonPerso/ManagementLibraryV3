package musers.controller.address;


import musers.controller.dto.address.AddressCreateDto;
import musers.controller.dto.address.AddressUpdateDto;
import musers.exceptions.ResourceNotFoundException;
import musers.model.address.Address;
import musers.service.address.IAddressService;
import musers.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    IAddressService addressService;

    @GetMapping("/all")
    public List<Address> addressList(){

        List<Address> addressList = addressService.findAll();
        if (addressList.isEmpty()) throw new ResourceNotFoundException( "Aucun utilisateur trouvé");

        return addressList;
    }

    @PostMapping
    public void newAddress(@DTO(AddressCreateDto.class) Address address) {
        addressService.save( address );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateAddress(@DTO(AddressUpdateDto.class) Address address ){
        addressService.save( address );
    }


}
