package musers.service.user;


import musers.config.ApplicationPropertiesConfig;
import musers.model.user.Role;
import musers.model.user.Users;
import musers.repository.user.IUsersRepository;
import musers.service.user.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Gestion des utilisateurs
 */
@Service
public class UsersServiceImpl implements IUsersService {

    @Autowired
    private IUsersRepository usersRepository;

    @Autowired
    private ApplicationPropertiesConfig appPropertiesConfig;

    @Autowired
    private IRoleService roleService;



    @Autowired
    private BCryptPasswordEncoder passwordEncoder;



    public Users findUser(Long idUser){
        return usersRepository.findByIdAndActiveTrue(idUser);
    }

    public Users findUser(String email){return usersRepository.findByEmailAndActiveTrue( email );}

    /**
     * (Réservé à l'administreur)
     * On recherche la liste de tous les utilisateurs
     * @return La liste des utilisateurs
     */
    public List<Users> findAll(){
        return usersRepository.findAll();
    }


    public void save( Users user){
        if(user.getId() == null){
            user.setActive( appPropertiesConfig.isActive() );
            user.setPassword(passwordEncoder.encode(user.getPassword() ) );
            user.setRoleList( roleService.findListRole()  );
        }

        usersRepository.save( user );
    }


    /**
     * Réservé à l'administrateur :
     * Modification du role de l'utilisateur
     * @param idUser Id de l'utilisateur
     * @param newRole Nouveau role à affecter
     */
    public void updateRole(Long idUser,String newRole){

        Users user = usersRepository.getOne( idUser );
        Role role = roleService.findRole( "ROLE_"+ newRole);
        user.getRoleList().clear();
        user.getRoleList().add( role );
        usersRepository.save( user );
    }



}