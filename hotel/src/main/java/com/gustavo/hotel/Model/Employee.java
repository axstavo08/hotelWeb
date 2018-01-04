/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gustavo.hotel.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Type;

/**
 *
 * @author Tavo
 */
@Entity
@Table(name = "EMPLEADO")
public class Employee implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TG_EMPLEADO")
    @SequenceGenerator(name = "TG_EMPLEADO", sequenceName = "SQ_EMPLEADO")
    @Column(name = "IDEMPLEADO")
    private int idEmployee;

    @Column(name = "PUESTOLABORAL")
    private String job;
    
    @Column(name = "FECHAINGRESO")
    @Type(type="timestamp")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateIn;
    
    @Column(name = "FECHASALIDA")
    @Type(type="timestamp")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOut;
    
    /*@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "IDUSU")
    private UserHotel users;*/
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDUSU", referencedColumnName = "IDUSU")
    private UserHotel users;

    /**
     * @return the idEmployee
     */
    public int getIdEmployee() {
        return idEmployee;
    }

    /**
     * @param idEmployee the idEmployee to set
     */
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
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

    /**
     * @return the dateIn
     */
    public Date getDateIn() {
        return dateIn;
    }

    /**
     * @param dateIn the dateIn to set
     */
    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    /**
     * @return the dateOut
     */
    public Date getDateOut() {
        return dateOut;
    }

    /**
     * @param dateOut the dateOut to set
     */
    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
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
}
