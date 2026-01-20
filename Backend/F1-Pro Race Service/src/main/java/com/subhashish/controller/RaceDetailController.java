package com.subhashish.controller;

import com.subhashish.dto.RaceCalenderResponse;
import com.subhashish.dto.RaceDetailResponse;
import com.subhashish.entity.RaceDetail;
import com.subhashish.service.RaceDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Year;
import java.util.*;

@RestController
@RequestMapping("/api/F1Pro")
public class RaceDetailController {

    RaceDetailService raceDetailService;

    RaceDetailController(RaceDetailService raceDetailService) {
        this.raceDetailService = raceDetailService;
    }

    @GetMapping("/raceById/{race_id}")
    public ResponseEntity<RaceDetailResponse> getRaceDetailById(@PathVariable(name = "race_id") Integer id) {
        RaceDetailResponse raceDetail = raceDetailService.getRaceDetailById(id);
        if(raceDetail == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(raceDetail);
    }

    @GetMapping("/raceCalender")
    public ResponseEntity<RaceCalenderResponse> getRaceDetailByYear(@RequestParam(name = "year", defaultValue = "2025")Year year) {

        RaceCalenderResponse raceDetails = raceDetailService.getRaceCalenderByYear(year);

        if(raceDetails==null){
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.ok(raceDetails);
    }

    @PostMapping("/uploadRaceCalender")
    public ResponseEntity<Map<String,Object>> uploadRaceCalender(@RequestParam("file")MultipartFile raceCalenderFile) {
        raceDetailService.uploadRaceCalender(raceCalenderFile);

        Map<String,Object> response = new HashMap<>();
        response.put("message", "Race details added successfully");
        response.put("status", true);
        response.put("timestamp", new Date());

        return ResponseEntity.ok(response);
    }
}
