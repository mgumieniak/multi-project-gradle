package com.spring.userservice.service;


import com.spring.userservice.model.dto.AccountDto;

import java.util.Optional;

public interface AccountService {
    long save(AccountDto accountToCreate);
    Optional<AccountDto>  findEagerLoadedById(Long id);
}
