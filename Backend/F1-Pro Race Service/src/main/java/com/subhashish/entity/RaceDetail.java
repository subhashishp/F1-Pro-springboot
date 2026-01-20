package com.subhashish.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "race_detail")
@Data
public class RaceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer race_id;
    @Column(name = "race_number")
    Integer raceNumber;
    @Column(name = "race_name")
    String raceName;
    @Column(name = "race_date")
    Date date;
    @Column(name = "race_country")
    String country;

    public RaceDetail() {
    }

    public RaceDetail(Integer race_id, Integer raceNumber, String race_name, Date date, String country) {
        this.race_id = race_id;
        this.raceNumber = raceNumber;
        this.raceName = race_name;
        this.date = date;
        this.country = country;
    }

    public Integer getRace_id() {
        return race_id;
    }

    public void setRace_id(Integer race_id) {
        this.race_id = race_id;
    }

    public Integer getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(Integer raceNumber) {
        this.raceNumber = raceNumber;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String race_name) {
        this.raceName = race_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
