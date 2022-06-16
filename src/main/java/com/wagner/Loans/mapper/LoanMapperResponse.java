package com.wagner.Loans.mapper;

import com.wagner.Loans.dtos.ResponseDTO;
import com.wagner.Loans.models.customer.Customer;
import com.wagner.Loans.models.loan.Loan;

import java.util.ArrayList;
import java.util.List;

public class LoanMapperResponse {

    public static ResponseDTO toDTO(Customer customer, List<Loan> loans){
        return ResponseDTO.builder()
                .loanDTO(loanDTOList(loans))
                .customer(toCustomerDTO(customer))
                .build();
    }

    private static ResponseDTO.CustomerDTO toCustomerDTO(Customer customer){
        return ResponseDTO.CustomerDTO.builder()
                .age(customer.getAge())
                .cpf(customer.getCpf())
                .name(customer.getName())
                .uf(customer.getUf())
                .salary(customer.getSalary())
                .build();
    }

    private static List<ResponseDTO.LoanDTO> loanDTOList(List<Loan> loans){
        var loansDTO = new ArrayList<ResponseDTO.LoanDTO>();

        loans.forEach(loan -> {
            loansDTO.add(toLoanDTO(loan));
        });

        return loansDTO;
    }

    private static ResponseDTO.LoanDTO toLoanDTO(Loan loan){
        return ResponseDTO.LoanDTO
                .builder()
                .rate(loan.getRate())
                .typeLoan(loan.getTypeLoan())
                .build();
    }
}
