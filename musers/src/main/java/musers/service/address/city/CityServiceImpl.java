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

    /**
     * Permet la recherche de toutes les communes
     * @return Liste de toutes les communes
     */
    public List<City> findAll(){
        return cityRepository.findAll();
    }

    /**
     * Permet la création ou la modification d'une commune
     * @param city Entity city à créer ou à modifier
     */
    public void save(City city){
        cityRepository.save(city);
    }

}
