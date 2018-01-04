/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gustavo.hotel.DTO;

/**
 *
 * @author Tavo
 */
public class SigninDTO {
    
    private String userName;
    private String password;
    private String name;
    private String lastNamePat;
    private String lastNameMat;
    private String email;
    private String city;
    private String country;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
