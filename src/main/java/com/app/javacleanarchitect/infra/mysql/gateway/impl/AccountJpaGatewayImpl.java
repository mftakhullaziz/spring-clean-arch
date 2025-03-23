package com.app.javacleanarchitect.infra.mysql.gateway.impl;

import com.app.javacleanarchitect.app.annotation.Gateway;
import com.app.javacleanarchitect.infra.mysql.gateway.AccountJpaGateway;
import com.app.javacleanarchitect.infra.mysql.persistence.AccountPersistence;
import com.app.javacleanarchitect.infra.mysql.repository.AccountRepository;

@Gateway
public class AccountJpaGatewayImpl implements AccountJpaGateway {

    private final AccountRepository accountRepository;

    public AccountJpaGatewayImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean findUsernameIsExist(String username) {
        return accountRepository.existsByUsername(username);
    }

    @Override
    public boolean findEmailIsExist(String email) {
        return accountRepository.existsByEmail(email);
    }

    @Override
    public void saveToAccountPersistence(AccountPersistence accountPersistence) {
        accountRepository.save(accountPersistence);
    }

}
