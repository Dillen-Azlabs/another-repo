
package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "clinicName", "address", "telephoneNumbers", "faxNumbers", "isPrimaryClinic", "order", "publishFlag", "createdDt", "modifiedDt"})
public class Clinic extends BaseModel {

    @JsonProperty("clinicName")
    private String clinicName;
    @JsonProperty("address")
    private String address;
    @JsonProperty("telephoneNumbers")
    private String telephoneNumbers;
    @JsonProperty("faxNumbers")
    private String faxNumbers;
    @JsonProperty("isPrimaryClinic")
    private boolean isPrimaryClinic;

    public Clinic() {
        // Empty Constructor
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @ColumnName("is_primary_clinic")
    public void setPrimaryClinic(boolean primaryClinic) {
        isPrimaryClinic = primaryClinic;
    }
}
