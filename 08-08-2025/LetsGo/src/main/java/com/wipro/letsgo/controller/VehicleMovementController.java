package com.wipro.letsgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.letsgo.entity.VehicleMovement;
import com.wipro.letsgo.repository.VehicleMovementRepository;

@RestController
public class VehicleMovementController {

    @Autowired
    private VehicleMovementRepository repository;

    @PostMapping("/move")
    public String moveVehicle(@RequestBody VehicleMovement movement) {
        repository.save(movement);
        return "Vehicle movement saved successfully!";
    }
}
