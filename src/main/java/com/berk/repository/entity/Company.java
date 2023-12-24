package com.berk.repository.entity;

import com.berk.repository.enums.EStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "companyDb")
public class Company extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String district;
    private String phoneNumber;
    private String website;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status=EStatus.ACTIVE;
}
