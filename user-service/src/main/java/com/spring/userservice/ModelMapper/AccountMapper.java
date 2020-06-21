package com.spring.userservice.ModelMapper;

import com.spring.userservice.model.dto.AccountDto;
import com.spring.userservice.model.entity.Account;
import com.spring.userservice.service.AccountServiceImpl;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        uses = {AccountServiceImpl.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {
    @Mapping(source = "userDto", target = "user")
    Account mapToAccount(AccountDto accountDto);

    @InheritInverseConfiguration(name = "mapToAccount")
    AccountDto mapToAccountDto(Account account);
}
