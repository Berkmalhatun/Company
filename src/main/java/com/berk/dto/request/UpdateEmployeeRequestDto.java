package com.berk.dto.request;

import com.berk.repository.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequestDto {
    private Long id;
    private Long companyid;
    private String name;
    private String surname;
    private EGender gender;
    private Double salary;
    private Integer age;
}
