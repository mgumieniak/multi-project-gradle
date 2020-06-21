package com.spring.userservice.repository;

import com.spring.userservice.model.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
    @Query("select a\n" +
           "from Account a\n" +
           "join fetch a.user\n" +
           "where a.id = ?1\n")
    Optional<Account> findEagerLoadedById(Long id);
}
