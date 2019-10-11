package musers.repository.address;


import musers.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address,Long> {
}
