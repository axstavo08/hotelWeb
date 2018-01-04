/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.DTO;

import java.util.Date;

/**
 *
 * @author Tavo
 */
public class AddEmployeeDTO {
    
     private String username;
     private String password;
     private String inJob;
     private String outJob;
     private String name;
     private String lastNamePat;
     private String lastNameMat;
     private String email;
     private String job;

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
     * @return the inJob
     */
    public String getInJob() {
        return inJob;
    }

    /**
     * @param inJob the inJob to set
     */
    public void setInJob(String inJob) {
        this.inJob = inJob;
    }

    /**
     * @return the outJob
     */
    public String getOutJob() {
        return outJob;
    }

    /**
     * @param outJob the outJob to set
     */
    public void setOutJob(String outJob) {
        this.outJob = outJob;
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
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job the job to set
     */
    public void setJob(String job) {
        this.job = job;
    }

}
