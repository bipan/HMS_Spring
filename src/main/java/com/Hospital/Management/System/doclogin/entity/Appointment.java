package com.Hospital.Management.System.doclogin.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String age;

    private String symptoms;

    private String number;

}
