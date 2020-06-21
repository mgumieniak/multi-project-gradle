package com.spring.userservice.repository;

import com.spring.userservice.model.entity.BillingAddress;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BillingAddressRepository extends PagingAndSortingRepository<BillingAddress, Long> {
}
