package org.protechskillsinstitute.interactions.applications.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.protechskillsinstitute.interactions.applications.entity.FiledApplication;

@ApplicationScoped
public class FiledAppsResource {

    private static final Logger LOGGER = Logger.getLogger(FiledAppsResource.class.getName());

    @Inject
    @RestClient
    FiledAppsService service;

    public List<FiledApplication> findBySomeId(@PathParam("someId") UUID someId) {
		List<FiledApplication> applications = new ArrayList<>();
		try {
			Response response = this.service.findBySomeId(someId);
			if (response.getStatus() == 200) {
				JsonArray serviceItems = response.readEntity(JsonArray.class);
				for (JsonValue item : serviceItems) {
					JsonObject itemToExtract = item.asJsonObject();
					FiledApplication application = new FiledApplication(itemToExtract);
					applications.add(application);
				}
			}
			return applications;
		} catch (Exception e) {
			LOGGER.log(Level.DEBUG, e.toString(), e);
			return null;
		}
    }
    
}
