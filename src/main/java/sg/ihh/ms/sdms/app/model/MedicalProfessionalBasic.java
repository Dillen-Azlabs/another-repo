
package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "displayName", "itemUrl", "mcrNumber", "type", "serviceProviderType", "order", "publishFlag", "createdDt", "modifiedDt"})
public class MedicalProfessionalBasic extends BaseModel {

    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("itemUrl")
    private String itemUrl;
    @JsonProperty("mcrNumber")
    private String mcrNumber;
    @JsonProperty("type")
    private String type;
    @JsonProperty("serviceProviderType")
    private String serviceProviderType;

    public MedicalProfessionalBasic() {
        // Empty Constructor
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getMcrNumber() {
        return mcrNumber;
    }

    public void setMcrNumber(String mcrNumber) {
        this.mcrNumber = mcrNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getServiceProviderType() {
        return serviceProviderType;
    }

    public void setServiceProviderType(String serviceProviderType) {
        this.serviceProviderType = serviceProviderType;
    }
}
