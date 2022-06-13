package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "profession", "order", "publishFlag", "createdDt", "modifiedDt"})
public class MedicalProfession extends BaseModel {

    @JsonProperty("profession")
    private String profession;

    public MedicalProfession() {
        // Empty Constructor
    }

    public String getProfession() {
        return profession;
    }

    @ColumnName("profession")
    public void setProfession(String profession) {
        this.profession = profession;
    }


}
