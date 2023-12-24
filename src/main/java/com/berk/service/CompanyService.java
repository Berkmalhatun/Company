package com.berk.service;

import com.berk.dto.request.CreateCompanyRequestDto;
import com.berk.dto.request.UpdateCompanyRequestDto;
import com.berk.mapper.ICompanyMapper;
import com.berk.repository.ICompanyRepository;
import com.berk.repository.entity.Company;
import com.berk.repository.enums.EStatus;
import com.berk.utility.ServiceManager;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CompanyService extends ServiceManager<Company,Long> {
    private final ICompanyRepository companyRepository;




    public CompanyService(ICompanyRepository companyRepository) {
        super(companyRepository);
        this.companyRepository = companyRepository;
    }

    /**
     * Firma oluşturmak için kullanılan metoddur. Eğer aynı isimde firma var ise hata fırlatır.
     */
    public Company create(CreateCompanyRequestDto dto) {
        Optional<Company> existCompany = companyRepository.findByName(dto.getName());
            if (existCompany.isPresent())
                throw new IllegalStateException(dto.getName()+" is used.");
            Company company = ICompanyMapper.INSTANCE.toCompany(dto);
            save(company);
            return company;
    }

    /**
     * Firma silmek için kullanılan bir metoddur. Eğer girilen id ye göre firma bulunmaz veya firma daha önce silinmiş
     * ise metod hata fırlatır.
     */
    public Company deleteCompany(Long id) {
        Optional<Company> existCompany = companyRepository.findById(id);
        if (existCompany.isEmpty() || existCompany.get().getStatus().equals(EStatus.DELETED))
            throw new EntityNotFoundException("Company information not found.");
        existCompany.get().setStatus(EStatus.DELETED);
        update(existCompany.get());
        return existCompany.get();
    }

    /**
     * Fİrma güncellemek için kullanılan metoddur. Eğer dto da girilen id değeri ile kayıtlı bir firma yoksa veya
     * firma silinmiş ise metod hata fırlatır.
     * @param dto
     * @return
     */
    public Company updateCompany(UpdateCompanyRequestDto dto) {
        Optional<Company> existCompany = companyRepository.findById(dto.getId());
        if (existCompany.isEmpty() || existCompany.get().getStatus().equals(EStatus.DELETED))
            throw new EntityNotFoundException("Company information not found.");
    Company updatedCompany = ICompanyMapper.INSTANCE.toUpdatedCompany(dto);
    updatedCompany.setId(existCompany.get().getId());
    updatedCompany.setCreateDate(existCompany.get().getCreateDate());
    update(updatedCompany);
    return updatedCompany;
    }
}
