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
public class RoomsDTO {
    
    private Integer id;
    private String nroRoom;
    private String typeRoom;
    private String available;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nroRoom
     */
    public String getNroRoom() {
        return nroRoom;
    }

    /**
     * @param nroRoom the nroRoom to set
     */
    public void setNroRoom(String nroRoom) {
        this.nroRoom = nroRoom;
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
     * @return the available
     */
    public String getAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(String available) {
        this.available = available;
    }
    
    
    
}
