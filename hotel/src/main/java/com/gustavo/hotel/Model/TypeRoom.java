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
@Table(name = "TIPOHABITACION")
public class TypeRoom implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TG_TIPOHABITACION")
    @SequenceGenerator(name = "TG_TIPOHABITACION", sequenceName = "SQ_TIPOHABITACION")
    @Column(name = "IDTIPOHAB")
    private int idTypeRoom;

    @Column(name = "NOMBRE")
    private String name;
    
    @Column(name = "PRECIO")
    private double price;

    /**
     * @return the idTypeRoom
     */
    public int getIdTypeRoom() {
        return idTypeRoom;
    }

    /**
     * @param idTypeRoom the idTypeRoom to set
     */
    public void setIdTypeRoom(int idTypeRoom) {
        this.idTypeRoom = idTypeRoom;
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
}
