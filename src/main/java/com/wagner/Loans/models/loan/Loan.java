package com.wagner.Loans.models.loan;

import lombok.Getter;
import java.math.BigDecimal;

@Getter
public abstract class Loan {

    protected BigDecimal rate;
    protected TypeLoan typeLoan;

    protected abstract Loan build();
}
