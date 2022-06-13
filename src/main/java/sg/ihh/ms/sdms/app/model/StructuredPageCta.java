package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "mainCtaLabel1", "mainCtaUrl1", "mainCtaLabel2", "mainCtaUrl2",  "order", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPageCta extends BaseModel{

    @JsonProperty("mainCtaLabel1")
    private String mainCtaLabel1;
    @JsonProperty("mainCtaUrl1")
    private String mainCtaUrl1;
    @JsonProperty("mainCtaLabel2")
    private String mainCtaLabel2;
    @JsonProperty("mainCtaUrl2")
    private String mainCtaUrl2;

    public StructuredPageCta() {
        //Empty Constructor
    }

    public String getMainCtaLabel1() {
        return mainCtaLabel1;
    }

    public void setMainCtaLabel1(String mainCtaLabel1) {
        this.mainCtaLabel1 = mainCtaLabel1;
    }

    public String getMainCtaUrl1() {
        return mainCtaUrl1;
    }

    public void setMainCtaUrl1(String mainCtaUrl1) {
        this.mainCtaUrl1 = mainCtaUrl1;
    }

    public String getMainCtaLabel2() {
        return mainCtaLabel2;
    }

    public void setMainCtaLabel2(String mainCtaLabel2) {
        this.mainCtaLabel2 = mainCtaLabel2;
    }

    public String getMainCtaUrl2() {
        return mainCtaUrl2;
    }

    public void setMainCtaUrl2(String mainCtaUrl2) {
        this.mainCtaUrl2 = mainCtaUrl2;
    }
}
