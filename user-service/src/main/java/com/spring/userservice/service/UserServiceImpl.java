package com.spring.userservice.service;

import com.spring.userservice.ModelMapper.UserMapper;
import com.spring.userservice.model.dto.UserDto;
import com.spring.userservice.model.entity.User;
import com.spring.userservice.repository.UserRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Getter
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public long save(UserDto userDto) {
//        User user = userMapper.mapToUser(userDto);
        User user = new User();
        userRepository.save(user);
        return user.getId();
    }
}
