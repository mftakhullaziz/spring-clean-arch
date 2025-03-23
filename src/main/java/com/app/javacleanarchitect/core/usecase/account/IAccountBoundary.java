package com.app.javacleanarchitect.core.usecase.account;

import com.app.javacleanarchitect.domain.account.AccountRequest;

public interface IAccountBoundary {
    void createAccount(AccountRequest request, OAccountBoundary oAccountBoundary);
}
