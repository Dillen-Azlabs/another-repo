package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "clinicalInterest", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ClinicalInterest extends  BaseModel{
    @JsonProperty("clinicalInterest")
    private String clinicalInterest;

    public ClinicalInterest() {
        //Empty Constructor
    }

    public String getClinicalInterest() {
        return clinicalInterest;
    }

    public void setClinicalInterest(String clinicalInterest) {
        this.clinicalInterest = clinicalInterest;
    }
}
