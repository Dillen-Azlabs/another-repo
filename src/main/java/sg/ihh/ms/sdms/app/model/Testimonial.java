
package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "testimonial", "patientName", "patientAlias", "patientLocation","images", "thumbnailUrl", "thumbnailAltText", "keyQuote", "expiryDate", "countries", "order", "publishFlag", "createdDt", "modifiedDt"})
public class Testimonial extends BaseModel {

    @JsonProperty("testimonial")
    private String testimonial;
    @JsonProperty("patientName")
    private String patientName;
    @JsonProperty("patientAlias")
    private String patientAlias;
    @JsonProperty("patientLocation")
    private String cor;
    @JsonProperty("images")
    private List<TestimonialImage> images;
    @JsonProperty("keyQuote")
    private String keyQuote;
    @JsonProperty("countries")
    private List<String> countries;

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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<TestimonialImage> getImages() {
        return images;
    }

    public void setImages(List<TestimonialImage> images) {
        this.images = images;
    }

    public String getKeyQuote() {
        return keyQuote;
    }

    public void setKeyQuote(String keyQuote) {
        this.keyQuote = keyQuote;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }
}
