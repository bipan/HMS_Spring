package com.Hospital.Management.System.controller;

import com.Hospital.Management.System.doclogin.entity.Appointment;
import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    private final PatientRepository patientRepository;

    @PostMapping("/insert")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping
    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable long id) throws AttributeNotFoundException {
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient couldn't be found with id "+id));
        patientRepository.delete(patient);
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


    @GetMapping("patients/{id}")
    public ResponseEntity<Patient> getPatiendById(@PathVariable long id) throws AttributeNotFoundException {
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient not found with id "+id));
        return ResponseEntity.ok(patient);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatientById(@PathVariable long id, @RequestBody Patient patientDetails) throws AttributeNotFoundException{
        Patient patientInfo = patientRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient couldn't be found with id "+id));
        patientInfo.setAge(patientDetails.getAge());
        patientInfo.setName(patientDetails.getName());
        patientInfo.setBlood(patientDetails.getBlood());
        patientInfo.setDose(patientDetails.getDose());
        patientInfo.setFees(patientDetails.getFees());
        patientInfo.setPrescription(patientDetails.getPrescription());
        patientInfo.setUrgency(patientDetails.getUrgency());

        Patient savedPatient = patientRepository.save(patientInfo);

        return ResponseEntity.ok(savedPatient);

    }
}
