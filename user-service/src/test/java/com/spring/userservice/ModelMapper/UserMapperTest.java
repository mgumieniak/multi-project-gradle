package com.spring.userservice.ModelMapper;

import com.spring.userservice.model.dto.UserDto;
import com.spring.userservice.model.entity.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class UserMapperTest {

    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Test
    void shouldMapUserDtoToUser() {
        UserDto userDto = UserDto.builder()
                .email("maciej@gmail")
                .build();

        User user = mapper.mapToUser(userDto);

        assertThat(user).isNotNull();
        assertThat(user.getEmail()).isEqualTo("maciej@gmail");
    }

    @Test
    void shouldMapUserToUserDto() {
        User user = new User("maciej@gmail");

        UserDto userDto = mapper.mapToUserDto(user);

        assertThat(userDto).isNotNull();
        assertThat(userDto.getEmail()).isEqualTo("maciej@gmail");
    }
}