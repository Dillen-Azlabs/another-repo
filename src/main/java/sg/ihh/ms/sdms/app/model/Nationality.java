package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "nationality", "order", "publishFlag", "createdDt", "modifiedDt"})
public class Nationality extends BaseModel{
    @JsonProperty("nationality")
    private String nationality;

    public Nationality() {
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
