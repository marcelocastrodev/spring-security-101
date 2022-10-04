package com.example.springsecurity.security;

public enum UserAuthority {

  CUSTOMER_READ("customer:read"),
  CUSTOMER_WRITE("customer:write"),
  TRANSACTION_READ("transaction:read"),
  TRANSACTION_WRITE("transaction:write");

  private final String authority;

  UserAuthority(String authority) {
    this.authority = authority;
  }

  public String getAuthority() {
    return authority;
  }
}
