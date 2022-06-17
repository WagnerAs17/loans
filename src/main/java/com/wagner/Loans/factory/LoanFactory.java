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
public class LoanFactory  {

    private final List<AggregateLoan> offersLoans;

    public List<Loan> eligibleLoansCustomer(final Customer customer){
        final var eligibleLoansCustomer = new ArrayList<Loan>();

        offersLoans.stream()
                .filter(offerLoan -> offerLoan.isEligible(customer))
                .forEach(offerLoan -> eligibleLoansCustomer.add(offerLoan.getLoanCustomer()));

        return eligibleLoansCustomer;
    }
}