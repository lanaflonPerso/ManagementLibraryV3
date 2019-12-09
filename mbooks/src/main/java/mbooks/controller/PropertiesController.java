package mbooks.controller;

import mbooks.config.ApplicationPropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
public class PropertiesController  {

    @Autowired
    private ApplicationPropertiesConfig appPropertiesConfig;

    @GetMapping("/renewalNumber")
    public Integer renewalNumber(){
        return appPropertiesConfig.getRenewalNumber();

    }

    @GetMapping("/renewalDay")
    public Integer renewalDay(){
        return appPropertiesConfig.getRenewalDay();

    }
    @GetMapping("/reservationCancellationDay")
    public Integer reservationCancellationDay(){
        return appPropertiesConfig.getReservationCancellationDay();

    }
    @GetMapping("/numberReservationPossible")
    public Integer numberReservationPossible(){
        return appPropertiesConfig.getNumberReservationPossible();

    }


}
