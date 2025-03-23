package com.app.javacleanarchitect.core.usecase.account;

import com.app.javacleanarchitect.domain.account.AccountResponse;

public interface OAccountBoundary {
    void presenter(AccountResponse accountResponse);
}
