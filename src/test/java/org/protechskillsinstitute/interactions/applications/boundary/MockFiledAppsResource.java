package org.protechskillsinstitute.interactions.applications.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import org.protechskillsinstitute.interactions.applications.entity.FiledApplication;

import io.quarkus.test.Mock;

@Mock
@ApplicationScoped
public class MockFiledAppsResource extends FiledAppsResource {
    
	private final UUID missingId = UUID.fromString("fc64e993-e7c9-4055-9a4b-91770e73e6d2");
    
    public List<FiledApplication> findBySomeId(UUID someId) {
        List<FiledApplication> mockedObject = new ArrayList<>();
        if (!someId.equals(missingId)) {
            for (int i = 0; i < 5; i++) {
                FiledApplication app = new FiledApplication();
                app.applicationId = UUID.randomUUID();
                int toAdd = i + 1;
                app.uselessData = "USELESS-0" + toAdd;
                mockedObject.add(app);
            }
        }
		return (!someId.equals(missingId)) ? mockedObject : null;
    }
}
