package com.berk.repository.entity;

import com.berk.repository.enums.EGender;
import com.berk.repository.enums.EStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "employeeDb")
public class Employee extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long companyid;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private EGender gender;
    private Double salary;
    private Integer age;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status=EStatus.ACTIVE;
}
