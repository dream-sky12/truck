package com.food.truck.controller;

import com.food.truck.entity.Truck;
import com.food.truck.entity.TruckList;
import com.food.truck.services.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/truck")
public class TruckController {

    @Autowired
    TruckService truckService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/all")
    public TruckList getAllTrucks() {
        return truckService.getAllTrucks();
    }

    @GetMapping(value = {"/objectid", "locationid"})
    public Truck getTruckById(@RequestParam(value = "id") String id) {
        return truckService.getTruckById(id);
    }

    @GetMapping("/applicant")
    public TruckList getTrucksByApplicant(@RequestParam(value = "applicant") String applicant) {
        return truckService.getTrucksByApplicant(applicant);
    }

    @GetMapping("/type")
    public TruckList getTrucksByType(@RequestParam(value = "type") String type) {
        return truckService.getTrucksByType(type);
    }

    @GetMapping("/status")
    public TruckList getTrucksByStatus(@RequestParam(value = "status") String status) {
        return truckService.getTrucksByStatus(status);
    }
}
