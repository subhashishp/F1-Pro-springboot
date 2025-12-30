package com.subhashish.controller;

import com.subhashish.dto.DriverDTO;
import com.subhashish.entity.Driver;
import com.subhashish.service.DriverService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/F1-Pro/driver")
public class DriverController {

    private final static Logger LOGGER = LoggerFactory.getLogger(DriverController.class);

    @Autowired
    DriverService driverService;

    @GetMapping("/")
    public ResponseEntity<List<Driver>> getAllDrivers(){
        LOGGER.info("Requesting all the Driver details");
        List<Driver> drivers = driverService.getAllDriver();

        if(drivers.isEmpty()){
            LOGGER.info("No driver details available");
            return ResponseEntity.noContent().build();
        }
        LOGGER.info("Sending driver details of {} drivers", drivers.size());
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/id/{driver_id}")
    ResponseEntity<Driver> getDriverById(@PathVariable("driver_id") Integer id) {
        LOGGER.info("Requesting driver details for driver id {}", id);
        return driverService.getDriverById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name")
    ResponseEntity<Driver> getDriverByName(@RequestParam("driver_name") String name){
        LOGGER.info("Requesting driver details for driver named {}", name);
        Driver driver = driverService.getDriverByName(name);

        if(driver == null){
            LOGGER.warn("No such driver named {} found", name);
            return ResponseEntity.notFound().build();
        }
        LOGGER.info("Sending driver details for driver named {}", name);
        return ResponseEntity.ok(driver);
    }

    @PostMapping("/new-driver")
    ResponseEntity<Void> saveNewDriver(@Valid @RequestBody DriverDTO driver){
        LOGGER.info("Received details of new driver");
        driverService.saveNewDriver(driver);

        return ResponseEntity.ok().build();
    }
}
