package com.wagner.Loans.factory;

import com.wagner.Loans.models.customer.Customer;
import com.wagner.Loans.models.loan.AggregateLoan;
import com.wagner.Loans.models.loan.Loan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanFactory {

    private final List<AggregateLoan> offersLoans;

    private final List<Loan> elegibleLoansCustomer = new ArrayList<>();

    public List<Loan> createLoans(Customer customer){
        elegibleLoansCustomer.clear();
        offersLoans.stream()
                .distinct()
                .filter(loan -> loan.isElegible(customer))
                .forEach(loan -> elegibleLoansCustomer.add(loan.getLoanCustomer()));

        return elegibleLoansCustomer;
    }
}