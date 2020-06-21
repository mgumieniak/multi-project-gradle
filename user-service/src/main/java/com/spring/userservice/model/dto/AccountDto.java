package com.spring.userservice.model.dto;

import library.common.model.Permissions;
import library.common.model.Roles;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Builder
@Value
public class AccountDto {
    long accountId;
    UserDto userDto;
    @NotBlank String username;
    @NotBlank String password;
    @Builder.Default
    @NotNull Permissions permissions = Permissions.STANDARD;
    @Builder.Default
    @NotNull Roles roles = Roles.USER;
    @Builder.Default
    boolean active = false;
    @Builder.Default
    boolean accountExpired = true;
    @Builder.Default
    boolean locked = true;
    @Builder.Default
    boolean credentialsExpired = true;
}
