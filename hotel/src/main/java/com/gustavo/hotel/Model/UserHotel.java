/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Tavo
 */
@Entity
@Table(name = "USUARIO")
public class UserHotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TG_USUARIO")
    @SequenceGenerator(name = "TG_USUARIO", sequenceName = "SQ_USUARIO")
    @Column(name = "IDUSU")
    private Integer idUser;

    @Column(name = "USUARIO")
    private String user;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "APELLIDOPAT")
    private String lastNamePat;

    @Column(name = "APELLIDOMAT")
    private String lastNameMat;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ESTADO")
    private boolean status;
    
    @Column(name = "TIPO")
    private String tipo;

    /**
     * @return the idUser
     */
    public Integer getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastNamePat
     */
    public String getLastNamePat() {
        return lastNamePat;
    }

    /**
     * @param lastNamePat the lastNamePat to set
     */
    public void setLastNamePat(String lastNamePat) {
        this.lastNamePat = lastNamePat;
    }

    /**
     * @return the lastNameMat
     */
    public String getLastNameMat() {
        return lastNameMat;
    }

    /**
     * @param lastNameMat the lastNameMat to set
     */
    public void setLastNameMat(String lastNameMat) {
        this.lastNameMat = lastNameMat;
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
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
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
