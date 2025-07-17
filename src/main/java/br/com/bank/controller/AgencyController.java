package br.com.bank.controller;

import br.com.bank.domain.Agency;
import br.com.bank.service.AgencyService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/agencies")
public class AgencyController {

    private final AgencyService agencyService;

    AgencyController(AgencyService agencyService){
        this.agencyService = agencyService;
    }

    @POST
    public RestResponse<Void> register(Agency agency, @Context UriInfo uriInfo){
        this.agencyService.register(agency);
        return RestResponse.created(uriInfo.getAbsolutePath());
    }

    @GET
    @Path("{id}")
    public RestResponse<Agency> findById(Integer id){
        Agency agency = agencyService.findById(id);
        return RestResponse.ok(agency);
    }

    @DELETE
    @Path("{id}")
    public RestResponse<Void> delet(Integer id){
        agencyService.delet(id);
        return  RestResponse.ok();
    }

    @PUT
    public RestResponse<Void> update(Agency agency){
        agencyService.update(agency);
        return RestResponse.ok();
    }


}
