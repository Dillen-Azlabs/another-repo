
package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

@JsonPropertyOrder({"providerId", "name", "mcrNumber", "specialty"})
public class MDStaffProvider {

    @JsonProperty("mcrNumber")
    private String mcrNumber;
    @JsonProperty("name")
    private String name;
    @JsonProperty("providerId")
    private String providerId;
    @JsonProperty("specialtyId")
    private String specialty;

    public MDStaffProvider() {
        // Empty Constructor
    }

    public String getMcrNumber() {
        return mcrNumber;
    }

    public void setMcrNumber(String mcrNumber) {
        this.mcrNumber = mcrNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

}
