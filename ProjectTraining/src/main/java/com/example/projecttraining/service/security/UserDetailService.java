package com.example.projecttraining.service.security;

import com.example.projecttraining.model.Account;
import com.example.projecttraining.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private IAccountService iAccountService;

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        Account account = iAccountService.findByAccountName(accountName);
        if (account==null) {
            throw new UsernameNotFoundException("Không tìm thấy tài khoản: " + accountName);
        }
        return UserDetailImpl.convertAccountToAccountDetail(account);
    }
}
