/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.DTO.Validator;

import com.gustavo.hotel.DTO.ReservationDTO;
import com.gustavo.hotel.DTO.SigninDTO;
import com.gustavo.hotel.Model.Reservation;
import com.gustavo.hotel.Model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import com.gustavo.hotel.Repository.HotelRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import com.gustavo.hotel.Services.Services;
import org.springframework.validation.Errors;
import com.gustavo.hotel.Model.UserHotel;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Tavo
 */
@Component
public class ReservationDTOValidator implements Validator {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public boolean supports(Class clazz) {
        return SigninDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ReservationDTO reservation = (ReservationDTO) o;

        if (reservation.getNroRooms() == 0) {
            errors.rejectValue("nroRooms", "nroRooms.empty", "Seleccione un número de habitaciones.");
        }

        if (reservation.getCheckIn() == null) {
            errors.rejectValue("checkIn", "checkIn.empty", "Elija fecha de entrada.");
        }

        if (reservation.getCheckOut() == null) {
            errors.rejectValue("checkOut", "checkOut.empty", "Elija fecha de salida.");
        }

        if (reservation.getServices() == null) {
            errors.rejectValue("services", "services.empty", "Elija por lo menos una reservación.");
        }

        if (reservation.getTypeRoom().equals("0")) {
            errors.rejectValue("typeRoom", "typeRoom.empty", "Elija un tipo de habitación.");
        }

        if (reservation.getTypeRoom() != null) {
            List<Room> reservModel = hotelRepository.getRoomsByType(reservation.getTypeRoom());
            if (reservModel.size() < reservation.getNroRooms()) {
                errors.rejectValue("nroRooms", "nroRooms.empty", "No hay habitaciones disponibles con el número elegido.");
            }
        }
    }
}
