package com.SpringApp.Project.Security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.SpringApp.Project.entity.Users;

public class CustomUserDtls implements UserDetails{

    
    Users user;

    public CustomUserDtls(Users u){
        super();
        this.user=u;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet <SimpleGrantedAuthority> set = new HashSet<SimpleGrantedAuthority>();
        set.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return set;
    }

    @Override
    public String getPassword() {
       return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
