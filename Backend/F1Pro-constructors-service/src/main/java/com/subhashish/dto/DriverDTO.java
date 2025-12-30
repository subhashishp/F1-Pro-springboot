package com.subhashish.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class DriverDTO {

    @Null(message = "Id must not be provided. It will be auto-generated")
    private Integer Id;
    @Positive(message = "Driver number must be positive if provided")
    private Integer number;
    @NotBlank(message = "Driver name is mandatory")
    @Size(min = 2, message = "Please provide the full name of the driver")
    private String name;
    @NotBlank(message = "Driver's country is mandatory")
    private String country;
    @Past(message = "Date of birth must be in the past")
    private Date dob;
    private String constructorId;
    private String constructorName;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(String constructorId) {
        this.constructorId = constructorId;
    }

    public String getConstructorName() {
        return constructorName;
    }

    public void setConstructorName(String constructorName) {
        this.constructorName = constructorName;
    }
}
