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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Tavo
 */
@Entity
@Table(name = "CLIENTE")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TG_CLIENTE")
    @SequenceGenerator(name = "TG_CLIENTE", sequenceName = "SQ_CLIENTE")
    @Column(name = "IDCLIENTE")
    private int idClient;

    @Column(name = "CIUDAD")
    private String city;

    @Column(name = "PAIS")
    private String country;

    /*@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "IDUSU")
    private UserHotel users;*/

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDUSU", referencedColumnName = "IDUSU")
    private UserHotel users;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Reservation> reservations;

    /**
     * @return the idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

    /**
     * @return the users
     */
    public UserHotel getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(UserHotel users) {
        this.users = users;
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
