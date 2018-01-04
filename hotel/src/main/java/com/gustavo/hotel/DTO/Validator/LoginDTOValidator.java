/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.DTO.Validator;

import com.gustavo.hotel.DTO.LoginDTO;
import com.gustavo.hotel.DTO.SigninDTO;
import com.gustavo.hotel.Util.EncryptionMD5;
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
public class LoginDTOValidator implements Validator {

    @Autowired
    Services services;

    @Override
    public boolean supports(Class clazz) {
        return LoginDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LoginDTO login = (LoginDTO) o;
        UserHotel user = services.getUser(login.getUsername().toUpperCase());

        if (StringUtils.isEmpty(StringUtils.trim(login.getUsername()))) {
            errors.rejectValue("username", "username.empty", "Falta escribir un nombre de usuario.");
        }

        if (StringUtils.isEmpty(StringUtils.trim(login.getPassword()))) {
            errors.rejectValue("password", "password.empty", "Falta escribir una contraseña.");
        }
        
        EncryptionMD5 md5 = new EncryptionMD5();
        String passEncrypt = md5.encryptMD5(login.getPassword());
        if (user != null) {
            if (!login.getUsername().toUpperCase().equals(user.getUser())) {
                errors.rejectValue("username", "username.invalid", "Usuario y/o contraseña incorrecto.");
            } 
            if (!passEncrypt.equals(user.getPassword())) {
                errors.rejectValue("password", "password.invalid", "Usuario y/o contraseña incorrecto.");
            } 
            if (user.getTipo().equals("Cliente".toUpperCase())) {
                login.setIsClient(true);
            } else {
                login.setIsClient(false);
            }
        } else {
            errors.rejectValue("username", "username.invalid", "Usuario y/o contraseña incorrecto.");
        }

    }
}
