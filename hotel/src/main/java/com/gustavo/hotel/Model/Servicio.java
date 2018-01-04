/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gustavo.hotel.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Tavo
 */
@Entity
@Table(name = "SERVICIO")
public class Servicio implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TG_SERVICIO")
    @SequenceGenerator(name = "TG_SERVICIO", sequenceName = "SQ_SERVICIO")
    @Column(name = "IDSERVICIO")
    private Integer idService;

    @Column(name = "NOMBRE")
    private String name;
    
    @Column(name = "DESCRIPCION")
    private String description;
    
    @Column(name = "PRECIO")
    private double price;
    
    @ManyToMany(mappedBy = "services")
    private List<Reservation> reservations;
    /**
     * @return the idService
     */
    public Integer getIdService() {
        return idService;
    }

    /**
     * @param idService the idService to set
     */
    public void setIdService(Integer idService) {
        this.idService = idService;
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
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
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
