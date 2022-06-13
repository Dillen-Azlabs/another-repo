package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "country", "order", "publishFlag", "createdDt", "modifiedDt"})
public class Country extends BaseModel {

    @JsonProperty("country")
    private String country;

    public Country() {
        // Empty Constructor
    }

    public String getCountry() {
        return country;
    }

    @ColumnName("country")
    public void setCountry(String country) {
        this.country = country;
    }

}
