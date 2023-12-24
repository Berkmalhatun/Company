package com.berk.mapper;

import com.berk.dto.request.CreateCompanyRequestDto;
import com.berk.dto.request.UpdateCompanyRequestDto;
import com.berk.repository.entity.Company;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-24T04:01:23+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (JetBrains s.r.o.)"
)
@Component
public class ICompanyMapperImpl implements ICompanyMapper {

    @Override
    public Company toCompany(CreateCompanyRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Company.CompanyBuilder<?, ?> company = Company.builder();

        company.name( dto.getName() );
        company.city( dto.getCity() );
        company.district( dto.getDistrict() );
        company.phoneNumber( dto.getPhoneNumber() );
        company.website( dto.getWebsite() );

        return company.build();
    }

    @Override
    public Company toUpdatedCompany(UpdateCompanyRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Company.CompanyBuilder<?, ?> company = Company.builder();

        company.id( dto.getId() );
        company.name( dto.getName() );
        company.city( dto.getCity() );
        company.district( dto.getDistrict() );
        company.phoneNumber( dto.getPhoneNumber() );
        company.website( dto.getWebsite() );

        return company.build();
    }
}
