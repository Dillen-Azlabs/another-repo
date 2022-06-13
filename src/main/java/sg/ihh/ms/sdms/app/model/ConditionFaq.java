package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "additionalResources", "faqs","faqMetaTitle", "faqMetaDescription",  "order", "publishFlag", "createdDt", "modifiedDt"})
public class ConditionFaq extends BaseModel{

    @JsonProperty("additionalResources")
    private String additionalResource;
    @JsonProperty("faqs")
    private List<ConditionSdFaq> faqs;
    @JsonProperty("faqMetaTitle")
    private String faqTitle;
    @JsonProperty("faqMetaDescription")
    private String faqDesc;
    public ConditionFaq() {
        //Empty Constructor
    }

    public List<ConditionSdFaq> getFaqs() {
        return faqs;
    }

    public void setFaqs(List<ConditionSdFaq> faqs) {
        this.faqs = faqs;
    }

    public String getAdditionalResource() {
        return additionalResource;
    }

    @ColumnName("additional_resource")
    public void setAdditionalResource(String additionalResource) {
        this.additionalResource = additionalResource;
    }

    public String getFaqTitle() {
        return faqTitle;
    }
    @ColumnName("faq_title")
    public void setFaqTitle(String faqTitle) {
        this.faqTitle = faqTitle;
    }

    public String getFaqDesc() {
        return faqDesc;
    }
    @ColumnName("faq_desc")
    public void setFaqDesc(String faqDesc) {
        this.faqDesc = faqDesc;
    }
}
