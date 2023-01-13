package srl.neotech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LostHumanController {

	@GetMapping(value="/")
	public String lostHumanMeetSwagger() {
		return "redirect:/swagger-ui/#/";
	}
}
