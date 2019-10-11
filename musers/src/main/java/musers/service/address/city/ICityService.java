package musers.service.address.city;


import musers.model.address.City;

import java.util.List;

public interface ICityService {
    List<City> findAll();
    void save(City city);
}
