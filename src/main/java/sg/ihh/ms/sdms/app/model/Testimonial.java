
package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "testimonial", "patientName", "patientAlias", "thumbnailUrl", "thumbnailAltText", "keyQuote", "expiryDate", "order", "publishFlag", "createdDt", "modifiedDt"})
public class Testimonial extends BaseModel {

    @JsonProperty("testimonial")
    private String testimonial;
    @JsonProperty("patientName")
    private String patientName;
    @JsonProperty("patientAlias")
    private String patientAlias;
    @JsonProperty("thumbnailUrl")
    private String thumbnailUrl;
    @JsonProperty("thumbnailAltText")
    private String thumbnailAltText;
    @JsonProperty("keyQuote")
    private String keyQuote;

    public Testimonial() {
        // Empty Constructor
    }

    public String getTestimonial() {
        return testimonial;
    }

    public void setTestimonial(String testimonial) {
        this.testimonial = testimonial;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAlias() {
        return patientAlias;
    }

    public void setPatientAlias(String patientAlias) {
        this.patientAlias = patientAlias;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getThumbnailAltText() {
        return thumbnailAltText;
    }

    public void setThumbnailAltText(String thumbnailAltText) {
        this.thumbnailAltText = thumbnailAltText;
    }

    public String getKeyQuote() {
        return keyQuote;
    }

    public void setKeyQuote(String keyQuote) {
        this.keyQuote = keyQuote;
    }
}
