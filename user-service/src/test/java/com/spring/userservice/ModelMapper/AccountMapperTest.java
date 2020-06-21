package com.spring.userservice.ModelMapper;

import com.spring.userservice.model.dto.AccountDto;
import com.spring.userservice.model.dto.UserDto;
import com.spring.userservice.model.entity.Account;
import com.spring.userservice.model.entity.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class AccountMapperTest {

    AccountMapper mapper = Mappers.getMapper(AccountMapper.class);

    @Test
    void mapToAccountDto() {
        UserDto userDto = UserDto.builder()
                .email("maciej@gmail")
                .build();
        AccountDto accountDto = AccountDto.builder()
                .username("admin_user")
                .password("admin_password")
                .userDto(userDto)
                .build();

        Account account = mapper.mapToAccount(accountDto);

        assertThat(account).isNotNull();
        assertThat(account.getUser()).isNotNull();
        assertThat(account.getUser().getEmail()).isEqualTo("maciej@gmail");
        assertThat(account.getUsername()).isEqualTo("admin_user");
        assertThat(account.getPassword()).isEqualTo("admin_password");
    }

    @Test
    void mapToAccount() {
        Account account = new Account();
        account.setUsername("maciej");
        account.setPassword("admin");
        account.setUser(new User("maciej@gmail"));

        AccountDto accountDto = mapper.mapToAccountDto(account);

        assertThat(accountDto).isNotNull();
        assertThat(accountDto.getUsername()).isEqualTo("maciej");
        assertThat(accountDto.getPassword()).isEqualTo("admin");
        assertThat(accountDto.getUserDto()).isNotNull();
        assertThat(accountDto.getUserDto().getEmail()).isEqualTo("maciej@gmail");
    }
}
