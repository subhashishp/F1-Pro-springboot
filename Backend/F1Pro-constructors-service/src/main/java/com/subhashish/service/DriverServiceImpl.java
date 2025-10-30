package com.subhashish.service;

import com.subhashish.entity.Driver;
import com.subhashish.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Override
    public List<Driver> getAllDriver() {
        return driverRepository.findAll();
    }

    @Override
    public Driver getDriverByName(String name) {
        return driverRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Driver getDriverByNumber(Integer number) {
        return driverRepository.findByNumber(number);
    }

    @Override
    public Optional<Driver> getDriverById(Integer id) {
        return driverRepository.findById(id);
    }
}
