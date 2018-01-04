/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.Security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tavo
 */
@Component
public class AutentificacionFailureHandler extends SimpleUrlAuthenticationFailureHandler
        implements AuthenticationFailureHandler{
    
    final static Logger log = Logger.getLogger(AutentificacionFailureHandler.class);
    
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        //log.info("user_authentication_failure", e);
        super.setDefaultFailureUrl("/login?error=true");
        super.onAuthenticationFailure(request, response, e);
    }
}
