package com.spring.userservice.model.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Builder
@Value
public class UserDto {
    @NotEmpty String email;
}
