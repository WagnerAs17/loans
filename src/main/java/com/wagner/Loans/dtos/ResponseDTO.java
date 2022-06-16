package com.wagner.Loans.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wagner.Loans.models.loan.TypeLoan;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class ResponseDTO {

    @JsonProperty("cliente")
    private CustomerDTO customer;

    @JsonProperty("produtos_emprestimo")
    private List<LoanDTO> loanDTO;

    @Data
    @Builder
    public static class CustomerDTO{
        @JsonProperty("nome")
        private String name;

        @JsonProperty("cpf")
        private String cpf;

        @JsonProperty("idade")
        private int age;

        @JsonProperty("uf")
        private String uf;

        @JsonProperty("salario")
        private double salary;
    }

    @Data
    @Builder
    public static class LoanDTO{

        @JsonProperty("tipo_emprestimo")
        private TypeLoan typeLoan;

        @JsonProperty("taxa")
        private BigDecimal rate;
    }
}
