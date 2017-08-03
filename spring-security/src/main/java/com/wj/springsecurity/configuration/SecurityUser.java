package com.wj.springsecurity.configuration;

import com.wj.springsecurity.entity.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SecurityUser implements UserDetails {

    private UserInfo user;

    public SecurityUser(UserInfo user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !user.getName().equals("root");
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.getEmail().equals("wj@wj.cn");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.getPassword().equals("123");
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
