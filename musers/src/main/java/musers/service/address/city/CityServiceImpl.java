package musers.service.address.city;


import musers.model.address.City;
import musers.repository.address.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService  {

    @Autowired
    private ICityRepository cityRepository;

    public List<City> findAll(){
        return cityRepository.findAll();
    }

    public void save(City city){
        cityRepository.save(city);
    }

}
