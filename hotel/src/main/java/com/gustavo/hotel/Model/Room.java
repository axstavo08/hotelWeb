/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Tavo
 */
@Entity
@Table(name = "HABITACION")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TG_HABITACION")
    @SequenceGenerator(name = "TG_HABITACION", sequenceName = "SQ_HABITACION")
    @Column(name = "IDHABITACION")
    private Integer idRoom;

    @Column(name = "NROHABITACION")
    private String nroRoom;

    @Column(name = "DISPONIBLE")
    private boolean available;

    @Column(name = "DESCRIPCION")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDTIPOHAB")
    private TypeRoom typeRooms;

    @ManyToMany(mappedBy = "rooms")
    private List<Reservation> reservations;

    /**
     * @return the idRoom
     */
    public Integer getIdRoom() {
        return idRoom;
    }

    /**
     * @param idRoom the idRoom to set
     */
    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
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
     * @return the available
     */
    public boolean getAvailable() {
        return isAvailable();
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the typeRooms
     */
    public TypeRoom getTypeRooms() {
        return typeRooms;
    }

    /**
     * @param typeRooms the typeRooms to set
     */
    public void setTypeRooms(TypeRoom typeRooms) {
        this.typeRooms = typeRooms;
    }

    /**
     * @return the available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @return the reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * @param reservations the reservations to set
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
