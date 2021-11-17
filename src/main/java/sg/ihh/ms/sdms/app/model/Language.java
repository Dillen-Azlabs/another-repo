package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "language", "order", "publishFlag", "createdDt", "modifiedDt"})
public class Language extends BaseModel {

    @JsonProperty("language")
    private String language;

    public Language() {
        // Empty Constructor
    }

    public String getLanguage() {
        return language;
    }

    @ColumnName("language")
    public void setLanguage(String language) {
        this.language = language;
    }

}
