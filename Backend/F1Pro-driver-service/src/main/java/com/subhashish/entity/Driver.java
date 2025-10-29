package com.subhashish.entity;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToOne
    @JoinColumn(name = "constructor_id", referencedColumnName = "constructor_id")
    private Integer constructor;
}
