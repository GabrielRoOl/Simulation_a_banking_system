package br.com.bank.controller;

import br.com.bank.domain.Agency;
import br.com.bank.service.AgencyService;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/agencies")
public class AgencyController {

    private final AgencyService agencyService;

    AgencyController(AgencyService agencyService){
        this.agencyService = agencyService;
    }

    public RestResponse<Void> register(Agency agency, @Context UriInfo uriInfo){
        this.agencyService.register(agency);
        return RestResponse.created(uriInfo.getAbsolutePath());
    }
}
