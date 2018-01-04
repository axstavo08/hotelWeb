/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.DTO;

import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Tavo
 */
public class ReservationDTO {

    private int nroRooms;
    private String checkIn;
    private String checkOut;
    private List<String> services;
    private String typeRoom;
    private double importeEst;

    private Integer idCliente;

    /**
     * @return the nroRooms
     */
    public int getNroRooms() {
        return nroRooms;
    }

    /**
     * @param nroRooms the nroRooms to set
     */
    public void setNroRooms(int nroRooms) {
        this.nroRooms = nroRooms;
    }

    /**
     * @return the checkIn
     */
    public String getCheckIn() {
        return checkIn;
    }

    /**
     * @param checkIn the checkIn to set
     */
    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * @return the checkOut
     */
    public String getCheckOut() {
        return checkOut;
    }

    /**
     * @param checkOut the checkOut to set
     */
    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
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
     * @return the importeEst
     */
    public double getImporteEst() {
        return importeEst;
    }

    /**
     * @param importeEst the importeEst to set
     */
    public void setImporteEst(double importeEst) {
        this.importeEst = importeEst;
    }

    /**
     * @return the idCliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

}
