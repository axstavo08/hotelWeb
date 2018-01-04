/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.Services.ServicesImpl;

import com.gustavo.hotel.DTO.AddEmployeeDTO;
import com.gustavo.hotel.DTO.ReservationDTO;
import com.gustavo.hotel.DTO.ReservationOuputDTO;
import com.gustavo.hotel.DTO.RoomsDTO;
import com.gustavo.hotel.DTO.SigninDTO;
import com.gustavo.hotel.Model.Client;
import com.gustavo.hotel.Model.UserHotel;
import com.gustavo.hotel.Model.Employee;
import com.gustavo.hotel.Model.Reservation;
import com.gustavo.hotel.Model.Servicio;
import com.gustavo.hotel.Model.Room;
import com.gustavo.hotel.Model.TypeRoom;
import com.gustavo.hotel.Util.EncryptionMD5;
import com.gustavo.hotel.Services.Services;
import com.gustavo.hotel.Repository.HotelRepository;
import com.gustavo.hotel.Security.Entity.UserDetailHotel;
import com.gustavo.hotel.Util.Cast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Tavo
 */
@Service
public class ServicesImpl implements Services {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public UserHotel getUser(String nameUser) {
        return (UserHotel) hotelRepository.getUser(nameUser);
    }

    @Override
    public void addUser(SigninDTO signin) {

        Client client = new Client();
        UserHotel user = new UserHotel();

        user.setUser(signin.getUserName().toUpperCase());
        BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
        String pass = bcryptEncoder.encode(signin.getPassword());
        user.setPassword(pass);
        user.setName(signin.getName().toUpperCase());
        user.setLastNamePat(signin.getLastNamePat().toUpperCase());
        user.setLastNameMat(signin.getLastNameMat().toUpperCase());
        user.setEmail(signin.getEmail().toUpperCase());
        user.setStatus(true);
        user.setTipo("Cliente".toUpperCase());

        client.setUsers(user);
        client.setCity(signin.getCity().toUpperCase());
        client.setCountry(signin.getCountry().toUpperCase());

        hotelRepository.addUser(client);
    }

    @Override
    public void addEmployee(AddEmployeeDTO employeeDTO) {

        Employee employee = new Employee();
        UserHotel user = new UserHotel();

        user.setUser(employeeDTO.getUsername().toUpperCase());
        BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
        String pass = bcryptEncoder.encode(employeeDTO.getPassword());
        user.setPassword(pass);
        user.setName(employeeDTO.getName().toUpperCase());
        user.setLastNamePat(employeeDTO.getLastNamePat().toUpperCase());
        user.setLastNameMat(employeeDTO.getLastNameMat().toUpperCase());
        user.setEmail(employeeDTO.getEmail().toUpperCase());
        user.setStatus(true);
        user.setTipo("EMPLEADO".toUpperCase());

        Date dateIn = convertToDate(employeeDTO.getInJob());
        Date dateOut = convertToDate(employeeDTO.getOutJob());

        employee.setUsers(user);
        employee.setJob(employeeDTO.getJob().toUpperCase());
        employee.setDateIn(dateIn);
        employee.setDateOut(dateOut);

        hotelRepository.addEmployee(employee);
    }

    @Override
    public Client getClientUser(String nameUser) {
        return hotelRepository.getClientUser(nameUser);
    }

    @Override
    public List<Room> getRoomsByType(String typeRoom) {
        return hotelRepository.getRoomsByType(typeRoom);
    }

    @Override
    public List<TypeRoom> getTypeRooms() {
        return hotelRepository.getTypeRooms();
    }

    @Override
    public List<RoomsDTO> getRooms() {
        return Cast.convertRoomsInfoToRoomsDTO(hotelRepository.getRooms());
    }

    @Override
    public List<Servicio> getServices() {
        return hotelRepository.getServices();
    }

    @Override
    public void addReservation(ReservationDTO reservation) {

       
        //UserDetailHotel userDetail = (UserDetailHotel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String nameUser = ((UserDetailHotel) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        double importeTotal = reservation.getImporteEst();
        
        Client client = new Client();
        int idEmployee = 0;
        if(reservation.getIdCliente()==null){
            client = hotelRepository.getClientUser(nameUser);
        }else{
            client = hotelRepository.getUserClient(reservation.getIdCliente());
            idEmployee = ((Employee) hotelRepository.getEmployeeUser(nameUser)).getIdEmployee();
        }
        

        List<Servicio> servicesList = hotelRepository.getServices();
        List<Servicio> servicioListAux = new ArrayList<>();

        for (Servicio serviceAux : servicesList) {
            for (String reservList : reservation.getServices()) {
                if (serviceAux.getName().equals(reservList)) {
                    servicioListAux.add(serviceAux);
                    //reservation.getServices().remove(reservList);
                    break;
                }
            }
        }

        for (int i = 0; i < servicioListAux.size(); i++) {
            importeTotal += servicioListAux.get(i).getPrice();
        }

        List<Room> roomList = hotelRepository.getRoomsByType(reservation.getTypeRoom().toUpperCase());
        List<Room> roomListAux = new ArrayList<>();

        for (int i = 0; i < reservation.getNroRooms(); i++) {
            for (Room roomAux : roomList) {
                roomListAux.add(roomAux);
                roomAux.setAvailable(false);
                hotelRepository.updateRoom(roomAux);
                roomList.remove(roomAux);
                break;
            }
        }

        for (int i = 0; i < roomListAux.size(); i++) {
            importeTotal += roomListAux.get(i).getTypeRooms().getPrice();
        }

        Date checkin = convertToDateTime(reservation.getCheckIn());
        Date checkout = convertToDateTime(reservation.getCheckOut());

        Reservation reservObj = new Reservation();

        reservObj.setNroRooms(reservation.getNroRooms());
        reservObj.setCheckIn(checkin);
        reservObj.setCheckOut(checkout);
        reservObj.setStatus("EN CURSO");
        reservObj.setAmount(importeTotal);
        reservObj.setClient(client);
        reservObj.setServices(servicioListAux);
        reservObj.setRooms(roomListAux);
        if(idEmployee!=0){
            reservObj.setIdEmployee(idEmployee);
        }
        
        hotelRepository.addReservation(reservObj);
    }

    @Override
    public List<Client> getClientList() {
        return hotelRepository.getClientList();
    }

    @Override
    public Employee getEmployeeUser(String nameUser) {
        return hotelRepository.getEmployeeUser(nameUser);
    }

    @Override
    public List<Employee> getEmployeeList() {
        return hotelRepository.getEmployeeList();
    }

    @Override
    public List<Reservation> getReservationByClient(String nameClient) {
        return hotelRepository.getReservation(nameClient);
    }

    @Override
    public void cancelReservation(Integer id) {
        
        Reservation reservation = hotelRepository.getReservation(id);
        
        Date dateCancel = new Date();
        
        //dateCancel = convertToDateTime(String.valueOf(dateCancel.getTime()));
        
        reservation.setDateCancel(dateCancel);
        reservation.setStatus("CANCELADO");
        
//        hotelRepository.updateReservation(reservation);
        
    }
    
    @Override
    public List<Reservation> getReservationList(){
        return hotelRepository.getReservation();
    }
    
    @Override
    public Date convertToDateTime(String date) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm a");

        try {
            Date dateConv = formatter.parse(date);
            return dateConv;
        } catch (ParseException ex) {
            Logger.getLogger(ServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public Date convertToDate(String date) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date dateConv = formatter.parse(date);
            return dateConv;
        } catch (ParseException ex) {
            Logger.getLogger(ServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    @Override
    public ReservationOuputDTO getReservationDetail(Integer id){
        
        Reservation reservationModel = hotelRepository.getReservation(id);
        
        Employee employee = null;
        if(reservationModel.getIdEmployee()!=null){
            employee = hotelRepository.getUserEmployee(reservationModel.getIdEmployee());
        }
        
        ReservationOuputDTO reservationDTO = Cast.convertReservationModelToDTO(reservationModel, employee);
        
        return reservationDTO;
    }
}
