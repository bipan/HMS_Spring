package com.Hospital.Management.System.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String name;

    private String age;

    @Column(name = "blood_group")
    private String blood;

    private String prescription;

    private String dose;

    private String fees;

    private String urgency;
}
