package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.List;
@JsonPropertyOrder({"uid", "languageCode", "additionalResources", "faqs", "order", "publishFlag", "createdDt", "modifiedDt"})
public class TreatmentFaq extends BaseModel{

    @JsonProperty("additionalResources")
    private String additionalResource;
    @JsonProperty("faqs")
    private List<TreatmentSdFaq> faqs;

    public TreatmentFaq() {
        //Empty Constructor
    }

    public String getAdditionalResource() {
        return additionalResource;
    }
    @ColumnName("additional_resource")
    public void setAdditionalResource(String additionalResource) {
        this.additionalResource = additionalResource;
    }

    public List<TreatmentSdFaq> getFaqs() {
        return faqs;
    }

    public void setFaqs(List<TreatmentSdFaq> faqs) {
        this.faqs = faqs;
    }
}
