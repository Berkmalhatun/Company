package com.berk.mapper;

import com.berk.dto.request.RegisterEmployeeRequestDto;
import com.berk.dto.request.UpdateEmployeeRequestDto;
import com.berk.repository.entity.Employee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-24T04:18:45+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (JetBrains s.r.o.)"
)
@Component
public class IEmployeeMapperImpl implements IEmployeeMapper {

    @Override
    public Employee toEmployee(RegisterEmployeeRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Employee.EmployeeBuilder<?, ?> employee = Employee.builder();

        employee.companyid( dto.getCompanyid() );
        employee.name( dto.getName() );
        employee.surname( dto.getSurname() );
        employee.gender( dto.getGender() );
        employee.salary( dto.getSalary() );
        employee.age( dto.getAge() );

        return employee.build();
    }

    @Override
    public Employee toUpdatedEmployee(UpdateEmployeeRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Employee.EmployeeBuilder<?, ?> employee = Employee.builder();

        employee.id( dto.getId() );
        employee.companyid( dto.getCompanyid() );
        employee.name( dto.getName() );
        employee.surname( dto.getSurname() );
        employee.gender( dto.getGender() );
        employee.salary( dto.getSalary() );
        employee.age( dto.getAge() );

        return employee.build();
    }
}
