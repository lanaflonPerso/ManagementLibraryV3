package musers.controller.address;

import com.users.controller.dto.city.CityDto;
import com.users.exceptions.ResourceNotFoundException;
import com.users.model.address.City;
import com.users.service.address.city.ICityService;
import com.users.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/City")
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
    public void updateCity(@DTO(City.class) City city ){
        cityService.save( city );
    }



}
