package com.Hospital.Management.System.doclogin.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "drug_name")
    private String drugName;

    private String stock;
}
