package com.subhashish.service;

import com.subhashish.dto.RaceCalenderResponse;
import com.subhashish.dto.RaceDetailResponse;
import com.subhashish.entity.RaceDetail;
import org.springframework.web.multipart.MultipartFile;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface RaceDetailService {

    RaceDetailResponse getRaceDetailById(Integer id);

    void uploadRaceCalender(MultipartFile raceCalenderFile);

    public RaceCalenderResponse getRaceCalenderByYear(Year year);
}
