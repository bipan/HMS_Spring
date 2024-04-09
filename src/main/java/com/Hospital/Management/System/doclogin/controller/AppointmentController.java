package com.Hospital.Management.System.doclogin.controller;

import com.Hospital.Management.System.doclogin.entity.Appointment;
import com.Hospital.Management.System.doclogin.repository.AppointmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")

public class AppointmentController {

    private final AppointmentsRepository appointmentsRepository;

    @PostMapping("/insert")
    public Appointment createAppointment(@RequestBody Appointment appointment){
        return appointmentsRepository.save(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments(){
        return appointmentsRepository.findAll();
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Map<String, Boolean>>deleteAppointment(@PathVariable long id) throws AttributeNotFoundException{
        Appointment appointment = appointmentsRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Appointment found with id "+id));
        appointmentsRepository.delete(appointment);
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
