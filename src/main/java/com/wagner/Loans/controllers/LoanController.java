package com.wagner.Loans.controllers;

import com.wagner.Loans.dtos.ResponseDTO;
import com.wagner.Loans.factory.LoanFactory;
import com.wagner.Loans.mapper.LoanMapperResponse;
import com.wagner.Loans.models.customer.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("loans")
@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanFactory loanFactory;

    @PostMapping
    public ResponseEntity<ResponseDTO> getElegibleLoansCustomer(@RequestBody Customer customer){

        return ResponseEntity.ok(LoanMapperResponse.toDTO(customer,loanFactory.createLoans(customer)));
    }
}
