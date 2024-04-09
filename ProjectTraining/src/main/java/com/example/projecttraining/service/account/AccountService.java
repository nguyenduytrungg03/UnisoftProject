package com.example.projecttraining.service.account;

import com.example.projecttraining.mapper.AccountMapper;
import com.example.projecttraining.model.Account;
import com.example.projecttraining.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountMapper accountMapper;
    private IAccountService accountService;
    @Override
    public Account findByAccountName(String accountName) {
        Map<String, Object> map = accountMapper.findByAccountName(accountName);
        if (map == null) {
            return null;
        }
        return convertToModel(map);
    }
    private Account convertToModel(Map<String, Object> map) {
        Account account = new Account();
        Role role = new Role();
        account.setAccountId((Integer) map.get("account_id"));
        account.setAccountName((String) map.get("account_name"));
        account.setPassword((String) map.get("password"));
        account.setStatusDelete((int) map.get("status_delete"));
        role.setIdRole((Integer) map.get("role_id"));
        role.setNameRole((String) map.get("role_name"));
        account.setRole(role);
        return account;
    }

}
