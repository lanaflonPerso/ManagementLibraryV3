package com.library.technical.authentificationfacade;

import org.springframework.security.core.Authentication;


public interface IAuthenticationFacade  {

    Authentication getAuthentication();
}
