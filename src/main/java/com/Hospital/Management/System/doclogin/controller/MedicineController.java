package com.Hospital.Management.System.doclogin.controller;

import com.Hospital.Management.System.doclogin.entity.Medicine;
import com.Hospital.Management.System.doclogin.repository.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v3")
@RequiredArgsConstructor

public class MedicineController {

    private final MedicineRepository medicineRepository;

    @PostMapping("/insert")
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @GetMapping("/medicines")
    public List<Medicine> getAllMedicine(){
        return medicineRepository.findAll();
    }

    @GetMapping("/medicines/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable long id) throws AttributeNotFoundException {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine not found with id "+id));
        return ResponseEntity.ok(medicine);
    }

    @PutMapping("/medicines/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable long id, @RequestBody Medicine medicineDetails) throws AttributeNotFoundException {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine not found with id "+id));
        medicine.setDrugName(medicineDetails.getDrugName());
        medicine.setStock(medicineDetails.getStock());

        medicineRepository.save(medicine);

        return ResponseEntity.ok(medicine);
    }

    @DeleteMapping("medicines/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable long id) throws AttributeNotFoundException {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Not found"));
        medicineRepository.delete(medicine);

        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
