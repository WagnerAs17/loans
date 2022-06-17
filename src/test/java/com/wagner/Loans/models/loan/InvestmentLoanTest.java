package com.wagner.Loans.models.loan;

import com.wagner.Loans.models.customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvestmentLoanTest {
    private static final double MINIMUMVALUE = 3000;
    private static final double MAXIMUMVALUE = 5000;
    private static final int MAXIMUMAGE = 30;
    private final static String UFSP = "SP";
    private final static String UFMG = "MG";
    private InvestmentLoan investmentLoan;

    @BeforeEach()
    public void setUp(){
        this.investmentLoan = new InvestmentLoan();
    }

    @Test
    public void GiveMinimumSalaryWhenUFIsSPAndAgeIsThirtyOrLessThenCustomerIsEligibleInvestmentLoan(){
        //ARRANGE
        var ageEligible = 29;
        var customer = Customer.builder()
                .age(ageEligible)
                .salary(MINIMUMVALUE)
                .uf(UFSP)
                .cpf("60552734039")
                .build();

        //ACT
        var isEligibleInvestmentLoan = investmentLoan.isEligible(customer);

        //ASSERT
        Assertions.assertTrue(isEligibleInvestmentLoan);
    }

    @Test
    public void GiveSalaryBiggerThanMinimumWhenUFIsSPAndAgeIsThirtyOrLessThenCustomerIsEligibleInvestmentLoan(){
        //ARRANGE
        var plus = 1000;
        var ageEligible = 29;
        var customer = Customer.builder()
                .age(ageEligible)
                .salary(MINIMUMVALUE + plus)
                .uf(UFSP)
                .cpf("60552734039")
                .build();

        //ACT
        var isEligibleInvestmentLoan = investmentLoan.isEligible(customer);

        //ASSERT
        Assertions.assertTrue(isEligibleInvestmentLoan);
    }

    @Test
    public void GiveSalaryBiggerThanMinimumAndAgeLessThanThirtyWhenUFIsMGAndAgeIsThirtyOrLessThenCustomerIsEligibleInvestmentLoan(){
        //ARRANGE
        var plus = 1;
        var ageEligible = 29;
        var customer = Customer.builder()
                .age(ageEligible)
                .salary(MAXIMUMVALUE + plus)
                .uf(UFMG)
                .cpf("60552734039")
                .build();

        //ACT
        var isEligibleInvestmentLoan = investmentLoan.isEligible(customer);

        //ASSERT
        Assertions.assertTrue(isEligibleInvestmentLoan);
    }

    @Test
    public void GiveSalaryBiggerThanMinimumAndAgeBiggerThanThirtyWhenUFIsMGAndAgeIsThirtyTwoOrBiggerThenCustomerIsNotEligibleInvestmentLoan(){
        //ARRANGE
        var plus = 1;
        var ageNotEligible = MAXIMUMAGE + 2;
        var customer = Customer.builder()
                .age(ageNotEligible)
                .salary(MAXIMUMVALUE + plus)
                .uf(UFMG)
                .cpf("60552734039")
                .build();

        //ACT
        var isEligibleInvestmentLoan = investmentLoan.isEligible(customer);

        //ASSERT
        Assertions.assertFalse(isEligibleInvestmentLoan);
    }
}