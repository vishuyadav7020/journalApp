package net.engineeringdigest.journalApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/Health-Check")
    public String health_check(){
        return "ok";
    }
}
