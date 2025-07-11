package br.com.bank.domain.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HttpAgency {
    private String name;
    private String companyName;
    private String cnpj;
    private RegisterStatus registerStatus;
}
