package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class OrderRequest {
    @JsonProperty("field")
    @NotBlank(message = "field is mandatory")
    @Pattern(
            regexp = "^(name|mcrNumber)$",
            message = "Allowed Values : name, mcrNumber")
    private String field;

    @JsonProperty("modifier")
    @NotBlank(message = "modifier is mandatory")
    @Pattern(regexp = "^(asc|desc)$", message = "Allowed Values : asc ,desc")
    private String modifier;

    public OrderRequest() {
        // Empty Constructor
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
}
