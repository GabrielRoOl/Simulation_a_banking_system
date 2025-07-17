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
        if(httpAgency != null && httpAgency.getRegisterStatus().equals(RegisterStatus.ACTIVE)){
            agencyList.add(agency);
        }else {
            throw new AgencyNotFoundOrNotActiveExcetion();
        }
    }

    public Agency findById(Integer id){
        return agencyList.stream().filter(a -> a.getId().equals(id)).toList().getFirst();
    }

    public void delet(Integer id){
        agencyList.removeIf(a -> a.getId().equals(id));
    }

    public void update(Agency agency){
        delet(agency.getId());
        register(agency);
    }
}
