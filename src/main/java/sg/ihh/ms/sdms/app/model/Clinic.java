
package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "name", "address1", "address2", "city", "state", "postalCode", "telephoneNumbers", "faxNumbers", "primaryClinic", "order", "publishFlag", "createdDt", "modifiedDt"})
public class Clinic extends BaseModel {

    @JsonProperty("name")
    private String name;
    @JsonProperty("address1")
    private String address1;
    @JsonProperty("address2")
    private String address2;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("telephoneNumbers")
    private String telephoneNumbers;
    @JsonProperty("faxNumbers")
    private String faxNumbers;
    @JsonProperty("primaryClinic")
    private boolean isPrimaryClinic;

    public Clinic() {
        // Empty Constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getTelephoneNumbers() {
        return telephoneNumbers;
    }

    @ColumnName("phone_numbers")
    public void setTelephoneNumbers(String telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public String getFaxNumbers() {
        return faxNumbers;
    }

    public void setFaxNumbers(String faxNumbers) {
        this.faxNumbers = faxNumbers;
    }

    public boolean isPrimaryClinic() {
        return isPrimaryClinic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @ColumnName("is_primary_clinic")
    public void setPrimaryClinic(boolean primaryClinic) {
        isPrimaryClinic = primaryClinic;
    }
}
