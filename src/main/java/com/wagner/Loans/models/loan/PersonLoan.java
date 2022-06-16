package com.wagner.Loans.models.loan;

import com.wagner.Loans.models.customer.Customer;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@AllArgsConstructor
public class PersonLoan extends Loan implements AggregateLoan{

    public void getLoanCustomer(Customer customer, List<Loan> loans){
        loans.add(build());
    }

    @Override
    protected PersonLoan build() {
        rate = new BigDecimal("4");
        typeLoan = TypeLoan.EMPRESTIMO_PESSOAL;

        return this;
    }
}
