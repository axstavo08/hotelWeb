/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gustavo.hotel.Services;

import com.gustavo.hotel.DTO.AddEmployeeDTO;
import com.gustavo.hotel.Model.UserHotel;
import com.gustavo.hotel.DTO.SigninDTO;
import com.gustavo.hotel.Model.Client;
import com.gustavo.hotel.Model.Employee;
import com.gustavo.hotel.Model.Room;
import com.gustavo.hotel.Model.TypeRoom;
import com.gustavo.hotel.Model.Servicio;
import com.gustavo.hotel.Model.Reservation;
import com.gustavo.hotel.DTO.ReservationDTO;
import com.gustavo.hotel.DTO.ReservationOuputDTO;
import com.gustavo.hotel.DTO.RoomsDTO;
import java.util.Date;
/**
 *
 * @author Tavo
 */
import java.util.List;
public interface Services {
    
    public UserHotel getUser(String nameUser); 
    public void addUser(SigninDTO signin);
    public void addEmployee(AddEmployeeDTO employee);
    public Client getClientUser (String nameUser);
    public List<Client> getClientList ();
    public Employee getEmployeeUser (String nameUser);
    public List<Employee> getEmployeeList ();
    public List<Room> getRoomsByType (String typeRoom);
    public List<TypeRoom> getTypeRooms ();
    public List<RoomsDTO> getRooms ();
    public void addReservation(ReservationDTO reservation);
    public List<Servicio> getServices();
    public void cancelReservation(Integer id);
    public ReservationOuputDTO getReservationDetail(Integer id);
    public List<Reservation> getReservationByClient (String nameClient);
    public Date convertToDateTime(String date);
    public Date convertToDate(String date);
    public List<Reservation> getReservationList();
}
