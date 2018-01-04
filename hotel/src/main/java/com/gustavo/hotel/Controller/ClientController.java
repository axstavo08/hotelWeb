/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavo.hotel.Controller;

import com.gustavo.hotel.DTO.ReservationDTO;
import com.gustavo.hotel.Model.TypeRoom;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tavo
 */
@Controller
@RequestMapping(value="/hotel")
public class ClientController {
    
    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String initClient(ModelMap modelMap) {
        
        
        return "initClient";
    }
}
