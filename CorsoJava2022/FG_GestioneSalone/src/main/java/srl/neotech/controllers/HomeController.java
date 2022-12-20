package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import srl.neotech.services.SaloneService;


@Controller
public class HomeController {

	@Autowired
	SaloneService salService;
	
    //Rotta per la home
    @GetMapping(value="/")
    public String home() {
        return "home";
    }
    
    @GetMapping(value="creaRepoAccessori")
    public String creaAccessori() {
    	//aaaah, il profumo della disperazione
    	salService.faiFintaDiAvereUnDBdiAccessori();
    	return "home";
    }
    
   
}
