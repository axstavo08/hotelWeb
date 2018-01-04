/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.Controller;

import com.gustavo.hotel.DTO.AddEmployeeDTO;
import com.gustavo.hotel.Model.UserHotel;
import com.gustavo.hotel.Model.Client;
import com.gustavo.hotel.Model.Room;
import com.gustavo.hotel.Model.TypeRoom;
import com.gustavo.hotel.Model.Servicio;
import com.gustavo.hotel.Util.Cast;
import com.gustavo.hotel.DTO.LoginDTO;
import com.gustavo.hotel.DTO.RoomsDTO;
import com.gustavo.hotel.Model.Reservation;
import com.gustavo.hotel.DTO.SigninDTO;
import com.gustavo.hotel.DTO.ReservationDTO;
import com.gustavo.hotel.DTO.ReservationOuputDTO;
import com.gustavo.hotel.Services.Services;
import com.gustavo.hotel.DTO.Validator.SigninDTOValidator;
import com.gustavo.hotel.DTO.Validator.LoginDTOValidator;
import com.gustavo.hotel.DTO.Validator.ReservationDTOValidator;
import com.gustavo.hotel.DTO.Validator.AddEmployeeDTOValidator;
import com.gustavo.hotel.Model.Employee;
import com.gustavo.hotel.Security.Entity.UserDetailHotel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Tavo
 */
@Controller
public class MainController {

    @Autowired
    Services services;

    @Autowired
    SigninDTOValidator signinValidator;

    @Autowired
    LoginDTOValidator loginValidator;

    @Autowired
    ReservationDTOValidator reservationValidator;

    @Autowired
    AddEmployeeDTOValidator addEmployeeValidator;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String init(@RequestParam(required = false) String error, ModelMap modelMap) {

        List<TypeRoom> typeRoomList = services.getTypeRooms();
        ReservationDTO reservDTO = new ReservationDTO();

        modelMap.addAttribute("typeRooms", typeRoomList);
        modelMap.addAttribute("reservation", reservDTO);

        //services.addReservation();
        //String nameClient = "GUSTAVO.RAMOS";
        //List<Reservation> reservation = services.getReservationByClient(nameClient);
        //services.cancelReservation(nameClient);
        return "inicio";
    }

    @RequestMapping(value = "/hotel", method = RequestMethod.POST)
    public String initPost(@ModelAttribute("reservation") ReservationDTO reservationDTO, BindingResult result, ModelMap modelMap) {

        return "login";
    }

    @RequestMapping(value = "/information", method = RequestMethod.GET)
    public String information(@RequestParam(required = false) String error, ModelMap modelMap) {

        return "information";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(required = false) String error, ModelMap modelMap) {

        /*LoginDTO login = new LoginDTO();
        modelMap.addAttribute("login", login);

        return "login";*/
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/login";
        }

        if (error != null && "true".equals(error)) {
            modelMap.addAttribute("error", true);
        }

        return "login";
    }

    @RequestMapping(value = {"/signin"}, method = RequestMethod.GET)
    public String signin(@RequestParam(required = false) String error, ModelMap modelMap) {

        SigninDTO signin = new SigninDTO();
        modelMap.addAttribute("signin", signin);

        return "signin";
    }

    @RequestMapping(value = {"/signin"}, method = RequestMethod.POST)
    public String signinPost(@ModelAttribute("signin") SigninDTO signinDTO, BindingResult result, ModelMap modelMap) {

        signinValidator.validate(signinDTO, result);
        if (result.hasErrors()) {
            modelMap.addAttribute("errorSignin", 1);
            return "signin";
        }

        services.addUser(signinDTO);
        modelMap.addAttribute("signinSuccess", 0);

        return "signin";
    }

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String initClient(ModelMap modelMap) {

        String nameClient = ((UserDetailHotel) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        List<Reservation> reservation = services.getReservationByClient(nameClient);

        modelMap.addAttribute("reservationList", reservation);

        return "initClient";
    }

    @RequestMapping(value = "/client/services", method = RequestMethod.GET)
    public String clientServices(ModelMap modelMap) {

        List<TypeRoom> typeRoomList = services.getTypeRooms();

        List<Servicio> servicioList = services.getServices();

        modelMap.addAttribute("typeRoomList", typeRoomList);
        modelMap.addAttribute("servicioList", servicioList);

        return "servicesClient";
    }

    @RequestMapping(value = "/client/reservation", method = RequestMethod.GET)
    public String clientReservation(ModelMap modelMap) {

        List<TypeRoom> typeRoom = services.getTypeRooms();
        List<Servicio> servicio = services.getServices();
        ReservationDTO reservation = new ReservationDTO();

        modelMap.addAttribute("typeRooms", typeRoom);
        modelMap.addAttribute("servicios", servicio);
        modelMap.addAttribute("reservation", reservation);

        return "reservClient";
    }

    @RequestMapping(value = "/client/reservation", method = RequestMethod.POST)
    public String clientReservationPost(@ModelAttribute("reservation") ReservationDTO reservationDTO, BindingResult result, ModelMap modelMap) {

        reservationValidator.validate(reservationDTO, result);
        if (result.hasErrors()) {
            modelMap.addAttribute("errorReserv", 1);
            List<Servicio> servicio = services.getServices();
            modelMap.addAttribute("servicios", servicio);
            List<TypeRoom> typeRoom = services.getTypeRooms();
            modelMap.addAttribute("typeRooms", typeRoom);
            return "reservClient";
        }

        services.addReservation(reservationDTO);
        modelMap.addAttribute("reservSucess", 0);

        return "reservClient";
    }

    @RequestMapping(value = "/client/reservation/{id}/cancel", method = RequestMethod.GET)
    public String clientReservationCancel(@PathVariable("id") Integer id, ModelMap modelMap) {

        services.cancelReservation(id);

        return "redirect:/client";
    }

    @RequestMapping(value = "/client/reservation/{id}", method = RequestMethod.GET)
    public String clientReservationDetail(@PathVariable("id") Integer id, ModelMap modelMap) {

        ReservationOuputDTO reservation = services.getReservationDetail(id);

        modelMap.addAttribute("reservation", reservation);

        return "detailReservClient";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String initEmployee(ModelMap modelMap) {

        List<Reservation> reservation = services.getReservationList();

        modelMap.addAttribute("reservationList", reservation);

        return "initEmployee";
    }

    @RequestMapping(value = "/employee/{id}/reservation", method = RequestMethod.GET)
    public String employeeReservation(@PathVariable("id") Integer id, ModelMap modelMap) {

        List<TypeRoom> typeRoom = services.getTypeRooms();
        List<Servicio> servicio = services.getServices();
        ReservationDTO reservation = new ReservationDTO();
        reservation.setIdCliente(id);

        modelMap.addAttribute("typeRooms", typeRoom);
        modelMap.addAttribute("servicios", servicio);
        modelMap.addAttribute("reservation", reservation);

        return "reservEmployee";
    }

    @RequestMapping(value = "/employee/{id}/reservation", method = RequestMethod.POST)
    public String employeeReservationPost(@PathVariable("id") Integer id, @ModelAttribute("reservation") ReservationDTO reservationDTO, BindingResult result, ModelMap modelMap) {

        reservationDTO.setIdCliente(id);
        reservationValidator.validate(reservationDTO, result);
        if (result.hasErrors()) {
            modelMap.addAttribute("errorReserv", 1);
            List<TypeRoom> typeRoom = services.getTypeRooms();
            List<Servicio> servicio = services.getServices();
            modelMap.addAttribute("typeRooms", typeRoom);
            modelMap.addAttribute("servicios", servicio);
            return "reservEmployee";
        }

        services.addReservation(reservationDTO);
        modelMap.addAttribute("reservSucess", 0);

        return "reservEmployee";
    }

    @RequestMapping(value = "/employee/reservation/{id}/cancel", method = RequestMethod.GET)
    public String employeeReservationCancel(@PathVariable("id") Integer id, ModelMap modelMap) {

        services.cancelReservation(id);

        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/reservation/{id}", method = RequestMethod.GET)
    public String employeeReservationDetail(@PathVariable("id") Integer id, ModelMap modelMap) {

        ReservationOuputDTO reservation = services.getReservationDetail(id);

        modelMap.addAttribute("reservation", reservation);

        return "detailReservEmployee";
    }

    @RequestMapping(value = "/employee/services", method = RequestMethod.GET)
    public String employeeServices(ModelMap modelMap) {

        List<TypeRoom> typeRoomList = services.getTypeRooms();
        //Cast.convertTypeRoomToFormatPrice(typeRoomList);

        List<Servicio> servicioList = services.getServices();
        //Cast.convertServicesToFormatPrice(servicioList);

        modelMap.addAttribute("typeRoomList", typeRoomList);
        modelMap.addAttribute("servicioList", servicioList);

        return "servicesEmployee";
    }

    @RequestMapping(value = "/employee/rooms", method = RequestMethod.GET)
    public String employeeRooms(ModelMap modelMap) {

        List<RoomsDTO> roomList = services.getRooms();

        modelMap.addAttribute("roomList", roomList);

        return "roomsEmployee";
    }

    @RequestMapping(value = "/employee/employees", method = RequestMethod.GET)
    public String employeeList(ModelMap modelMap) {

        List<Employee> employeeList = services.getEmployeeList();
        modelMap.addAttribute("employeeList", employeeList);

        return "employeesEmployee";
    }

    @RequestMapping(value = "/employee/addEmployee", method = RequestMethod.GET)
    public String employeeAdd(ModelMap modelMap) {

        AddEmployeeDTO employee = new AddEmployeeDTO();
        modelMap.addAttribute("addEmployee", employee);

        return "addEmployee";
    }

    @RequestMapping(value = "/employee/addEmployee", method = RequestMethod.POST)
    public String employeeAddPost(@ModelAttribute("addEmployee") AddEmployeeDTO addEmployeeDTO, BindingResult result, ModelMap modelMap) {

        addEmployeeValidator.validate(addEmployeeDTO, result);
        if (result.hasErrors()) {
            modelMap.addAttribute("errorAddEmployee", 1);
            return "addEmployee";
        }

        services.addEmployee(addEmployeeDTO);
        modelMap.addAttribute("addEmployeeSuccess", 0);

        return "addEmployee";
    }

    @RequestMapping(value = "/employee/clients", method = RequestMethod.GET)
    public String employeeListClient(ModelMap modelMap) {

        List<Client> clientList = services.getClientList();
        modelMap.addAttribute("clientList", clientList);

        return "clientsEmployee";
    }

    @RequestMapping(value = "/employee/addClient", method = RequestMethod.GET)
    public String clientAdd(ModelMap modelMap) {

        SigninDTO client = new SigninDTO();
        modelMap.addAttribute("addClient", client);

        return "addClient";
    }

    @RequestMapping(value = "/employee/addClient", method = RequestMethod.POST)
    public String employeeAddPost(@ModelAttribute("addClient") SigninDTO clientDTO, BindingResult result, ModelMap modelMap) {

        signinValidator.validate(clientDTO, result);
        if (result.hasErrors()) {
            modelMap.addAttribute("errorAddClient", 1);
            return "addClient";
        }

        services.addUser(clientDTO);
        modelMap.addAttribute("addClientSuccess", 0);

        return "addClient";
    }

}
