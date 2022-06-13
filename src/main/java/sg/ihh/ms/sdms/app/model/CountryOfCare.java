package sg.ihh.ms.sdms.app.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "coc", "order", "publishFlag", "createdDt", "modifiedDt"})
public class CountryOfCare extends BaseModel{

    @JsonProperty("coc")
    private String coc;

    public String getCoc() {
        return coc;
    }

    public void setCoc(String coc) {
        this.coc = coc;
    }
}
