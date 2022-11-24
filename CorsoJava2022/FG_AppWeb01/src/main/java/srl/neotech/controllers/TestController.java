package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import srl.neotech.services.ElementoService;

@Controller
public class TestController {

	 @Autowired
	    ElementoService elementoService;
	
    //Mapping nuova pagina
    @RequestMapping(value="/test", method = RequestMethod.GET)
    public String getList() {
        return "paginaTest";
    }
    
}
