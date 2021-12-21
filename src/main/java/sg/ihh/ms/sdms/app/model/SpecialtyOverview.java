package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "overviewIntroduction", "ourApproachIntroduction", "ourApproachIntroductionVideoUrl","whyChooseUs","whyChooseUsVideoUrl","overviewMetaTitle","overviewMetaDescription", "order", "publishFlag", "createdDt", "modifiedDt"})
public class SpecialtyOverview extends BaseModel{

    @JsonProperty("overviewIntroduction")
    private String overviewIntroduction;
    @JsonProperty("ourApproachIntroduction")
    private String oai;
    @JsonProperty("ourApproachIntroductionVideoUrl")
    private String oavu;
    @JsonProperty("whyChooseUs")
    private String wcu;
    @JsonProperty("whyChooseUsVideoUrl")
    private String wcuvu;
    @JsonProperty("overviewMetaTitle")
    private String overviewMetaTitle;
    @JsonProperty("overviewMetaDescription")
    private String overviewMetaDesc;

    public SpecialtyOverview() {
        //Empty Constructor
    }

    public String getOverviewIntroduction() {
        return overviewIntroduction;
    }

    public void setOverviewIntroduction(String overviewIntroduction) {
        this.overviewIntroduction = overviewIntroduction;
    }

    public String getOai() {
        return oai;
    }

    public void setOai(String oai) {
        this.oai = oai;
    }

    public String getOavu() {
        return oavu;
    }

    public void setOavu(String oavu) {
        this.oavu = oavu;
    }

    public String getWcu() {
        return wcu;
    }

    public void setWcu(String wcu) {
        this.wcu = wcu;
    }

    public String getWcuvu() {
        return wcuvu;
    }

    public void setWcuvu(String wcuvu) {
        this.wcuvu = wcuvu;
    }

    public String getOverviewMetaTitle() {
        return overviewMetaTitle;
    }

    public void setOverviewMetaTitle(String overviewMetaTitle) {
        this.overviewMetaTitle = overviewMetaTitle;
    }

    public String getOverviewMetaDesc() {
        return overviewMetaDesc;
    }

    public void setOverviewMetaDesc(String overviewMetaDesc) {
        this.overviewMetaDesc = overviewMetaDesc;
    }
}
