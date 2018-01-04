/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.Repository.Impl;

import com.gustavo.hotel.Model.Client;
import com.gustavo.hotel.Model.Employee;
import com.gustavo.hotel.Model.Reservation;
import com.gustavo.hotel.Model.Room;
import com.gustavo.hotel.Model.Servicio;
import com.gustavo.hotel.Model.TypeRoom;
import com.gustavo.hotel.Model.UserHotel;
import com.gustavo.hotel.Repository.HotelRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tavo
 */
@Repository
public class HotelRepositoryImpl extends RepositoryConnection implements HotelRepository {

    @Override
    @Transactional(readOnly = true)
    public UserHotel getUser(String nameUser) {
        return (UserHotel) getHibernateSession().createCriteria(UserHotel.class)
                .add(Restrictions.eq("user", nameUser))
                .uniqueResult();
    }

    @Override
    @Transactional(readOnly = false)
    public void addUser(Client client) {
        getHibernateSession().save(client);
    }

    @Override
    @Transactional(readOnly = false)
    public void addEmployee(Employee employee) {
        getHibernateSession().save(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeRoom> getTypeRooms() {
        return (List<TypeRoom>) getHibernateSession().createCriteria(TypeRoom.class).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Room> getRooms() {
        return (List<Room>) getHibernateSession().createCriteria(Room.class, "room")
                .addOrder(Order.asc("room.nroRoom"))
                .list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Room> getRoomsByType(String typeRoom) {
        List<Room> rooms = (List<Room>) getHibernateSession().createCriteria(Room.class, "room")
                .add(Restrictions.eq("room.available", Boolean.TRUE))
                .createAlias("room.typeRooms", "typeRoom")
                .add(Restrictions.eq("typeRoom.name", typeRoom))
                .addOrder(Order.asc("room.nroRoom"))
                .list();

        return rooms;
    }

    @Override
    @Transactional(readOnly = true)
    public Client getClientUser(String nameUser) {
        Client client = (Client) getHibernateSession().createCriteria(Client.class, "client")
                .createAlias("client.users", "users")
                .add(Restrictions.eq("users.user", nameUser))
                .uniqueResult();

        return client;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> getClientList() {
        List<Client> client = (List<Client>) getHibernateSession().createCriteria(Client.class, "client")
                .createAlias("client.users", "users")
                .add(Restrictions.eq("users.tipo", "CLIENTE"))
                .list();

        return client;
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployeeUser(String nameUser) {
        Employee employee = (Employee) getHibernateSession().createCriteria(Employee.class, "employee")
                .createAlias("employee.users", "users")
                .add(Restrictions.eq("users.user", nameUser))
                .uniqueResult();

        return employee;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getEmployeeList() {
        List<Employee> employee = (List<Employee>) getHibernateSession().createCriteria(Employee.class, "employee")
                .createAlias("employee.users", "users")
                .add(Restrictions.eq("users.tipo", "EMPLEADO"))
                .list();

        return employee;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> getServices() {
        return (List<Servicio>) getHibernateSession().createCriteria(Servicio.class).list();
    }

    @Override
    @Transactional(readOnly = false)
    public void addReservation(Reservation reservation) {
        getHibernateSession().save(reservation);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateRoom(Room room) {
        getHibernateSession().update(room);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservation> getReservation(String nameUser) {

        List<Reservation> reservation = (List<Reservation>) getHibernateSession().createCriteria(Reservation.class, "reservation")
                .createAlias("reservation.client", "client")
                .createAlias("client.users", "users")
                .add(Restrictions.eq("users.user", nameUser))
                .list();

        return reservation;

    }

    @Override
    @Transactional(readOnly = true)
    public Reservation getReservation(Integer id) {

        Reservation reservation = (Reservation) getHibernateSession().createCriteria(Reservation.class, "reservation")
                .add(Restrictions.eq("reservation.idReservation", id))
                .createAlias("reservation.client", "client")
                .createAlias("client.users", "users")
                .createAlias("reservation.services", "servicios")
                .createAlias("reservation.rooms", "rooms")
                .createAlias("rooms.typeRooms", "typeRooms")
                .uniqueResult();

        if (reservation.getServices() != null) {
            reservation.getServices().size();
        }
        if (reservation.getRooms() != null) {
            reservation.getRooms().size();
            /*for (Room room : reservation.g()) {

            }*/
        }

        return reservation;
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getUserEmployee(Integer id) {

        Employee user = (Employee) getHibernateSession().createCriteria(Employee.class, "employee")
                .add(Restrictions.eq("employee.idEmployee", id))
                .createAlias("employee.users", "user")
                .uniqueResult();

        return user;
    }

    @Override
    @Transactional(readOnly = false)
    public void updateReservation(Reservation reservation) {
        getHibernateSession().update(reservation);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservation> getReservation() {

        List<Reservation> reservation = (List<Reservation>) getHibernateSession()
                .createCriteria(Reservation.class, "reservation")
                .addOrder(Order.asc("reservation.idReservation"))
                .list();

        return reservation;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Client getUserClient (Integer id){
        Client user = (Client) getHibernateSession().createCriteria(Client.class, "client")
                .add(Restrictions.eq("client.idClient", id))
                .createAlias("client.users", "user")
                .uniqueResult();

        return user;
    }
}
