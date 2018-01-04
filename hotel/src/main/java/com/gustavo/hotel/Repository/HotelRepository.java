/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gustavo.hotel.Repository;

import com.gustavo.hotel.Model.UserHotel;
import com.gustavo.hotel.Model.Client;
import com.gustavo.hotel.Model.Employee;
import com.gustavo.hotel.Model.TypeRoom;
import com.gustavo.hotel.Model.Room;
import com.gustavo.hotel.Model.Servicio;
import com.gustavo.hotel.Model.Reservation;
import java.util.List;

/**
 *
 * @author Tavo
 */
public interface HotelRepository {
    
    public UserHotel getUser (String nameUser);
    public void addUser (Client client);
    public List<TypeRoom> getTypeRooms ();
    public List<Room> getRooms ();
    public List<Room> getRoomsByType (String typeRoom);
    public Client getClientUser (String nameUser);
    public List<Client> getClientList ();
    public Employee getEmployeeUser (String nameUser);
    public List<Employee> getEmployeeList ();
    public List<Servicio> getServices ();
    public void addReservation (Reservation reservation);
    public void updateRoom (Room room);
    public List<Reservation> getReservation (String nameUser);
    public void addEmployee (Employee employee);
    public Reservation getReservation(Integer id);
    public void updateReservation(Reservation reservation);
    public List<Reservation> getReservation ();
    public Employee getUserEmployee (Integer id);
    public Client getUserClient (Integer id);
}
