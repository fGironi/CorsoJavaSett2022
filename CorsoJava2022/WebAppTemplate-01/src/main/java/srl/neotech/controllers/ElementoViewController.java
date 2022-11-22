package srl.neotech.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import srl.neotech.services.ElementoService;

@Controller
public class ElementoViewController {

    @Autowired
    ElementoService elementoService;

    //Rotta per la home
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(Model model) {
        Integer id=Integer.valueOf(80);
        model.addAttribute("id",id);
        return "home";
    }
    
    
    //Rotta per la getList
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String getList() {
        return "getList";
    }
    
    
    //Rotta per la getCount
    @RequestMapping(value="/count", method = RequestMethod.GET)
    public String getCount() {
        return "getCount";
    }


	//Rotta per la insertData
	@RequestMapping(value="/insertData", method = RequestMethod.GET)
	public String insertData() {
	    return "insert";
	}



}
