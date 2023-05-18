package com.SpringApp.Project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringApp.Project.Repos.UsersRepo;
import com.SpringApp.Project.Security.CustomUserDtls;
import com.SpringApp.Project.entity.Users;

@Service
public class CustomUserDtlsService implements UserDetailsService{

    @Autowired
    private UsersRepo usersRepo;

    @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
        Users user = usersRepo.findById(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User Doesn't Exist");
        }
        else {
            return new CustomUserDtls(user);
        }
        
    } catch (Exception e) {
        e.printStackTrace();
        throw new UsernameNotFoundException("Error retrieving user details");
    }
}
}
