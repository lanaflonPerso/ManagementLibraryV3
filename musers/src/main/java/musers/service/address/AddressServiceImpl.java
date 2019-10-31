package musers.service.address;

import musers.model.address.Address;
import musers.repository.address.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private IAddressRepository addressRepository;

    /**
     * Permet la recherche de toutes les adresses
     * @return La liste toutes les adresses
     */
    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    /**
     * Permet la création ou la modification d'une adresse
     * @param address Entity address à créer ou à modifier
     */
    public void save(Address address){
        addressRepository.save(address);
    }
}
