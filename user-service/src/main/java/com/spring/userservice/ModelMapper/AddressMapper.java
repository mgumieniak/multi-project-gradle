package com.spring.userservice.ModelMapper;

import com.spring.userservice.model.dto.AddressDto;
import com.spring.userservice.model.entity.BillingAddress;
import com.spring.userservice.model.entity.DeliverAddress;
import com.spring.userservice.service.BillingAddressServiceImpl;
import com.spring.userservice.service.DeliverAddressServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {DeliverAddressServiceImpl.class, BillingAddressServiceImpl.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    BillingAddress mapToBillingAddress(AddressDto addressDto);
    AddressDto mapToAddressDto(BillingAddress billingAddress);

    DeliverAddress mapToDeliverAddress(AddressDto addressDto);
    AddressDto mapToAddressDto(DeliverAddress deliverAddress);
}
