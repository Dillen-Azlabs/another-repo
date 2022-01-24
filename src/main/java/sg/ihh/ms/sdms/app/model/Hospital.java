package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "hospital", "order", "publishFlag", "createdDt", "modifiedDt"})
public class Hospital extends BaseModel {

    @JsonProperty("hospital")
    private String hospital;

    public Hospital() {
        // Empty Constructor
    }

    public String getHospital() {
        return hospital;
    }

    @ColumnName("hospital")
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
