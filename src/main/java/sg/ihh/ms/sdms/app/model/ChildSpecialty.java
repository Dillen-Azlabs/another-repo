package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "childSpecialty", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ChildSpecialty extends BaseModel{
    @JsonProperty("childSpecialty")
    private String childSpecialty;

    public ChildSpecialty() {
        //Empty Constructor
    }

    public String getChildSpecialty() {
        return childSpecialty;
    }

    public void setChildSpecialty(String childSpecialty) {
        this.childSpecialty = childSpecialty;
    }


}
