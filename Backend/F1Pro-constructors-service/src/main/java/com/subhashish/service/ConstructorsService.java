package com.subhashish.service;

import com.subhashish.entity.Constructors;

import java.util.List;

public interface ConstructorsService {

     Constructors getById(Integer id);
     List<Constructors> getAllConstructorsDetials();
     Constructors getByConstructorName(String name);
     Constructors saveNewConstructor(String name, Integer year);
}
