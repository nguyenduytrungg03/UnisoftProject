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
    private AccountMapper accountMapper;
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
        account.setAccountId((int) map.get("account_id"));
        account.setAccountName((String) map.get("account_name"));
        account.setPassword((String) map.get("password"));
        account.setConfirmPassword((String) map.get("confirmPassword"));
        account.setStatusDelete((boolean) map.get("status_delete"));
        role.setIdRole((int) map.get("id_role"));
        role.setNameRole((String) map.get("name_role"));
        account.setRole(role);
        return account;
    }

}
