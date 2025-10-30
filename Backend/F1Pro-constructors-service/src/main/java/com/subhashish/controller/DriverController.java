package com.subhashish.controller;

import com.subhashish.entity.Driver;
import com.subhashish.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/F1-Pro/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("/")
    public ResponseEntity<List<Driver>> getAllDrivers(){
        List<Driver> drivers = driverService.getAllDriver();

        if(drivers.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/id/{driver_id}")
    ResponseEntity<Driver> getDriverById(@PathVariable("driver_id") Integer id) {
        return driverService.getDriverById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name")
    ResponseEntity<Driver> getDriverByName(@RequestParam("driver_name") String name){
        Driver driver = driverService.getDriverByName(name);

        if(driver == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(driver);
    }
}
