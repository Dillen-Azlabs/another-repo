package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "additionalResources", "faqs", "faqMetaTitle", "faqMetaDescription", "order", "publishFlag", "createdDt", "modifiedDt"})
public class SpecialtyFaq extends BaseModel{

    @JsonProperty("additionalResources")
    private String additionalResource;
    @JsonProperty("faqs")
    private List<SpecialtySdFaq> faqs;
    @JsonProperty("faqMetaTitle")
    private String faqTitle;
    @JsonProperty("faqMetaDescription")
    private String faqDesc;

    public SpecialtyFaq() {
        //Empty Constructor
    }

    public String getAdditionalResource() {
        return additionalResource;
    }

    public void setAdditionalResource(String additionalResource) {
        this.additionalResource = additionalResource;
    }

    public String getFaqTitle() {
        return faqTitle;
    }

    public void setFaqTitle(String faqTitle) {
        this.faqTitle = faqTitle;
    }

    public String getFaqDesc() {
        return faqDesc;
    }

    public void setFaqDesc(String faqDesc) {
        this.faqDesc = faqDesc;
    }

    public List<SpecialtySdFaq> getFaqs() {
        return faqs;
    }

    public void setFaqs(List<SpecialtySdFaq> faqs) {
        this.faqs = faqs;
    }
}
