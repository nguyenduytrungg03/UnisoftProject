package com.example.projecttraining.mapper;

import com.example.projecttraining.model.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface AccountMapper {
    Map<String, Object> findByAccountName(String accountName);

    Account createAccount(Account account);

}
