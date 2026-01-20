package com.subhashish.repository;

import com.subhashish.entity.RaceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Year;
import java.util.List;

public interface RaceRepostory extends JpaRepository<RaceDetail,Integer> {

    @Query(value = "SELECT * FROM race_detail\n" +
            "WHERE YEAR(race_date) = :year", nativeQuery = true)
    public List<RaceDetail> findRaceCalenderByYear(@Param("year") Year year);
}
