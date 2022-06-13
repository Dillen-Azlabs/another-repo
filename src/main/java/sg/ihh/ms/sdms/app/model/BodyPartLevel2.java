package sg.ihh.ms.sdms.app.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "bodyPart", "order", "publishFlag", "createdDt", "modifiedDt"})

public class BodyPartLevel2 extends BaseModel{
    @JsonProperty("bodyPart")
    private String bodyPart;

    public BodyPartLevel2() {

    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

}
