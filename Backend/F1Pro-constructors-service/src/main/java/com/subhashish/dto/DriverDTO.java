package com.subhashish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {

    private Integer Id;
    private Integer number;
    private String name;
    private String country;
    private Date dob;
    private String constructorId;
    private String constructorName;
}
