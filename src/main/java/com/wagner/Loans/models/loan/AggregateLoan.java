package com.wagner.Loans.models.loan;

import com.wagner.Loans.models.customer.Customer;

public interface AggregateLoan {

    Loan getLoanCustomer();
    boolean isElegible(Customer customer);
}
