package com.example.projecttraining.service.account;

import com.example.projecttraining.model.Account;

public interface IAccountService {
    Account findByAccountName(String accountName);
}
