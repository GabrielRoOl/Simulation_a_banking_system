package br.com.bank.service;

import br.com.bank.domain.http.HttpAgency;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/situacao-cadastral")
@RegisterRestClient(configKey = "situacao-cadastral-api")
interface HttpServiceRegisterStatus {

    @GET    /* type of request that will be called to search for cnpj */
    @Path("{cnpj}")
    HttpAgency searchByCnpj(String cnjp);
}
