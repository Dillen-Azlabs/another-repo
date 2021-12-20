package sg.ihh.ms.sdms.app.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "whyChooseUs", "doctorIntro", "expertiseMetaTitle","expertiseMetaDescription", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ConditionExpertise extends BaseModel{

    @JsonProperty("whyChooseUs")
    private String wcu;
    @JsonProperty("doctorIntro")
    private String docIntro;
    @JsonProperty("expertiseMetaTitle")
    private String expertiseMetaTitle;
    @JsonProperty("expertiseMetaDescription")
    private String expertiseMetaDesc;

    public ConditionExpertise() {
        //Empty Constructor
    }

    public String getWcu() {
        return wcu;
    }
    @ColumnName("wcu")
    public void setWcu(String wcu) {
        this.wcu = wcu;
    }

    public String getDocIntro() {
        return docIntro;
    }
    @ColumnName("doc_intro")
    public void setDocIntro(String docIntro) {
        this.docIntro = docIntro;
    }

    public String getExpertiseMetaTitle() {
        return expertiseMetaTitle;
    }
    @ColumnName("expertise_meta_title")
    public void setExpertiseMetaTitle(String expertiseMetaTitle) {
        this.expertiseMetaTitle = expertiseMetaTitle;
    }

    public String getExpertiseMetaDesc() {
        return expertiseMetaDesc;
    }
    @ColumnName("expertise_meta_desc")
    public void setExpertiseMetaDesc(String expertiseMetaDesc) {
        this.expertiseMetaDesc = expertiseMetaDesc;
    }
}

