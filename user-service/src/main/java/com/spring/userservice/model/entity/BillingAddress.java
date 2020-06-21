package com.spring.userservice.model.entity;

import library.common.model.Country;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "billing_address")
public class BillingAddress {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @NotBlank
    @Column(length = 50)
    private String street;

    @NotBlank
    @Column(length = 10)
    private String homeNumber;

    @NotBlank
    @Column(length = 5)
    private String zipCode;

    @NotBlank
    @Column(length = 50)
    private String city;

    @NotNull
    @Column(length = 50)
    private Country country;

    @Column(length = 9)
    private String phoneNumber;

    @Column(length = 10)
    private String nip;
}
