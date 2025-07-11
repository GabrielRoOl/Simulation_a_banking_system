package br.com.bank.domain;

import lombok.Getter;

@Getter
public class Agency {

    private Integer id;
    private String name;
    private String socialReason;
    private String cnpj;
    private Address address;
}
