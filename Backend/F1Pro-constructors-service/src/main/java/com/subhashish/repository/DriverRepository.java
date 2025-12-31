package com.subhashish.repository;

import com.subhashish.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {

    Driver findByNumber(Integer number);
    Driver findByNameIgnoreCase(String name);

    @Modifying
    @Query("UPDATE Driver d SET d.constructor = null WHERE d.id = :id")
    int removeDriverConstructor(@Param("id") Integer id);

}
