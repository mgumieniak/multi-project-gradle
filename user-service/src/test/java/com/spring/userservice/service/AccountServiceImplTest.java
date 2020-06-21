package com.spring.userservice.service;

import com.spring.userservice.model.dto.AccountDto;
import com.spring.userservice.model.dto.UserDto;
import com.spring.userservice.model.entity.Account;
import com.spring.userservice.repository.AccountRepository;
import com.spring.userservice.utils.CleanerDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AccountServiceImplTest {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CleanerDatabase cleanerDatabase;

    @BeforeEach
    void setUp() {
        cleanerDatabase.cleanDB();
    }

    @Test
    void save() {
        AccountDto accountToCreate = createAccountWithUser("maciej@gmail", "admin_user", "admin_password");

        long createdAccountId = accountService.save(accountToCreate);

        Optional<Account> createdAccount = accountRepository.findById(createdAccountId);
        assertThat(createdAccount).isPresent();
        assertThat(createdAccount.get().getUsername()).isEqualTo("admin_user");
        assertThat(createdAccount.get().getPassword()).isEqualTo("admin_password");
    }

    private AccountDto createAccountWithUser(String email, String username, String password) {
        UserDto userDto = UserDto.builder()
                .email(email)
                .build();
        return AccountDto.builder()
                .username(username)
                .password(password)
                .userDto(userDto)
                .build();
    }

    @Test
    void shouldFindAccountWithEagerLoadUser() {
        AccountDto accountToCreate = createAccountWithUser("pawel@gmail", "user", "password");
        long createdAccountId = accountService.save(accountToCreate);

        Optional<AccountDto> createdAccount = accountService.findEagerLoadedById(createdAccountId);

        assertThat(createdAccount).isPresent();
        assertThat(createdAccount.get().getUserDto()).isNotNull();
        assertThat(createdAccount.get().getUserDto().getEmail()).isEqualTo("pawel@gmail");
    }
}