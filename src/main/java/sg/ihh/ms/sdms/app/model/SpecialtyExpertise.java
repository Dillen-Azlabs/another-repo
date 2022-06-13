package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"uid", "languageCode", "ourDoctorIntro", "ourDoctorMetaTitle", "ourDoctorMetaDesc", "order", "publishFlag", "createdDt", "modifiedDt"})
public class SpecialtyExpertise extends BaseModel{

    @JsonProperty("ourDoctorIntro")
    private String ourDocIntro;
    @JsonProperty("ourDoctorMetaTitle")
    private String ourDocMetaTitle;
    @JsonProperty("ourDoctorMetaDesc")
    private String ourDocMetaDesc;

    public SpecialtyExpertise() {
        //Empty Constructor
    }

    public String getOurDocIntro() {
        return ourDocIntro;
    }

    public void setOurDocIntro(String ourDocIntro) {
        this.ourDocIntro = ourDocIntro;
    }

    public String getOurDocMetaTitle() {
        return ourDocMetaTitle;
    }

    public void setOurDocMetaTitle(String ourDocMetaTitle) {
        this.ourDocMetaTitle = ourDocMetaTitle;
    }

    public String getOurDocMetaDesc() {
        return ourDocMetaDesc;
    }

    public void setOurDocMetaDesc(String ourDocMetaDesc) {
        this.ourDocMetaDesc = ourDocMetaDesc;
    }
}
