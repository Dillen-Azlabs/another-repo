package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "insurance", "order", "publishFlag", "createdDt", "modifiedDt"})
public class InsuranceProvider extends BaseModel {

    @JsonProperty("insurance")
    private String insurance;

    public InsuranceProvider() {
        // Empty Constructor
    }

    public String getInsurance() {
        return insurance;
    }

    @ColumnName("insurance")
    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }
}
