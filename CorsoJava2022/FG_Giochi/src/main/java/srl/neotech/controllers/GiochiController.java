package srl.neotech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GiochiController {

    @RequestMapping(value="/parola", method = RequestMethod.GET)
    public String getGiocoParola() {
        return "parola";
    }
    @RequestMapping(value="/dajequattro", method = RequestMethod.GET)
    public String getGiocoQuattro() {
        return "quattro";
    }
}
