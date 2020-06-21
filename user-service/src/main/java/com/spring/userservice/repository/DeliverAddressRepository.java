package com.spring.userservice.repository;

import com.spring.userservice.model.entity.DeliverAddress;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DeliverAddressRepository extends PagingAndSortingRepository<DeliverAddress, Long> {
}
