package com.subhashish.service;

import com.subhashish.constants.Constant;
import com.subhashish.dto.DriverDTO;
import com.subhashish.entity.Driver;
import com.subhashish.exception.ServiceLayerException;
import com.subhashish.repository.DriverRepository;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
        try {
            return driverRepository.findAll();
        } catch (DataAccessException ex){
            throw new ServiceLayerException("Database error while fetching driver",ex);
        } catch (Exception ex){
            throw new RuntimeException(Constant.INTERNAL_SERVER_ERROR,ex);
        }
    }

    @Override
    public Driver getDriverByName(String name) {
        LOGGER.info("fetching Driver : {}", name);
        try {
            return driverRepository.findByNameIgnoreCase(name);
        } catch (DataAccessException ex){
            throw new ServiceLayerException("Database error while fetching driver",ex);
        } catch (Exception ex){
            throw new RuntimeException(Constant.INTERNAL_SERVER_ERROR,ex);
        }
    }

    @Override
    public Driver getDriverByNumber(Integer number) {
        LOGGER.info("fetching Driver using number : {}", number);
        try {
            return driverRepository.findByNumber(number);
        } catch (DataAccessException ex) {
            throw new ServiceLayerException("Un-expected error while fetching driver details",ex);
        } catch (Exception ex){
            throw new RuntimeException(Constant.INTERNAL_SERVER_ERROR,ex);
        }
    }

    @Override
    public Optional<Driver> getDriverById(Integer id) {
        LOGGER.info("fetching Driver using id : {}", id);
        try {
            return driverRepository.findById(id);
        } catch (DataAccessException ex) {
            throw new ServiceLayerException("Un-expected error while fetching driver details",ex);
        } catch (Exception ex){
            throw new RuntimeException(Constant.INTERNAL_SERVER_ERROR,ex);
        }
    }

    public Driver saveNewDriver(DriverDTO driver){
        LOGGER.info("Driver details received in service {} ", driver);
        Driver driverEntity = this.convertToEntity(driver);
        LOGGER.info("Driver Entity : {} ,{}, {} ,{}, {}", driverEntity.getId(),driverEntity
                .getNumber(),driverEntity.getName(),driverEntity.getDob(),driverEntity.getConstructor());

        driverRepository.save(driverEntity);

        return driverEntity;
    }

    public DriverDTO convertToDto(Driver driver){
        try {
            mapper.typeMap(Driver.class, DriverDTO.class)
                    .addMappings(modelMapper -> {
                        modelMapper.map(src -> src.getConstructor().getId(), DriverDTO::setConstructorId);
                        modelMapper.map(src -> src.getConstructor().getName(), DriverDTO::setConstructorName);
                    });

            return mapper.map(driver, DriverDTO.class);
        } catch (NullPointerException ex){
            throw new NullPointerException();
        } catch (MappingException ex){
            throw new RuntimeException("Error while mapping to DTO", ex);
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public Driver convertToEntity(DriverDTO driver){
        try {
            return mapper.map(driver,Driver.class);
        } catch (NullPointerException ex){
            throw new NullPointerException();
        } catch (MappingException ex){
            throw new RuntimeException("Error while mapping to Entity", ex);
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

}
