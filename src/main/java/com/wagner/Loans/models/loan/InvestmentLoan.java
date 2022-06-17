package com.wagner.Loans.models.loan;

import com.wagner.Loans.models.customer.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class InvestmentLoan extends Loan implements AggregateLoan{

    private static final double MINIMUMVALUE = 3000;
    private static final String UFSP = "SP";
    private static final int MAXIMUMAGE = 30;
    private static final double MAXIMUMVALUE = 5000;

    @Override
    public Loan getLoanCustomer(){
        return build();
    }

    @Override
    protected InvestmentLoan build(){
        rate = new BigDecimal("3");
        typeLoan = TypeLoan.EMPRESTIMO_GARANTIA;

        return this;
    }

    @Override
    public boolean isEligible(final Customer customer){
        return minimumCondition(customer)  ||
                intermediateCondition(customer) ||
                maximumCondition(customer);
    }

    private boolean minimumCondition(final Customer customer){
        return customer.getSalary() <= MINIMUMVALUE &&
                customer.getUf().equalsIgnoreCase(UFSP) &&
                customer.getAge() < MAXIMUMAGE;
    }

    private boolean intermediateCondition(final Customer customer){
        return customer.getSalary() >= MINIMUMVALUE &&
                customer.getUf().equalsIgnoreCase(UFSP);
    }

    private boolean maximumCondition(Customer customer){
        return customer.getSalary() >= MAXIMUMVALUE &&
                customer.getAge() <= MAXIMUMAGE;
    }
}