package com.example.projecttraining.service.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final String ADMIN = "ROLE_ADMIN";
    public boolean isAdmin() {
        UserDetailImpl userDetail = (UserDetailImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetail.getAuthorities().toString().contains(ADMIN);
    }
    public int getIdLogin() {
        UserDetailImpl userDetail = (UserDetailImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetail.getAccountId();
    }
}
