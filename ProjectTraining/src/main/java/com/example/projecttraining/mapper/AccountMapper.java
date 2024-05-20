package com.example.projecttraining.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface AccountMapper {
    Map<String, Object> findByAccountName(String accountName);

    int createAccount(String accountName, String password, int roleId);
    
    int updateAccount(String accountName, String password, int versionAccount, int accountId);

    int findByIdAccountByAccountName(String accountName);
    
    int exitsByAccountName(String accountName, int accountId);
}
