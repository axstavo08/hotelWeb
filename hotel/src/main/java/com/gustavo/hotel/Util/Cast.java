/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.Util;

import com.gustavo.hotel.DTO.ReservationOuputDTO;
import com.gustavo.hotel.Model.TypeRoom;
import com.gustavo.hotel.Model.Servicio;
import com.gustavo.hotel.Model.Room;
import com.gustavo.hotel.DTO.RoomsDTO;
import com.gustavo.hotel.Model.Employee;
import com.gustavo.hotel.Model.Reservation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tavo
 */
public class Cast {

    public static ReservationOuputDTO convertReservationModelToDTO(Reservation reservationModel, Employee employee) {

        ReservationOuputDTO reservation = new ReservationOuputDTO();

        if (reservationModel != null) {
            reservation.setNroRooms(String.valueOf(reservationModel.getNroRooms()));
            reservation.setTypeRoom(reservationModel.getRooms().get(0).getTypeRooms().getName());
            reservation.setCheckIn(reservationModel.getCheckIn());
            reservation.setCheckOut(reservationModel.getCheckOut());
            reservation.setStatus(reservationModel.getStatus());
            reservation.setDateCancel(reservationModel.getDateCancel());
            reservation.setAmountTotal(reservationModel.getAmount());
            if (employee != null) {
                reservation.setNameEmployee(employee.getUsers().getName());
                reservation.setLastNameEmployee(employee.getUsers().getLastNamePat() + " " + employee.getUsers().getLastNameMat());
            }
            String nameRooms = "";
            for(int i=0; i<reservationModel.getRooms().size(); i++){
                if(i==reservationModel.getRooms().size()-1){
                    nameRooms += reservationModel.getRooms().get(i).getNroRoom();
                }else{
                    nameRooms += reservationModel.getRooms().get(i).getNroRoom() + ", ";
                }
            }
            reservation.setNameRooms(nameRooms);
            List<String> servicioList = new ArrayList<>();
            for(Servicio servicio : reservationModel.getServices()){
                servicioList.add(servicio.getName());
            }
            reservation.setServices(servicioList);
            reservation.setNameClient(reservationModel.getClient().getUsers().getName());
            reservation.setLastNameClient(reservationModel.getClient().getUsers().getLastNamePat()+" "+reservationModel.getClient().getUsers().getLastNameMat());
        }else{
            reservation = null;
        }

        return reservation;
    }

    public static List<RoomsDTO> convertRoomsInfoToRoomsDTO(List<Room> roomList) {

        List<RoomsDTO> roomDTOList = new ArrayList<>();

        if (roomList.size() > 0) {
            for (Room room : roomList) {
                RoomsDTO roomDTO = new RoomsDTO();
                roomDTO.setId(room.getIdRoom());
                roomDTO.setNroRoom(room.getNroRoom());
                roomDTO.setTypeRoom(room.getTypeRooms().getName());
                String available = (room.getAvailable() == true) ? "Si" : "No";
                roomDTO.setAvailable(available);
                roomDTOList.add(roomDTO);
            }
        } else {
            return null;
        }

        return roomDTOList;
    }

}
