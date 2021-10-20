package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "provider", "order", "publishFlag", "createdDt", "modifiedDt"})
public class InsuranceProvider extends BaseModel {

    @JsonProperty("provider")
    private String provider;

    public InsuranceProvider() {
        // Empty Constructor
    }

    public String getProvider() {
        return provider;
    }

    @ColumnName("provider")
    public void setProvider(String provider) {
        this.provider = provider;
    }
}
