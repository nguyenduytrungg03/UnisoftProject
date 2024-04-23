package com.example.projecttraining.service.security;

import com.example.projecttraining.model.Account;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;

public class UserDetailImp implements UserDetails {

        private int accountId;
        private String accountName;
        private String password;
        private boolean statusDelete;
        private List<? extends GrantedAuthority> authorities;

    public UserDetailImp() {
    }
    public static UserDetailImp convertAccountToAccountDetail(Account account){
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(account.getRole().getNameRole()));
        return new UserDetailImp(
                account.getAccountId(),
                account.getAccountName(),
                account.getPassword(),
                !account.isStatusDelete(),
                authorities
        );
    }

    public UserDetailImp(int accountId, String accountName, String password, boolean statusDelete, List<? extends GrantedAuthority> authorities) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.password = password;
        this.statusDelete = statusDelete;
        this.authorities = authorities;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(boolean statusDelete) {
        this.statusDelete = statusDelete;
    }

    public void setAuthorities(List<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return accountName;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
