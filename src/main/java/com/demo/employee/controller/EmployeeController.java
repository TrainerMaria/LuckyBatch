package com.demo.employee.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/{id}")
    public Map<String, Object> getEmployee(@PathVariable Long id) {

        // Use empId=99 to simulate a failure (to trigger Circuit Breaker in payroll-service)
        if (id == 99) {
            throw new RuntimeException("Simulated: employee-service is DOWN for empId=99");
        }

        return Map.of(
                "id", id,
                "name", "Maria Ashvini",
                "department", "IT"	
        );
    }
}
