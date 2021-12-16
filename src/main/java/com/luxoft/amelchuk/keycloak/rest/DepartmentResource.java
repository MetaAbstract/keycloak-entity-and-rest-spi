package com.luxoft.amelchuk.keycloak.rest;

import com.luxoft.amelchuk.keycloak.DepartmentRepresentation;
import com.luxoft.amelchuk.keycloak.spi.DepartmentService;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.keycloak.models.KeycloakSession;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DepartmentResource {
    private final KeycloakSession session;

    public DepartmentResource(KeycloakSession session) {
        this.session = session;
    }

    @GET
    @Path("list")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<DepartmentRepresentation> getDepartments() {
//        ProviderFactory provider = session.getProvider(ProviderFactory.class);
//        ServiceProviderFactory spf = (ServiceProviderFactory) provider;
//        ServiceProvider sp =  spf.create(session);
//        return sp.listDepartments();
//        List<DepartmentRepresentation> result = new LinkedList<>();
//        return result;
        Set<DepartmentService> proves = session.getAllProviders(DepartmentService.class);
        System.out.println("start");
        for ( DepartmentService prov: proves ) {
            System.out.println(prov.getClass().toString());
        }
        System.out.println("stop");
        DepartmentService provider = session.getProvider(DepartmentService.class);
        return provider.listDepartments();
    }

    @POST
    @Path("create")
    @NoCache
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDepartment(DepartmentRepresentation rep) {
        session.getProvider(DepartmentService.class).createDepartment(rep);
        return Response.created(session.getContext().getUri().getAbsolutePathBuilder().path(rep.getId()).build()).build();
    }

    @GET
    @NoCache
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DepartmentRepresentation getDepartment(@PathParam("id") final String id) {
        return session.getProvider(DepartmentService.class).findDepartment(id);
    }

}
