package com.wagner.Loans.models.loan;

import com.wagner.Loans.models.customer.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class PayrollLoan extends Loan implements AggregateLoan {

    private static final double MINIMUMVALUE = 5000;

    public Loan getLoanCustomer(){
       return build();
    }

    @Override
    protected PayrollLoan build() {
        rate = new BigDecimal("2");
        typeLoan = TypeLoan.EMPRESTIMO_CONSIGNADO;
        return this;
    }

    @Override
    public boolean isEligible(final Customer customer) {
        return customer.getSalary() >= MINIMUMVALUE;
    }
}
