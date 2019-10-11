package musers.controller.address;


import musers.controller.dto.city.CityDto;
import musers.exceptions.ResourceNotFoundException;
import musers.model.address.City;
import musers.service.address.city.ICityService;
import musers.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private ICityService cityService;

    @GetMapping("/all")
    public List<City> cityList(){

        List<City> cityList = cityService.findAll();
        if (cityList.isEmpty()) throw new ResourceNotFoundException( "Aucune ville trouvée");

        return cityList;
    }

    @PostMapping
    public void newCity(@DTO(CityDto.class) City city) {
        cityService.save( city );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateCity(@DTO(CityDto.class) City city ){
        cityService.save( city );
    }



}
