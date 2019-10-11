package com.library.service.users;

import com.library.beans.musers.user.RoleBean;
import com.library.beans.musers.user.UsersBean;
import com.library.proxies.IMicroserviceUsersProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUsersService {

    @Autowired
    private IMicroserviceUsersProxy mUsersProxy;

    /**
     * On cherche un utilisateur
     * @param email Email de l'utilisateur à chercher
     * @return L'utilisateur si l'utilisateur est trouvé.
     * @throws UsernameNotFoundException Exception de la présence de l'utilisateur recherché
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        System.out.println("email : " + email);
        UsersBean user = mUsersProxy.user( email );
        if (user == null) {
            throw new UsernameNotFoundException("Utilisateur ou mot de passe incorrect.");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities( user.getRoleList() ) ) ;



    }

    /**
     *
     * @param roles role de l'utilisateur
     * @return
     */
    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(List<RoleBean> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
