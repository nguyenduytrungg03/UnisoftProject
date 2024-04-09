package com.example.projecttraining.service.security;

import com.example.projecttraining.model.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailImp implements UserDetails {

        private Integer accountId;
        private String accountName;
        private String password;
        private boolean isAccountNonLocked;
        private List<? extends GrantedAuthority> authorities;

    public UserDetailImp() {
    }
    public static UserDetailImp convertAccountToAccountDetail(Account account){

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(account.getRole().getNameRole()));
        boolean status = true;
        if (account.getStatusDelete() == 0){
            status = false;
        }
        return new UserDetailImp(
                account.getAccountId(),
                account.getAccountName(),
                account.getPassword(),
                status,
                authorities
        ) {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return null;
            }

            @Override
            public String getUsername() {
                return null;
            }

            @Override
            public boolean isAccountNonExpired() {
                return false;
            }

            @Override
            public boolean isAccountNonLocked() {
                return false;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }
        };
    }

    public UserDetailImp(Integer accountId, String accountName, String password, boolean isAccountNonLocked, List<? extends GrantedAuthority> authorities) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.password = password;
        this.isAccountNonLocked = isAccountNonLocked;
        this.authorities = authorities;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
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

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
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
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
