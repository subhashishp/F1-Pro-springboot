package com.subhashish.dto;

import java.time.Year;
import java.util.List;

public class RaceCalenderResponse {

    Year CalenderYear;
    List<RaceDetailResponse> raceCalender;

    public RaceCalenderResponse(Year calenderYear, List<RaceDetailResponse> raceCalender) {
        this.raceCalender = raceCalender;
        CalenderYear = calenderYear;
    }

    public Year getCalenderYear() {
        return CalenderYear;
    }

    public void setCalenderYear(Year calenderYear) {
        CalenderYear = calenderYear;
    }

    public List<RaceDetailResponse> getRaceCalender() {
        return raceCalender;
    }

    public void setRaceCalender(List<RaceDetailResponse> raceCalender) {
        this.raceCalender = raceCalender;
    }
}
