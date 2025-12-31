package com.subhashish.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.subhashish.dto.DriverDTO;
import com.subhashish.entity.Constructors;
import com.subhashish.entity.Driver;
import com.subhashish.exception.ResourceNotFoundException;
import com.subhashish.service.ConstructorsService;
import com.subhashish.service.DriverService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/F1-Pro/driver")
public class DriverController {

    private final static Logger LOGGER = LoggerFactory.getLogger(DriverController.class);

    @Autowired
    DriverService driverService;

    @Autowired
    ConstructorsService constructorsService;

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

    @PatchMapping("/updateConstructor/{driver_id}")
    ResponseEntity<Constructors> updateDriverToConstruct(@PathVariable("driver_id") Integer driver,@RequestBody JsonNode request){

        JsonNode constructorIdNode = request.get("constructorId");
        JsonNode constructorNameNode = request.get("constructorName");
        Integer constructorId = 0;

        if(constructorIdNode != null){
            constructorId = constructorIdNode.asInt();
        }
        else if(constructorNameNode != null) {
            Constructors obj = constructorsService.getByConstructorName(constructorNameNode.asText());
            if(obj == null)
                throw new ResourceNotFoundException("Constructor not found");
            else
                constructorId = obj.getId();
        }

        LOGGER.info("Adding driver {} to {} constructorId",driver,constructorId);

        driverService.updateDriverConstructor(driver,constructorId);

        return ResponseEntity.ok(constructorsService.getById(constructorId));
    }

    @DeleteMapping("removeConstructor/{driver_id}")
    ResponseEntity<Map<String,Object>> removeDriverFromConstructor(@PathVariable(name = "driver_id") Integer driverId){
        LOGGER.info("Request to removing constructor mapping for driver having id {}", driverId);

        int rowEffected = driverService.removeDriverConstructor(driverId);

        Map<String,Object> response = new HashMap<>();

        response.put("constructorsRemoved", rowEffected);
        response.put("driverId", driverId);
        response.put("message", "Constructor removed successfully");
        response.put("status", true);
        response.put("timestamp", new Date());

        return ResponseEntity.ok(response);
    }
}
