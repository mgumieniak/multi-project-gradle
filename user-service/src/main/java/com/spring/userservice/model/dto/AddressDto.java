package com.spring.userservice.model.dto;

import library.common.model.Country;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Builder
@Value
public class AddressDto {
    @NotBlank String street;
    @NotBlank String homeNumber;
    @NotBlank String zipCode;
    @NotBlank String city;
    @NotNull Country country;
    String phoneNumber;
    String nip;
}


