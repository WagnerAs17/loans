package com.wagner.Loans.controllers;

import com.wagner.Loans.models.customer.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    private static List<Customer> customers = new ArrayList<>();

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        customers.add(customer);
        log.info("customers: {}", customers);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}
