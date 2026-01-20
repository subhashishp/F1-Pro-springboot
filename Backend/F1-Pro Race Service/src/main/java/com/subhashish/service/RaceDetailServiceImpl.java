package com.subhashish.service;

import com.subhashish.dto.RaceCalenderResponse;
import com.subhashish.dto.RaceDetailResponse;
import com.subhashish.entity.RaceDetail;
import com.subhashish.repository.RaceRepostory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RaceDetailServiceImpl implements RaceDetailService{

    RaceRepostory raceRepostory;
    private final ModelMapper modelMapper;

    RaceDetailServiceImpl(RaceRepostory raceRepostory, ModelMapper modelMapper) {
        this.raceRepostory = raceRepostory;
        this.modelMapper = modelMapper;
    }

    @Override
    public RaceDetailResponse getRaceDetailById(Integer id) {
        RaceDetailResponse response = modelMapper.map(raceRepostory.findById(id), RaceDetailResponse.class);    // read about this

        return response;
    }

    @Override
    public void uploadRaceCalender(MultipartFile raceCalenderFile) {
        try(InputStream is = raceCalenderFile.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);

            List<RaceDetail> races = new ArrayList<>();
            for(int i=1; i<= sheet.getLastRowNum(); i++) {              //i=1 to ship the header
                Row row = sheet.getRow(i);
                if(row == null) continue;

                RaceDetail race = new RaceDetail();
                race.setRaceNumber((int) row.getCell(0).getNumericCellValue());
                race.setRaceName(row.getCell(1).getStringCellValue());
                String dateSrt = row.getCell(2).getStringCellValue();
                LocalDate localDate = LocalDate.parse(dateSrt);
                race.setDate(Date.valueOf(localDate));
                race.setCountry(row.getCell(3).getStringCellValue());

                races.add(race);
            }

            raceRepostory.saveAll(races);
        } catch (Exception ex) {
            throw new RuntimeException("Could not add the race details",ex);
        }

    }

    @Override
    public RaceCalenderResponse getRaceCalenderByYear(Year year) {
        List<RaceDetail> raceCalender = raceRepostory.findRaceCalenderByYear(year);


        List<RaceDetailResponse> raceCalenderDtoList = new ArrayList<>();

        raceCalenderDtoList = raceCalender.parallelStream()
                .map(i -> modelMapper.map(i, RaceDetailResponse.class))
                .collect(Collectors.toList());

//        for(int i=0;i<raceCalender.size();i++) {
//            raceCalenderDtoList.add(modelMapper.map(raceCalender.get(i), RaceDetailResponse.class));
//
//        }

        RaceCalenderResponse raceCalenderResponse = new RaceCalenderResponse(year,raceCalenderDtoList);

        return raceCalenderResponse;
    }

}
