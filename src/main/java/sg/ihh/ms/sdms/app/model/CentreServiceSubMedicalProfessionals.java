package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "specialistSectionIntro", "specialists", "specialties", "ahpSectionIntro", "ahps", "serviceProviderTypes", "order", "publishFlag", "createdDt", "modifiedDt"})
public class CentreServiceSubMedicalProfessionals extends BaseModel{

    @JsonProperty("specialistSectionIntro")
    private String specialistSectionIntro;
    @JsonIgnore
    private String specialistListing;
    @JsonIgnore
    private String ahpListing;
    @JsonIgnore
    private boolean displaySpecialist;
    @JsonIgnore
    private boolean displayAhp;
    @JsonProperty("specialists")
    private List<CentreServiceSubMedicalProfessional> specialists;
    @JsonProperty("specialties")
    private List<String> specialties;
    @JsonProperty("ahpSectionIntro")
    private String ahpSectionIntro;
    @JsonProperty("ahps")
    private List<CentreServiceSubMedicalProfessional> ahps;
    @JsonProperty("serviceProviderTypes")
    private List<String> serviceProviderTypes;


    public CentreServiceSubMedicalProfessionals() {
        // empty constructor
    }

    public String getSpecialistSectionIntro() {
        return specialistSectionIntro;
    }

    public void setSpecialistSectionIntro(String specialistSectionIntro) {
        this.specialistSectionIntro = specialistSectionIntro;
    }

    public String getSpecialistListing() {
        return specialistListing;
    }

    public void setSpecialistListing(String specialistListing) {
        this.specialistListing = specialistListing;
    }

    public String getAhpListing() {
        return ahpListing;
    }

    public void setAhpListing(String ahpListing) {
        this.ahpListing = ahpListing;
    }

    public boolean isDisplaySpecialist() {
        return displaySpecialist;
    }

    public void setDisplaySpecialist(boolean displaySpecialist) {
        this.displaySpecialist = displaySpecialist;
    }

    public boolean isDisplayAhp() {
        return displayAhp;
    }

    public void setDisplayAhp(boolean displayAhp) {
        this.displayAhp = displayAhp;
    }

    public List<CentreServiceSubMedicalProfessional> getSpecialists() {
        return specialists;
    }

    public void setSpecialists(List<CentreServiceSubMedicalProfessional> specialists) {
        this.specialists = specialists;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
    }

    public String getAhpSectionIntro() {
        return ahpSectionIntro;
    }

    public void setAhpSectionIntro(String ahpSectionIntro) {
        this.ahpSectionIntro = ahpSectionIntro;
    }

    public List<CentreServiceSubMedicalProfessional> getAhps() {
        return ahps;
    }

    public void setAhps(List<CentreServiceSubMedicalProfessional> ahps) {
        this.ahps = ahps;
    }

    public List<String> getServiceProviderTypes() {
        return serviceProviderTypes;
    }

    public void setServiceProviderTypes(List<String> serviceProviderTypes) {
        this.serviceProviderTypes = serviceProviderTypes;
    }
}
