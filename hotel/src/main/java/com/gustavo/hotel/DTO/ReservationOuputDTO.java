/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.DTO;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Tavo
 */
public class ReservationOuputDTO {
    
    private String nroRooms;
    private String typeRoom;
    private Date checkIn;
    private Date checkOut;
    private String status;
    private Date dateCancel;
    private double amountTotal;
    private String nameEmployee;
    private String lastNameEmployee;
    private String nameRooms;
    private List<String> services;
    private String nameClient;
    private String lastNameClient;

    /**
     * @return the nroRooms
     */
    public String getNroRooms() {
        return nroRooms;
    }

    /**
     * @param nroRooms the nroRooms to set
     */
    public void setNroRooms(String nroRooms) {
        this.nroRooms = nroRooms;
    }

    /**
     * @return the typeRoom
     */
    public String getTypeRoom() {
        return typeRoom;
    }

    /**
     * @param typeRoom the typeRoom to set
     */
    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    /**
     * @return the checkIn
     */
    public Date getCheckIn() {
        return checkIn;
    }

    /**
     * @param checkIn the checkIn to set
     */
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * @return the checkOut
     */
    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * @param checkOut the checkOut to set
     */
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the dateCancel
     */
    public Date getDateCancel() {
        return dateCancel;
    }

    /**
     * @param dateCancel the dateCancel to set
     */
    public void setDateCancel(Date dateCancel) {
        this.dateCancel = dateCancel;
    }

    /**
     * @return the amountTotal
     */
    public double getAmountTotal() {
        return amountTotal;
    }

    /**
     * @param amountTotal the amountTotal to set
     */
    public void setAmountTotal(double amountTotal) {
        this.amountTotal = amountTotal;
    }

    /**
     * @return the nameEmployee
     */
    public String getNameEmployee() {
        return nameEmployee;
    }

    /**
     * @param nameEmployee the nameEmployee to set
     */
    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    /**
     * @return the lastNameEmployee
     */
    public String getLastNameEmployee() {
        return lastNameEmployee;
    }

    /**
     * @param lastNameEmployee the lastNameEmployee to set
     */
    public void setLastNameEmployee(String lastNameEmployee) {
        this.lastNameEmployee = lastNameEmployee;
    }

    /**
     * @return the nameRooms
     */
    public String getNameRooms() {
        return nameRooms;
    }

    /**
     * @param nameRooms the nameRooms to set
     */
    public void setNameRooms(String nameRooms) {
        this.nameRooms = nameRooms;
    }

    /**
     * @return the services
     */
    public List<String> getServices() {
        return services;
    }

    /**
     * @param services the services to set
     */
    public void setServices(List<String> services) {
        this.services = services;
    }

    /**
     * @return the nameClient
     */
    public String getNameClient() {
        return nameClient;
    }

    /**
     * @param nameClient the nameClient to set
     */
    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    /**
     * @return the lastNameClient
     */
    public String getLastNameClient() {
        return lastNameClient;
    }

    /**
     * @param lastNameClient the lastNameClient to set
     */
    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }
    

   
    
}
