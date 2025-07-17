package br.com.bank.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Agency {

    private Integer id;
    private String name;
    private String socialReason;
    private String cnpj;
    private Address address;


}
