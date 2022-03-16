package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "whyChooseUs", "order", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPageWhyChooseUs extends BaseModel{

    @JsonProperty("whyChooseUs")
    private String whyChooseUs;

    public StructuredPageWhyChooseUs() {
        //Empty Constructor
    }

    public String getWhyChooseUs() {
        return whyChooseUs;
    }

    public void setWhyChooseUs(String whyChooseUs) {
        this.whyChooseUs = whyChooseUs;
    }
}
