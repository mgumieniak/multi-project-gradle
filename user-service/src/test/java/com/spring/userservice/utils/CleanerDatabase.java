package com.spring.userservice.utils;

import com.spring.userservice.repository.AccountRepository;
import com.spring.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CleanerDatabase {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public CleanerDatabase(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public void cleanDB() {
        accountRepository.deleteAll();
        userRepository.deleteAll();
    }
}
