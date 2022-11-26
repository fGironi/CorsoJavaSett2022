package srl.neotech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MusicController {
	
	@RequestMapping(value="/listMusic", method = RequestMethod.GET)
	public String listMusic() {
	    return "listMusic";
	}	
	
	@RequestMapping(value="/musicDetails", method = RequestMethod.GET)
	public String mDetails() {
	    return "musicDetails";
	}	

}
