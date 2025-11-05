package com.subhashish.controller;

import com.subhashish.entity.Constructors;
import com.subhashish.service.ConstructorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.hibernate.Hibernate.map;

@RestController
@RequestMapping("/api/F1-Pro")
public class ConstructorsController {

    private final static Logger logger = LoggerFactory.getLogger(ConstructorsController.class);

    @Autowired
    ConstructorsService constructorsService;

    @GetMapping("/constructor/{constructorId}")
    public ResponseEntity<Constructors> getById(@PathVariable("constructorId")  Integer id){
        logger.warn("requesting Constructor by constructor id : {}", id);

        Constructors obj = constructorsService.getById(id);
        if(obj == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/allConstructors")
    public ResponseEntity<List<Constructors>> getAllConstructors(){
        logger.info("requesting all constructors");

        List<Constructors> constructors =  constructorsService.getAllConstructorsDetials();
        return new ResponseEntity<>(constructors, HttpStatus.OK);
    }

    @GetMapping("/constructor")
    public ResponseEntity<Constructors> getByName(@RequestParam(name = "constructorName") String name){
        logger.info("requesting Constructor by name : {}",name);
        Constructors obj = constructorsService.getByConstructorName(name);
        if(obj == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(obj);
    }
}
