package com.berk.dto.request;


import com.berk.repository.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterEmployeeRequestDto {
    private Long companyid;
    private String name;
    private String surname;
    private EGender gender;
    private Double salary;
    private Integer age;
}
