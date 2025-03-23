package com.app.javacleanarchitect.core.usecase.account;

import com.app.javacleanarchitect.app.annotation.Usecase;
import com.app.javacleanarchitect.core.entities.account.AccountEntities;
import com.app.javacleanarchitect.core.entities.email.EmailEntities;
import com.app.javacleanarchitect.domain.account.AccountDto;
import com.app.javacleanarchitect.domain.account.AccountRequest;

@Usecase
public class AccountUsecase implements IAccountBoundary {

    private final AccountEntities accountEntities;
    private final EmailEntities emailEntities;

    public AccountUsecase(AccountEntities accountEntities, EmailEntities emailEntities) {
        this.accountEntities = accountEntities;
        this.emailEntities = emailEntities;
    }

    @Override
    public void createAccount(AccountRequest request, OAccountBoundary oAccountBoundary) {
        accountEntities.RegisterAccountEntities(new AccountDto());

        // when register success sender email activation to user by email id
        emailEntities.sendEmailActivation(request.getEmail());
    }
}
