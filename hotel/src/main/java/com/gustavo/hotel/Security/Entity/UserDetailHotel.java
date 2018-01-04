/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.Security.Entity;

import org.springframework.security.core.userdetails.User;
import com.gustavo.hotel.Model.UserHotel;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;


/**
 *
 * @author Tavo
 */
public class UserDetailHotel extends User {
    
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String email;
    private String tipo;
    
    public UserDetailHotel(UserHotel usuario, Set<GrantedAuthority> authorities) {
        super(usuario.getUser(), usuario.getPassword(), usuario.isStatus(), true, true, true, authorities);
        this.nombre = usuario.getName();
        this.apellidoPat = usuario.getLastNamePat();
        this.apellidoMat = usuario.getLastNameMat();
        this.email = usuario.getEmail();
        this.tipo = usuario.getTipo();
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoPat
     */
    public String getApellidoPat() {
        return apellidoPat;
    }

    /**
     * @param apellidoPat the apellidoPat to set
     */
    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    /**
     * @return the apellidoMat
     */
    public String getApellidoMat() {
        return apellidoMat;
    }

    /**
     * @param apellidoMat the apellidoMat to set
     */
    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
