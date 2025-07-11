package br.com.bank.domain;


import lombok.Getter;

@Getter
public class Address {

    private Integer id;
    private String road;
    private String publicPlace;
    private String complement;
    private Integer number;
}
