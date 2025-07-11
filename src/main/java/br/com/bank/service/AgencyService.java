package br.com.bank.service;

import br.com.bank.domain.Agency;
import br.com.bank.domain.http.HttpAgency;
import br.com.bank.domain.http.RegisterStatus;
import br.com.bank.exceptions.AgencyNotFoundOrNotActiveExcetion;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AgencyService {

    @RestClient
    private HttpServiceRegisterStatus registerStatus;

    private final List<Agency> agencyList = new ArrayList<>();

    public void register(Agency agency){
        HttpAgency httpAgency = registerStatus.searchByCnpj(agency.getCnpj());
        if(httpAgency.getRegisterStatus().equals(RegisterStatus.ACTIVE)){
            agencyList.add(agency);
        }else {
            throw new AgencyNotFoundOrNotActiveExcetion();
        }
    }

}
