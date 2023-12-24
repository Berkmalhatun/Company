package com.berk.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyRequestDto {
    private String name;
    private String city;
    private String district;
    private String phoneNumber;
    private String website;
}
