# Proposta de valor

A proposta da aplicação é disponibilizar a uma pessoa as modalidades de empréstimo as quais ela tem acesso de acordo com algumas variáveis.

 

Prover os seguintes modelos de empréstimo:

- Empréstimo pessoal. Taxa de juros: 4%

- Empréstimo com garantia. Taxa de juros: 3%

- Consignado. Taxa de juros: 2%

 

Abaixo seguem as regras de negócio relacionadas a concessão de empréstimo de acordo com o perfil do cliente


| Salário                  | Empréstimo pessoal | Empréstimo com garantia | Consignado |

| --------                 | ------------------ | ---------------------- | ---------- |

| Salário <= 3000          | Sim                |       Sim***           | Não        |

| Salário >= 3000          | Sim                |        Sim**           | Não        |

| Salário >= 5000          | Sim                |         Sim*           | Sim        |

 

Regras adicionais

- * Clientes com menos de 30 anos

- ** Clientes que residem em SP

- *** Clientes com menos de 30 anos que residem em SP
### Utilização da aplicação:

 

A aplicação deve receber como entrada as seguintes informações:

 

##### Dados de entrada (Exemplo)

 

{​​​​

  "cliente": {​​​​

    "name": "teste teste",

    "cpf": "123.456.789-10",

    "age": 29,

    "uf": "SP",

    "renda_mensal": 3000

  }​​​​

}​​​​


 

Para fins de simplicidade, considere que vamos sempre receber os dados corretos (tipos e formatos).

 

A aplicação deve responder com o seguinte modelo de informações:

 

##### Dados de saída (Exemplo)

 

{​​​​

  "cliente": {​​​​

      "name": "teste teste",

      "cpf": "123.456.789-10",

      "age": 29,

      "uf": "SP",

      "renda_mensal": 3000

  }​​​​,

  "produtos_emprestimo": [

    {​​​​

      "tipo_emprestimo": "EMPRESTIMO_CONSIGNADO",

      "taxa": 1

    }​​​​,

    {​​​​

      "tipo_emprestimo": "EMPRESTIMO_PESSOAL",

      "taxa": 1

    }​​​​

  ]

}​​​​


 

### Domínio dos tipos de empréstimo

- EMPRESTIMO_CONSIGNADO

- EMPRESTIMO_PESSOAL

- EMPRESTIMO_GARANTIA
