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
public class LoginDTO {
    
    private String username;
    private String password;
    private boolean isClient;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
     * @return the isClient
     */
    public boolean isIsClient() {
        return isClient;
    }

    /**
     * @param isClient the isClient to set
     */
    public void setIsClient(boolean isClient) {
        this.isClient = isClient;
    }

}
