/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.Security;

import com.gustavo.hotel.Model.UserHotel;
import com.gustavo.hotel.Repository.HotelRepository;
import com.gustavo.hotel.Security.Entity.UserDetailHotel;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Tavo
 */
@Component
public class AutentificacionProvider implements UserDetailsService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserHotel user = hotelRepository.getUser(StringUtils.upperCase(username));

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        Set<GrantedAuthority> authorities = new LinkedHashSet<>();
        
        return new UserDetailHotel(user, authorities);
    }
}
