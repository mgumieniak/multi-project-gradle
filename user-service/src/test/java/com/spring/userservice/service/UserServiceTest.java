package com.spring.userservice.service;

import com.database.users.model.dto.UserDto;
import com.database.users.model.entity.User;
import com.database.users.repository.UserRepository;
import com.database.users.utils.CleanerDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CleanerDatabase cleanerDatabase;

    @BeforeEach
    void setUp() {
        cleanerDatabase.cleanDB();
    }

    private UserDto createUser(String email) {
        return UserDto.builder()
                .email(email)
                .build();
    }

    @Nested
    class create_user {
        @Test
        void shouldSaveGivenUserWithCreationDate() {
            UserDto userDto = createUser("maciej@gmail");

            long createdUserId = userService.save(userDto);

            Optional<User> createdUser = userRepository.findById(createdUserId);
            assertThat(createdUser).isPresent();
            assertThat(createdUser.get().getCreationDate())
                    .isCloseTo(Instant.now(), within(1, ChronoUnit.SECONDS));
        }

        @ParameterizedTest(name = ": {0}.")
        @NullSource
        @ValueSource(strings = { "", "  " })
        public void shouldThrowExceptionWhenEmailIsEqual(String invalidEmail) {
            UserDto userDto = createUser(invalidEmail);

            assertThatThrownBy(()->userService.save(userDto))
                    .isInstanceOf(ConstraintViolationException.class);
        }
    }
}
