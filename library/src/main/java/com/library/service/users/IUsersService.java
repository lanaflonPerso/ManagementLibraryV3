package com.library.service.users;

import com.library.beans.musers.user.UsersBean;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUsersService extends UserDetailsService {

    UsersBean find(Long id);
    String fullName(Long id);
}
