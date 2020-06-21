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
@Table(name = "deliver_address")
public class DeliverAddress {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String street;

    @NotBlank
    @Column(nullable = false, length = 10)
    private String homeNumber;

    @NotBlank
    @Column(nullable = false, length = 5)
    private String zipCode;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String city;

    @NotNull
    @Column(nullable = false)
    private Country country;

    private String phoneNumber;

    private String nip;
}
