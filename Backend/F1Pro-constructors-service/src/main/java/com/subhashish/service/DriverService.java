package com.subhashish.service;

import com.subhashish.entity.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {

    List<Driver> getAllDriver();
    Driver getDriverByName(String name);
    Driver getDriverByNumber(Integer number);
    Optional<Driver> getDriverById(Integer id);

}
