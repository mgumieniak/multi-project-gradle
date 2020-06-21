package com.spring.userservice.service;

import com.spring.userservice.ModelMapper.AccountMapper;
import com.spring.userservice.model.dto.AccountDto;
import com.spring.userservice.model.entity.Account;
import com.spring.userservice.repository.AccountRepository;
import library.common.exception.NotFoundException;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Getter
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Transactional
    @Override
    public long save(AccountDto accountToCreate) {
        Account accountToSave = accountMapper.mapToAccount(accountToCreate);
        accountRepository.save(accountToSave);
        return accountToSave.getId();
    }

    @Override
    public Optional<AccountDto> findEagerLoadedById(Long id) {
        Optional<Account> account = accountRepository.findEagerLoadedById(id);
        AccountDto accountDto = accountMapper.mapToAccountDto(account
                .orElseThrow(()-> new NotFoundException("Account cannot be found!")));
        return Optional.ofNullable(accountDto);
    }
}
