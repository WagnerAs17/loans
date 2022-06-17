package com.wagner.Loans.models.loan;

import com.wagner.Loans.models.customer.Customer;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class InvestimentLoan extends Loan implements AggregateLoan{
    private static final double MINIMUMVALUE = 3000;
    private static final String UFSP = "SP";
    private static final int MAXIMUMAGE = 30;
    private static final double MAXIMUMVALUE = 5000;

    public Loan getLoanCustomer(){
        return build();
    }

    @Override
    protected InvestimentLoan build(){
        rate = new BigDecimal("3");
        typeLoan = TypeLoan.EMPRESTIMO_GARANTIA;

        return this;
    }

    @Override
    public boolean isElegible(Customer customer){
        return conditionMinimumValue(customer)  ||
                conditionInterMediary(customer) ||
                conditionMaximum(customer);
    }

    private boolean conditionMinimumValue(Customer customer){
        return customer.getSalary() <= MINIMUMVALUE &&
                customer.getUf().equalsIgnoreCase(UFSP) &&
                customer.getAge() < MAXIMUMAGE;
    }

    private boolean conditionInterMediary(Customer customer){
        return customer.getSalary() >= MINIMUMVALUE &&
                customer.getUf().equalsIgnoreCase(UFSP);
    }

    private boolean conditionMaximum(Customer customer){
        return customer.getSalary() >= MAXIMUMVALUE &&
                customer.getAge() <= MAXIMUMAGE;
    }
}