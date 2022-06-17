package com.wagner.Loans.models.loan;

import com.wagner.Loans.models.customer.Customer;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class PersonLoan extends Loan implements AggregateLoan{
    private static int MINIMUMVALUEACCEPT = 0;

    @Override
    public Loan getLoanCustomer(){
        return build();
    }

    @Override
    public boolean isElegible(Customer customer) {
        return customer.getSalary() > MINIMUMVALUEACCEPT;
    }

    @Override
    protected PersonLoan build() {
        rate = new BigDecimal("4");
        typeLoan = TypeLoan.EMPRESTIMO_PESSOAL;

        return this;
    }
}