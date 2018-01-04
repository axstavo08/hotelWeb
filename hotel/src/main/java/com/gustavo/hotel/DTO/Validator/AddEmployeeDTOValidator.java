/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.DTO.Validator;

import com.gustavo.hotel.DTO.AddEmployeeDTO;
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
public class AddEmployeeDTOValidator implements Validator{
    
    @Override
    public boolean supports(Class clazz) {
        return AddEmployeeDTO.class.isAssignableFrom(clazz);
    }
    
    @Override
    public void validate(Object o, Errors errors) {
        AddEmployeeDTO addEmployee = (AddEmployeeDTO) o; 
        
        if(StringUtils.isEmpty(StringUtils.trim(addEmployee.getUsername()))){
            errors.rejectValue("username", "userName.empty", "Falta escribir un nombre de usuario.");
        }
        
        if(StringUtils.isEmpty(StringUtils.trim(addEmployee.getPassword()))){
            errors.rejectValue("password", "password.empty", "Falta escribir una contraseña.");
        }
        
        if(addEmployee.getInJob() == null){
            errors.rejectValue("inJob", "inJob.empty", "Falta elegir la fecha de ingreso.");
        }
        
        if(StringUtils.isEmpty(StringUtils.trim(addEmployee.getName()))){
            errors.rejectValue("name", "name.empty", "Falta escribir un nombre.");
        }
        
        if(StringUtils.isEmpty(StringUtils.trim(addEmployee.getLastNamePat()))){
            errors.rejectValue("lastNamePat", "lastNamePat.empty", "Falta escribir su apellido paterno.");
        }
        
        if(StringUtils.isEmpty(StringUtils.trim(addEmployee.getLastNameMat()))){
            errors.rejectValue("lastNameMat", "lastNameMat.empty", "Falta escribir su apellido msaterno.");
        }
        
        if(StringUtils.isEmpty(StringUtils.trim(addEmployee.getEmail()))){
            errors.rejectValue("email", "email.empty", "Falta escribir su correo electrónico.");
        }
        
        if(StringUtils.isEmpty(StringUtils.trim(addEmployee.getJob()))){
            errors.rejectValue("job", "job.empty", "Falta escribir el puesto laboral");
        }
        
    }
}
