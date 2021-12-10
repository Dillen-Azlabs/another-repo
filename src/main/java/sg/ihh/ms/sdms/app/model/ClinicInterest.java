package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "clinicInterest", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ClinicInterest extends  BaseModel{
    @JsonProperty("clinicInterest")
    private String clinicInterest;

    public ClinicInterest() {
        //Empty Constructor
    }

    public String getClinicInterest() {
        return clinicInterest;
    }

    public void setClinicInterest(String clinicInterest) {
        this.clinicInterest = clinicInterest;
    }
}
