package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import srl.neotech.services.HomeService;
import srl.neotech.services.SaloneService;
import srl.neotech.services.TestService;


@Controller
public class HomeController {

	@Autowired
	SaloneService salService;
	@Autowired
	TestService testService;
	@Autowired
	HomeService homeService;
	
    //Rotta per la home
    @GetMapping(value="/")
    public String home(ModelMap modelMap) {
    	String bgimg=homeService.urlImmagineRandom();
    	modelMap.addAttribute("bgImgUrl", bgimg);
        return "home";
    }
    
    @GetMapping(value="creaRepoAccessori")
    public String creaAccessori() {
    	//aaaah, il profumo della disperazione
    	testService.faiFintaDiAvereUnDBdiAccessori();
    	return "redirect:/";
    }
    
   
}
