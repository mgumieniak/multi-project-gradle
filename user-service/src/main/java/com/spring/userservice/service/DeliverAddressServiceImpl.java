package com.spring.userservice.service;

import com.spring.userservice.ModelMapper.AddressMapper;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class DeliverAddressServiceImpl implements DeliverAddressService {
    private final AddressMapper addressMapper;

    public DeliverAddressServiceImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }
}
