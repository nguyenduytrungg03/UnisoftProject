package com.example.projecttraining.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface AccountMapper {
    Map<String, Object> findByAccountName(String accountName);
}
