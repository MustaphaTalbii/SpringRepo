package com.SpringApp.Project.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.SpringApp.Project.Services.CustomUserDtlsService;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter{

    @Bean
    public CustomUserDtlsService getUserDtlsService(){
        return new CustomUserDtlsService();
    }

    @Bean
    public BCryptPasswordEncoder getPaswword(){
        return new BCryptPasswordEncoder();
    }

    public DaoAuthenticationProvider daoProvider(){
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(getUserDtlsService());
        dao.setPasswordEncoder(getPaswword());
        return dao;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoProvider());
    }

    @Override
protected void configure(HttpSecurity http) throws Exception {
    http 
    .csrf().disable();
}

    
}
