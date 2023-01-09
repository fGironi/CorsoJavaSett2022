package srl.neotech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {

    @GetMapping(value="/banco")
    public String banco() {
        return "banco";
    }
    
    @GetMapping(value="/studio")
    public String studio() {
        return "studio";
    }
}
