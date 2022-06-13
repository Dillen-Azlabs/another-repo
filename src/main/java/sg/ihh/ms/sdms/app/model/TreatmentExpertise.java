package sg.ihh.ms.sdms.app.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "whyChooseUs", "billEstimator", "ourDocIntro", "specialties","order", "publishFlag", "createdDt", "modifiedDt"})
public class TreatmentExpertise extends BaseModel{

    @JsonProperty("whyChooseUs")
    private String wcu;
    @JsonProperty("billEstimator")
    private String bill;
    @JsonProperty("ourDocIntro")
    private String docIntro;
    @JsonProperty("specialties")
    private List<String> specialties;

    public TreatmentExpertise() {
        //Empty Constructor
    }

    public String getWcu() {
        return wcu;
    }

    public void setWcu(String wcu) {
        this.wcu = wcu;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public String getDocIntro() {
        return docIntro;
    }

    public void setDocIntro(String docIntro) {
        this.docIntro = docIntro;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
    }
}
