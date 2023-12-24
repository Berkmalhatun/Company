package com.berk.controller;

import com.berk.dto.request.CreateCompanyRequestDto;
import com.berk.dto.request.RegisterEmployeeRequestDto;
import com.berk.dto.request.UpdateCompanyRequestDto;
import com.berk.dto.request.UpdateEmployeeRequestDto;
import com.berk.repository.entity.Company;
import com.berk.repository.entity.Employee;
import com.berk.service.CompanyService;
import com.berk.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.berk.constants.EndPoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(EMPLOYEE)
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(CREATE)
    public ResponseEntity<Employee> registerEmployee(@RequestBody RegisterEmployeeRequestDto dto){
        return ResponseEntity.ok(employeeService.registerEmployee(dto));
    }
    @PutMapping(UPDATE)
    public ResponseEntity<Employee> updateEmployee(@RequestBody UpdateEmployeeRequestDto dto){
        return ResponseEntity.ok(employeeService.updateEmployee(dto));
    }
    @DeleteMapping(DELETE)
    public ResponseEntity<Employee> deleteEmployee(Long id){
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }
}

