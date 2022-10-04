package com.example.springsecurity;

import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

  private final List<Customer> listAllCustomer = List.of(
      new Customer(1L, "Steve"),
      new Customer(2L, "Tony"),
      new Customer(3L, "Bruce"),
      new Customer(4L, "Natasha"),
      new Customer(1L, "Clint")
  );

  @GetMapping("{customerId}")
  public Customer listCustomers(@PathVariable Long customerId) {
    return listAllCustomer.stream()
        .filter(customer -> customer.getId().equals(customerId))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("No customer found with id " + customerId));
  }

}
