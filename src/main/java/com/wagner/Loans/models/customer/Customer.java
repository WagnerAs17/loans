package com.wagner.Loans.models.customer;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Customer {
    private String name;
    private String cpf;
    private int age;
    private String uf;
    private double salary;
}
