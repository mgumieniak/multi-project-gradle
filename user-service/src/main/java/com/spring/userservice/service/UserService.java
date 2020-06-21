package com.spring.userservice.service;


import com.spring.userservice.model.dto.UserDto;

public interface UserService {
    long save(UserDto user);
}
