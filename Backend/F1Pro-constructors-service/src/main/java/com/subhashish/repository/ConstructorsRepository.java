package com.subhashish.repository;

import com.subhashish.entity.Constructors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConstructorsRepository extends JpaRepository<Constructors,Integer> {
    List<Constructors> findByNameIgnoreCase(String name);

}
 