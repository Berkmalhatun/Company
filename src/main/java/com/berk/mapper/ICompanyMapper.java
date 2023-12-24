package com.berk.mapper;

import com.berk.dto.request.CreateCompanyRequestDto;
import com.berk.dto.request.UpdateCompanyRequestDto;
import com.berk.repository.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompanyMapper {
    ICompanyMapper INSTANCE= Mappers.getMapper(ICompanyMapper.class);

    Company toCompany(final CreateCompanyRequestDto dto);
    Company toUpdatedCompany(final UpdateCompanyRequestDto dto);
}
