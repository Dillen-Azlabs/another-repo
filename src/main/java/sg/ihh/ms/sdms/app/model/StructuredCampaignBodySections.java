package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "content1", "videoUrl", "content2", "buttonLabel1", "buttonUrl1", "buttonLabel2", "buttonUrl2", "buttonLabel3", "buttonUrl3", "buttonLabel4", "buttonUrl4", "doctorIntro", "medicalProfessionalItem", "order", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredCampaignBodySections extends BaseModel {
    @JsonProperty("content1")
    private String content1;
    @JsonProperty("videoUrl")
    private String videoUrl;
    @JsonProperty("content2")
    private String content2;
    @JsonProperty("buttonLabel1")
    private String buttonLabel1;
    @JsonProperty("buttonUrl1")
    private String buttonUrl1;
    @JsonProperty("buttonLabel2")
    private String buttonLabel2;
    @JsonProperty("buttonUrl2")
    private String buttonUrl2;
    @JsonProperty("buttonLabel3")
    private String buttonLabel3;
    @JsonProperty("buttonUrl3")
    private String buttonUrl3;
    @JsonProperty("buttonLabel4")
    private String buttonLabel4;
    @JsonProperty("buttonUrl4")
    private String buttonUrl4;
    @JsonProperty("doctorIntro")
    private String participatingDoctorsIntro;
    @JsonProperty("medicalProfessionalItem")
    private List<StructuredCampaignMedicalProfessionalItem> medicalProfessionalItem;

    public StructuredCampaignBodySections() {
        //Empty Constructor
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getButtonLabel1() {
        return buttonLabel1;
    }

    public void setButtonLabel1(String buttonLabel1) {
        this.buttonLabel1 = buttonLabel1;
    }

    public String getButtonUrl1() {
        return buttonUrl1;
    }

    public void setButtonUrl1(String buttonUrl1) {
        this.buttonUrl1 = buttonUrl1;
    }

    public String getButtonLabel2() {
        return buttonLabel2;
    }

    public void setButtonLabel2(String buttonLabel2) {
        this.buttonLabel2 = buttonLabel2;
    }

    public String getButtonUrl2() {
        return buttonUrl2;
    }

    public void setButtonUrl2(String buttonUrl2) {
        this.buttonUrl2 = buttonUrl2;
    }

    public String getButtonLabel3() {
        return buttonLabel3;
    }

    public void setButtonLabel3(String buttonLabel3) {
        this.buttonLabel3 = buttonLabel3;
    }

    public String getButtonUrl3() {
        return buttonUrl3;
    }

    public void setButtonUrl3(String buttonUrl3) {
        this.buttonUrl3 = buttonUrl3;
    }

    public String getButtonLabel4() {
        return buttonLabel4;
    }

    public void setButtonLabel4(String buttonLabel4) {
        this.buttonLabel4 = buttonLabel4;
    }

    public String getButtonUrl4() {
        return buttonUrl4;
    }

    public void setButtonUrl4(String buttonUrl4) {
        this.buttonUrl4 = buttonUrl4;
    }

    public String getParticipatingDoctorsIntro() {
        return participatingDoctorsIntro;
    }

    public void setParticipatingDoctorsIntro(String participatingDoctorsIntro) {
        this.participatingDoctorsIntro = participatingDoctorsIntro;
    }

    public List<StructuredCampaignMedicalProfessionalItem> getMedicalProfessionalItem() {
        return medicalProfessionalItem;
    }

    public void setMedicalProfessionalItem(List<StructuredCampaignMedicalProfessionalItem> medicalProfessionalItem) {
        this.medicalProfessionalItem = medicalProfessionalItem;
    }
}
