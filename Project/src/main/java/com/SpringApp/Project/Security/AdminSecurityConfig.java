package com.SpringApp.Project.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@Order(1)
public class AdminSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/").permitAll();
        http.antMatcher("/Admin/**").authorizeRequests().anyRequest().hasAuthority("ADMIN").and()
        .formLogin().loginPage("/admin/login")
        .usernameParameter("email")
        .loginProcessingUrl("/admin/login").defaultSuccessUrl("/admin/home")
        .permitAll().and()
        .logout().logoutUrl("/admin/logout").logoutSuccessUrl("/").and().csrf().disable();
        return http.build();
    }

}
