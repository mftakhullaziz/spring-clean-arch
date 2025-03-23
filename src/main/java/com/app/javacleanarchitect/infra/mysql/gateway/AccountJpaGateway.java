package com.app.javacleanarchitect.infra.mysql.gateway;

import com.app.javacleanarchitect.infra.mysql.persistence.AccountPersistence;

public interface AccountJpaGateway {
    boolean findUsernameIsExist(String username);
    boolean findEmailIsExist(String email);
    void saveToAccountPersistence(AccountPersistence accountPersistence);
}
