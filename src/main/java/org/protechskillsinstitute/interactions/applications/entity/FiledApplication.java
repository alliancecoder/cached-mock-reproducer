package org.protechskillsinstitute.interactions.applications.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.json.JsonObject;

public class FiledApplication implements Serializable {

	private static final long serialVersionUID = 1L;

    public UUID applicationId;
    public String uselessData;

    public FiledApplication() {}

    public FiledApplication(JsonObject itemToExtract) {
        this.applicationId = extractId(itemToExtract.get("applicationId").toString());;
        this.uselessData = itemToExtract.getString("uselessData");
    }

	private UUID extractId(String itemToExtract) {
		itemToExtract = itemToExtract.replace("\"", "");
		return UUID.fromString(itemToExtract);
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((applicationId == null) ? 0 : applicationId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FiledApplication other = (FiledApplication) obj;
        if (applicationId == null) {
            if (other.applicationId != null)
                return false;
        } else if (!applicationId.equals(other.applicationId))
            return false;
        return true;
    }
    
}
