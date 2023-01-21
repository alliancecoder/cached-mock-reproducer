package org.protechskillsinstitute.interactions.applications.boundary;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.protechskillsinstitute.interactions.applications.entity.FiledApplication;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class FiledAppsResourceIT {
	
	private final UUID someId = UUID.fromString("c6bc3345-9d2b-4163-ad21-6072d237a360");
	private final UUID missingId = UUID.fromString("fc64e993-e7c9-4055-9a4b-91770e73e6d2");
    private final String valueToTest = "USELESS-01";
    
    @Inject
    FiledAppsResource service;

    @Test
    public void can_get_data_from_external_service() {
        List<FiledApplication> cut = this.service.findBySomeId(someId);
		Assertions.assertNotNull(cut);
		int cutSize = 5;
        Assertions.assertEquals(cutSize, cut.size());
        String actual = cut.get(0).uselessData;
        Assertions.assertTrue(actual.equals(valueToTest));
    }
	
	@Test
	public void invalid_someId_returns_null() {
        List<FiledApplication> cut = this.service.findBySomeId(missingId);
		Assertions.assertNull(cut);
	}
}
