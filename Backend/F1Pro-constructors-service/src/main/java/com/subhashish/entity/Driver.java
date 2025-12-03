package com.subhashish.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "drivers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id", nullable = false)
    private Integer id;

    @Column(name = "driver_number")
    private Integer number;

    @Column(name = "driver_name" , nullable = false)
    private String name;

    @Column(name = "driver_country")
    private String country;

    @Column(name = "driver_dob")
    private Date dob;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "constructor_id", referencedColumnName = "constructor_id")
    @JsonIgnore
    private Constructors constructor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Constructors getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructors constructor) {
        this.constructor = constructor;
    }

}
