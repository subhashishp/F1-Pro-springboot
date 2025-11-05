package com.subhashish.service;

import com.subhashish.entity.Constructors;
import com.subhashish.repository.ConstructorsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ConstructorsServiceImpl implements ConstructorsService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ConstructorsServiceImpl.class);

    @Autowired
    ConstructorsRepository repository;

    @Override
    public Constructors getById(Integer id){
        LOGGER.info("fetching constructor details using id {}",id);
        return repository.getById(id);
    }

    @Override
    public List<Constructors> getAllConstructorsDetials(){
        //System.out.println(repository.findAll().getFirst().getName());
        LOGGER.info("fetching constructor details");
        return repository.findAll();
    }

    public Constructors getByConstructorName(String name){
        List<Constructors> list = repository.findByNameIgnoreCase(name);
        LOGGER.info("Fetched {} constructor from DB",list.getFirst().getName());
        if(list.isEmpty())
            return null;
        else
            return list.getFirst();
    }
}
