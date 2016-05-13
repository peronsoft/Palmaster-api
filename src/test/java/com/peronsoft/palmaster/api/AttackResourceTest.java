package com.peronsoft.palmaster.api;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AttackResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(AttackResource.class);
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        final String responseMsg = target().path("palmaster/attack/handaxe/150/16").request().get(String.class);

        assertEquals("17EK", responseMsg);
    }
}
