package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode",  "metaCtaValue", "hospital", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ServiceProviderMeta extends BaseModel{

    @JsonProperty("metaCtaValue")
    private String metaCtaValue;
    @JsonProperty("hospital")
    private String hospital;

    public ServiceProviderMeta() {
        //Empty constructor
    }

    public String getMetaCtaValue() {
        return metaCtaValue;
    }

    @ColumnName("meta_cta_value")
    public void setMetaCtaValue(String metaCtaValue) {
        this.metaCtaValue = metaCtaValue;
    }

    public String getHospital() {
        return hospital;
    }

    @ColumnName("hospital")
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
