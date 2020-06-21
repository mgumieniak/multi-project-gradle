package com.spring.userservice.service;

import com.spring.userservice.ModelMapper.AddressMapper;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class BillingAddressServiceImpl implements BillingAddressService {
    private final AddressMapper addressMapper;

    public BillingAddressServiceImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }
}
