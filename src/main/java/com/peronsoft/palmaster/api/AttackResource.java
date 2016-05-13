package com.peronsoft.palmaster.api;


import com.peronsoft.palmaster.api.palmaster.service.WeaponService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("palmaster")
public class AttackResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path ("attack/{weaponName}/{attackPower}/{armor}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@PathParam("weaponName") String weaponName, @PathParam("attackPower") String attackPower , @PathParam("armor") String armor) {
        return WeaponService.getInstance().getValue(weaponName, attackPower, armor);
    }
}
