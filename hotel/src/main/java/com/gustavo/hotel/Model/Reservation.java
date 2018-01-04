/*
   * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Type;

/**
 *
 * @author Tavo
 */
@Entity
@Table(name = "RESERVA")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TG_RESERVA")
    @SequenceGenerator(name = "TG_RESERVA", sequenceName = "SQ_RESERVA")
    @Column(name = "IDRESERVA")
    private Integer idReservation;

    @Column(name = "HABITACIONES")
    private int nroRooms;

    @Column(name = "FECHALLEGADA")
    @Type(type="timestamp")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date checkIn;

    @Column(name = "FECHASALIDA")
    @Type(type="timestamp")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date checkOut;

    @Column(name = "ESTADO")
    private String status;

    @Column(name = "FECHACANCELACION")
    @Type(type="timestamp")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCancel;

    @Column(name = "IMPORTEESTIMADO")
    private double amount;

    @Column(name = "COMENTARIOS")
    private String comments;

    @Column(name = "IDEMPLEADO")
    private Integer idEmployee;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
    @JoinTable(name = "DETALLE_RESERVA_HABITACION",
            joinColumns = {
                @JoinColumn(name = "IDRESERVA")},
            inverseJoinColumns = {
                @JoinColumn(name = "IDHABITACION")})
    private List<Room> rooms;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
    @JoinTable(name = "DETALLE_RESERVA_SERVICIO",
            joinColumns = {
                @JoinColumn(name = "IDRESERVA")},
            inverseJoinColumns = {
                @JoinColumn(name = "IDSERVICIO")})
    private List<Servicio> services;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDCLIENTE")
    private Client client;

    /**
     * @return the idReservation
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    /**
     * @param idReservation the idReservation to set
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

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
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the idEmployee
     */
    public Integer getIdEmployee() {
        return idEmployee;
    }

    /**
     * @param idEmployee the idEmployee to set
     */
    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    /**
     * @return the rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * @return the services
     */
    public List<Servicio> getServices() {
        return services;
    }

    /**
     * @param services the services to set
     */
    public void setServices(List<Servicio> services) {
        this.services = services;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

}
