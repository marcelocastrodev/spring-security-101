package com.example.springsecurity.security;

import static com.example.springsecurity.security.UserAuthority.CUSTOMER_READ;
import static com.example.springsecurity.security.UserAuthority.CUSTOMER_WRITE;
import static com.example.springsecurity.security.UserAuthority.TRANSACTION_READ;
import static com.example.springsecurity.security.UserAuthority.TRANSACTION_WRITE;

import java.util.List;

public enum UserRole {

  CUSTOMER(List.of(CUSTOMER_READ, CUSTOMER_WRITE)),
  ADMIN(List.of(CUSTOMER_READ, CUSTOMER_WRITE, TRANSACTION_READ, TRANSACTION_WRITE));

  private final List<UserAuthority> authorities;

  UserRole(List<UserAuthority> authorities) {
    this.authorities = authorities;
  }

  public List<UserAuthority> getAuthorities() {
    return authorities;
  }
}
