package musers.repository.user;


import musers.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * JPA Initialisation de l'entity Role
 */
@Repository
public interface IRoleRepository extends JpaRepository<Role, Long > {

    Role findRoleById(Long id);
    Role findRoleByName(String name);
}
