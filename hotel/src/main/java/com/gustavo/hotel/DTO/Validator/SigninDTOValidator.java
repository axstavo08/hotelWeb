/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gustavo.hotel.DTO.Validator;

import com.gustavo.hotel.DTO.SigninDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import com.gustavo.hotel.Services.Services;
import org.springframework.validation.Errors;
import com.gustavo.hotel.Model.UserHotel;
import org.apache.commons.lang3.StringUtils;


/**
 *
 * @author Tavo
 */
@Component
public class SigninDTOValidator implements Validator{
    
    @Override
    public boolean supports(Class clazz) {
        return SigninDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SigninDTO signin = (SigninDTO) o; 
        
        if(StringUtils.isEmpty(StringUtils.trim(signin.getUserName()))){
            errors.rejectValue("userName", "userName.empty", "Falta escribir un nombre de usuario.");
        }
        
        if(StringUtils.isEmpty(StringUtils.trim(signin.getPassword()))){
            errors.rejectValue("password", "password.empty", "Falta escribir una contraseña.");
        }
        
        if(StringUtils.isEmpty(StringUtils.trim(signin.getName()))){
            errors.rejectValue("name", "name.empty", "Falta escribir un nombre.");
        }
        
        if(StringUtils.isEmpty(StringUtils.trim(signin.getLastNamePat()))){
            errors.rejectValue("lastNamePat", "lastNamePat.empty", "Falta escribir su apellido paterno.");
        }
        
        if(StringUtils.isEmpty(StringUtils.trim(signin.getLastNameMat()))){
            errors.rejectValue("lastNameMat", "lastNameMat.empty", "Falta escribir su apellido msaterno.");
        }
        
        if(StringUtils.isEmpty(StringUtils.trim(signin.getEmail()))){
            errors.rejectValue("email", "email.empty", "Falta escribir su correo electrónico.");
        }
        
        if(StringUtils.isEmpty(StringUtils.trim(signin.getCity()))){
            errors.rejectValue("city", "city.empty", "Falta escribir una ciudad.");
        }
        
        if(StringUtils.isEmpty(StringUtils.trim(signin.getCountry()))){
            errors.rejectValue("country", "country.empty", "Falta escribir un país.");
        }
        
    }
    
}
