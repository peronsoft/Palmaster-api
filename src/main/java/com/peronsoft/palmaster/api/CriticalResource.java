package com.peronsoft.palmaster.api;

import com.peronsoft.palmaster.api.palmaster.service.CriticalService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by rodrigo on 16/05/16.
 */
@Path("palmaster/critical")
public class CriticalResource {

    @GET
    @Path ("{criticalType}/{criticalRoll}/{criticalLvl}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@PathParam("criticalType") String criticalType, @PathParam("criticalRoll") String criticalRoll , @PathParam("criticalLvl") String criticalLvl) {
        return CriticalService.getInstance().getValue(criticalType, criticalRoll, criticalLvl);
    }
}
