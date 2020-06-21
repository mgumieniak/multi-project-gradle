package com.spring.userservice.ModelMapper;

import com.spring.userservice.model.dto.UserDto;
import com.spring.userservice.model.entity.User;
import com.spring.userservice.service.UserServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {UserServiceImpl.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User mapToUser(UserDto userDto);

    UserDto mapToUserDto(User user);
}
