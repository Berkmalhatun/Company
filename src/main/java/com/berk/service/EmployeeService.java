package com.berk.service;

import com.berk.dto.request.RegisterEmployeeRequestDto;
import com.berk.dto.request.UpdateEmployeeRequestDto;
import com.berk.mapper.IEmployeeMapper;
import com.berk.repository.ICompanyRepository;
import com.berk.repository.IEmployeeRepository;
import com.berk.repository.entity.Company;
import com.berk.repository.entity.Employee;
import com.berk.repository.enums.EStatus;
import com.berk.utility.ServiceManager;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class EmployeeService extends ServiceManager<Employee,Long> {
    private final IEmployeeRepository employeeRepository;
    private final ICompanyRepository companyRepository;


    public EmployeeService(IEmployeeRepository employeeRepository, ICompanyRepository companyRepository) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    /**
     * Çalışan kayıt etmek için yazılmış metoddur. Eğer çalışanı kaydettiğimiz firma id'sine kayıtlı bir firma yoksa
     * çalışan kayıt edilemez.
     * @param dto
     * @return
     */
    public Employee registerEmployee(RegisterEmployeeRequestDto dto) {
        Optional<Company> company = companyRepository.findById(dto.getCompanyid());
        if (company.isEmpty())
            throw new EntityNotFoundException("Company information not found.");
        Employee employee = IEmployeeMapper.INSTANCE.toEmployee(dto);
        save(employee);
        return employee;
    }

    /**
     * Çalışan silmek için kullanılan bir metoddur. Eğer silinmesi istenen id'ye sahip çalışan bulunamaz ise ya da
     * daha önce silinmiş bir çalışan ise silme işlemi yapılamaz.Eğer tam tersi ise silme işlemi EStatus enumu deleted
     * konumuna getirelerek yapılır.
     */
    public Employee deleteEmployee(Long id) {
        Optional<Employee> existEmployee = employeeRepository.findById(id);
        if (existEmployee.isEmpty() || existEmployee.get().getStatus().equals(EStatus.DELETED))
            throw new EntityNotFoundException("Employee information not found.");
        existEmployee.get().setStatus(EStatus.DELETED);
        update(existEmployee.get());
        return existEmployee.get();

    }

    /**
     * Çalışan güncellemek için kullanılan metoddur. Eğer dtodan girilen id değeri ile kayıtlı bir çalışan yok ise veya
     * çalışan daha once silinmiş ise güncelleme işlemi yapılmaz. Eğer çalışanın güncellenmek istenen firma id sine göre
     * bir firma bulunamaz veya girilen id deki firma silinmiş ise guncelleme işlemi yapılmaz.
     * @param dto
     * @return
     */
    public Employee updateEmployee(UpdateEmployeeRequestDto dto) {
        Optional<Employee> existEmployee = employeeRepository.findById(dto.getId());
        Optional<Company> existCompany = companyRepository.findById(dto.getCompanyid());
        if (existEmployee.isEmpty() || existEmployee.get().getStatus().equals(EStatus.DELETED))
            throw new EntityNotFoundException("Employee information not found.");
        if (existCompany.isEmpty() || existCompany.get().getStatus().equals(EStatus.DELETED))
            throw new EntityNotFoundException("Company information not found.");
        Employee updatedEmployee = IEmployeeMapper.INSTANCE.toUpdatedEmployee(dto);
        updatedEmployee.setId(existEmployee.get().getId());
        updatedEmployee.setCreateDate(existEmployee.get().getCreateDate());
        update(updatedEmployee);
        return updatedEmployee;

    }
}
