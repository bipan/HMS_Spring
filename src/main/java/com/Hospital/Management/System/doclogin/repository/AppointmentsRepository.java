package com.Hospital.Management.System.doclogin.repository;

import com.Hospital.Management.System.doclogin.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment, Long> {
}
