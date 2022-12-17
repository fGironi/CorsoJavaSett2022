package srl.neotech.testing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import srl.neotech.model.Elemento;

@Controller
public class MVCController {

	@GetMapping(value="mvc")
	public String testMVC() {
		
		Elemento elem=new Elemento();
		elem.setDescrizione("prova");
		elem.setId(10);
		
		return "MVCView";
	}
}
