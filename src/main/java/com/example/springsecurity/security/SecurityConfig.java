package com.example.springsecurity.security;

import static com.example.springsecurity.security.UserRole.ADMIN;
import static com.example.springsecurity.security.UserRole.CUSTOMER;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/", "/css/*", "/js/*")
        .permitAll()
        .antMatchers("/api/**").hasRole(CUSTOMER.name())
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
  }

  @Override
  @Bean
  protected UserDetailsService userDetailsService() {

    UserDetails userAdmin = User.builder()
        .username("admin")
        .password(passwordEncoder.encode("admin"))
        .roles(ADMIN.name())
        .build();

    UserDetails userCustomer = User.builder()
        .username("customer")
        .password(passwordEncoder.encode("password"))
        .roles(CUSTOMER.name())
        .build();

    return new InMemoryUserDetailsManager(userAdmin, userCustomer);
  }
}
