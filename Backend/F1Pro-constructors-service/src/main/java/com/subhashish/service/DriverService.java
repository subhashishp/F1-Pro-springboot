package com.subhashish.service;

import com.subhashish.dto.DriverDTO;
import com.subhashish.entity.Driver;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface DriverService {

    List<Driver> getAllDriver();
    Driver getDriverByName(String name);
    Driver getDriverByNumber(Integer number);
    Optional<Driver> getDriverById(Integer id);
    Driver saveNewDriver(DriverDTO driver);

    @Transactional
    void updateDriverConstructor(Integer driverId, Integer constructorId);
}
