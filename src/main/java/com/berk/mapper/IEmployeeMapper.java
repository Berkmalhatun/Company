package com.berk.mapper;


import com.berk.dto.request.RegisterEmployeeRequestDto;
import com.berk.dto.request.UpdateEmployeeRequestDto;
import com.berk.repository.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IEmployeeMapper {
    IEmployeeMapper INSTANCE= Mappers.getMapper(IEmployeeMapper.class);

    Employee toEmployee(final RegisterEmployeeRequestDto dto);
    Employee toUpdatedEmployee(final UpdateEmployeeRequestDto dto);
}
