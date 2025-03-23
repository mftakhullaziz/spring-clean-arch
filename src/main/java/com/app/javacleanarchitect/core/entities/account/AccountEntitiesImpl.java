package com.app.javacleanarchitect.core.entities.account;

import com.app.javacleanarchitect.app.annotation.EntitiesBusiness;
import com.app.javacleanarchitect.domain.account.AccountDto;
import com.app.javacleanarchitect.infra.mysql.gateway.AccountJpaGateway;
import com.app.javacleanarchitect.infra.mysql.persistence.AccountPersistence;
import lombok.extern.log4j.Log4j2;

@Log4j2
@EntitiesBusiness
public class AccountEntitiesImpl implements AccountEntities {

    private final AccountJpaGateway accountJPAGateway;

    public AccountEntitiesImpl(AccountJpaGateway accountJPAGateway) {
        this.accountJPAGateway = accountJPAGateway;
    }

    @Override
    public void RegisterAccountEntities(AccountDto accountDto) {
        if (accountDto != null) {
            // validate email and username is unique
            boolean emailExist = accountJPAGateway.findEmailIsExist(accountDto.getEmail());
            boolean usernameIsExist = accountJPAGateway.findUsernameIsExist(accountDto.getUsername());
            if (!emailExist || !usernameIsExist) {
                log.info("Account with email {} and username {} already exists", accountDto.getEmail(), accountDto.getUsername());
            }
            AccountPersistence accountPersistence = AccountPersistence.builder()
                .email(accountDto.getEmail())
                .username(accountDto.getUsername())
                .password(accountDto.getPassword())
                .build();
            accountJPAGateway.saveToAccountPersistence(accountPersistence);
        }
    }
}
