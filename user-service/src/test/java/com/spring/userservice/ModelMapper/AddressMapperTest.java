package com.spring.userservice.ModelMapper;

import com.spring.userservice.model.dto.AddressDto;
import com.spring.userservice.model.entity.BillingAddress;
import com.spring.userservice.model.entity.DeliverAddress;
import library.common.model.Country;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class AddressMapperTest {

    AddressMapper mapper = Mappers.getMapper(AddressMapper.class);

    @Test
    void shouldMapAddressDtoToBillingAddress() {
        AddressDto addressDto = AddressDto.builder()
                .city("Krakow")
                .country(Country.POLAND)
                .homeNumber("102")
                .nip("999333111")
                .phoneNumber("000000001")
                .street("Wielkopolska")
                .zipCode("31456")
                .build();

        BillingAddress billingAddress = mapper.mapToBillingAddress(addressDto);

        assertThat(billingAddress).isNotNull();
        assertThat(billingAddress.getCity()).isEqualTo("Krakow");
        assertThat(billingAddress.getCountry()).isEqualTo(Country.POLAND);
        assertThat(billingAddress.getHomeNumber()).isEqualTo("102");
        assertThat(billingAddress.getNip()).isEqualTo("999333111");
        assertThat(billingAddress.getPhoneNumber()).isEqualTo("000000001");
        assertThat(billingAddress.getStreet()).isEqualTo("Wielkopolska");
        assertThat(billingAddress.getZipCode()).isEqualTo("31456");
    }

    @Test
    void shouldMapBillingAddressToAddressDto() {
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setCity("Krakow");
        billingAddress.setCountry(Country.POLAND);
        billingAddress.setHomeNumber("102");
        billingAddress.setNip("999333111");
        billingAddress.setPhoneNumber("000000001");
        billingAddress.setStreet("Wielkopolska");
        billingAddress.setZipCode("31456");

        AddressDto addressDto = mapper.mapToAddressDto(billingAddress);

        assertThat(addressDto).isNotNull();
        assertThat(addressDto.getCity()).isEqualTo("Krakow");
        assertThat(addressDto.getCountry()).isEqualTo(Country.POLAND);
        assertThat(addressDto.getHomeNumber()).isEqualTo("102");
        assertThat(addressDto.getNip()).isEqualTo("999333111");
        assertThat(addressDto.getPhoneNumber()).isEqualTo("000000001");
        assertThat(addressDto.getStreet()).isEqualTo("Wielkopolska");
        assertThat(addressDto.getZipCode()).isEqualTo("31456");
    }

    @Test
    void shouldMapAddressDtoToDeliverAddress() {

        AddressDto addressDto = AddressDto.builder()
                .city("Krakow")
                .country(Country.POLAND)
                .homeNumber("102")
                .nip("999333111")
                .phoneNumber("000000001")
                .street("Wielkopolska")
                .zipCode("31456")
                .build();

        DeliverAddress deliverAddress = mapper.mapToDeliverAddress(addressDto);

        assertThat(deliverAddress).isNotNull();
        assertThat(deliverAddress.getCity()).isEqualTo("Krakow");
        assertThat(deliverAddress.getCountry()).isEqualTo(Country.POLAND);
        assertThat(deliverAddress.getHomeNumber()).isEqualTo("102");
        assertThat(deliverAddress.getNip()).isEqualTo("999333111");
        assertThat(deliverAddress.getPhoneNumber()).isEqualTo("000000001");
        assertThat(deliverAddress.getStreet()).isEqualTo("Wielkopolska");
        assertThat(deliverAddress.getZipCode()).isEqualTo("31456");
    }

    @Test
    void shouldMapDeliverAddressToAddressDto() {
        DeliverAddress deliverAddress = new DeliverAddress();
        deliverAddress.setCity("Krakow");
        deliverAddress.setCountry(Country.POLAND);
        deliverAddress.setHomeNumber("102");
        deliverAddress.setNip("999333111");
        deliverAddress.setPhoneNumber("000000001");
        deliverAddress.setStreet("Wielkopolska");
        deliverAddress.setZipCode("31456");

        AddressDto addressDto = mapper.mapToAddressDto(deliverAddress);

        assertThat(addressDto).isNotNull();
        assertThat(addressDto.getCity()).isEqualTo("Krakow");
        assertThat(addressDto.getCountry()).isEqualTo(Country.POLAND);
        assertThat(addressDto.getHomeNumber()).isEqualTo("102");
        assertThat(addressDto.getNip()).isEqualTo("999333111");
        assertThat(addressDto.getPhoneNumber()).isEqualTo("000000001");
        assertThat(addressDto.getStreet()).isEqualTo("Wielkopolska");
        assertThat(addressDto.getZipCode()).isEqualTo("31456");
    }
}
