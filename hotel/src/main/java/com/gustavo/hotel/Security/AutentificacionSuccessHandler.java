/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.Security;

import com.gustavo.hotel.Security.Entity.UserDetailHotel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tavo
 */
@Component
public class AutentificacionSuccessHandler extends SimpleUrlAuthenticationSuccessHandler
        implements AuthenticationSuccessHandler{
    
    final static Logger log = Logger.getLogger(AutentificacionSuccessHandler.class);
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {

        String ip = request.getHeader("X-FORWARDED-FOR");

        if (ip == null) {
            ip = request.getRemoteAddr();
        }

        log.info("user_authentication_success; username=" + a.getName() + "; ip=" + ip + "; host=" + request.getRemoteHost());

        UserDetailHotel userHotel = (UserDetailHotel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String typeUser = userHotel.getTipo();

        if (typeUser.equals("CLIENTE")) {
            super.setDefaultTargetUrl("/client");

        } else {
            super.setDefaultTargetUrl("/employee");
        }

        super.onAuthenticationSuccess(request, response, a);
    }
}
