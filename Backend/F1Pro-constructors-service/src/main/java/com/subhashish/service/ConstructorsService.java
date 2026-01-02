package com.subhashish.service;

import com.subhashish.entity.Constructors;

import java.util.List;
import java.util.Optional;

public interface ConstructorsService {

     Optional<Constructors> getById(Integer id);
     List<Constructors> getAllConstructorsDetials();
     Constructors getByConstructorName(String name);
     Constructors saveNewConstructor(String name, Integer year);
}
