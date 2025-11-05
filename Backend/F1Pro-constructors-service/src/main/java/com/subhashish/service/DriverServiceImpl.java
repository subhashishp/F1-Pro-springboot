package com.subhashish.service;

import com.subhashish.dto.DriverDTO;
import com.subhashish.entity.Driver;
import com.subhashish.repository.DriverRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    private final static Logger LOGGER = LoggerFactory.getLogger(DriverServiceImpl.class);

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Driver> getAllDriver() {
        LOGGER.info("fetching all the driver details");

        return driverRepository.findAll();
    }

    @Override
    public Driver getDriverByName(String name) {
        LOGGER.info("fetching Driver : {}", name);
        return driverRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Driver getDriverByNumber(Integer number) {
        LOGGER.info("fetching Driver using number : {}", number);
        return driverRepository.findByNumber(number);
    }

    @Override
    public Optional<Driver> getDriverById(Integer id) {
        LOGGER.info("fetching Driver using id : {}", id);
        return driverRepository.findById(id);
    }

    public DriverDTO convertToDto(Driver driver){
        mapper.typeMap(Driver.class, DriverDTO.class)
                .addMappings(modelMapper -> {
                    modelMapper.map(src -> src.getConstructor().getId(), DriverDTO::setConstructorId);
                    modelMapper.map(src -> src.getConstructor().getName(), DriverDTO::setConstructorName);
                });

        return mapper.map(driver, DriverDTO.class);
    }
}
