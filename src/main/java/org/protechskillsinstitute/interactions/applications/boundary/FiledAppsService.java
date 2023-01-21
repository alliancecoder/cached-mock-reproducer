package org.protechskillsinstitute.interactions.applications.boundary;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("applications")
@RegisterRestClient
public interface FiledAppsService {
    
        @GET
        @Path("bysomeid/{someId}")
        @Produces({ MediaType.APPLICATION_JSON })
        public Response findBySomeId(@PathParam("someId") UUID someId);
            
}
