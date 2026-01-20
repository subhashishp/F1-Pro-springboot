package com.subhashish.dto;

import java.util.Date;

public class RaceDetailResponse {

    Integer raceNumber;
    String raceName;
    Date raceDate;
    String raceCountry;

    public Integer getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(Integer raceNumber) {
        this.raceNumber = raceNumber;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Date getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }

    public String getRaceCountry() {
        return raceCountry;
    }

    public void setRaceCountry(String raceCountry) {
        this.raceCountry = raceCountry;
    }
}
