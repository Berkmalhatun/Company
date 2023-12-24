package com.berk.controller;

import static com.berk.constants.EndPoints.*;

import com.berk.dto.request.CreateCompanyRequestDto;
import com.berk.dto.request.UpdateCompanyRequestDto;
import com.berk.repository.entity.Company;
import com.berk.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(COMPANY)
public class CompanyController {

    private final CompanyService companyService;


    @PostMapping(CREATE)
    public ResponseEntity<Company> createCompany(@RequestBody CreateCompanyRequestDto dto){
        return ResponseEntity.ok(companyService.create(dto));

    }
    @PutMapping(UPDATE)
    public ResponseEntity<Company> updateCompany(@RequestBody UpdateCompanyRequestDto dto){
        return ResponseEntity.ok(companyService.updateCompany(dto));
    }

    @DeleteMapping(DELETE)
    public ResponseEntity<Company> deleteCompany(Long id){
        return ResponseEntity.ok(companyService.deleteCompany(id));
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Company>> getAll(){
       return ResponseEntity.ok(companyService.findAll());
    }
}
