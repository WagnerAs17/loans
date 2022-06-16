package com.wagner.Loans.models.loan;

import com.wagner.Loans.models.customer.Customer;

import java.util.List;

public interface AggregateLoan {

    void getLoanCustomer(Customer customer, List<Loan> loans);
}
