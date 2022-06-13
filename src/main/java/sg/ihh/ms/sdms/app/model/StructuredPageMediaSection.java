package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "contentImageUrl", "contentImageTitle","contentImageDescription","contentImageButton1Label","contentImageButton1Url","contentImage1OpenInNewTab","contentImageButton2Label","contentImageButton2Url","contentImage2OpenInNewTab","mediaCardItems", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPageMediaSection {

    @JsonProperty("uid")
    private String uid;
    @JsonProperty("languageCode")
    private String languageCode;
    @JsonProperty("contentImageUrl")
    private String contentImage;
    @JsonProperty("contentImageTitle")
    private String contentImageTitle;
    @JsonProperty("contentImageDescription")
    private String contentImageDescription;
    @JsonProperty("contentImageButton1Label")
    private String contentImageButton1Label;
    @JsonProperty("contentImageButton1Url")
    private String contentImageButton1Url;
    @JsonProperty("contentImage1OpenInNewTab")
    private boolean contentImageButton1NewTab;
    @JsonProperty("contentImageButton2Label")
    private String contentImageButton2Label;
    @JsonProperty("contentImageButton2Url")
    private String contentImageButton2Url;
    @JsonProperty("contentImage2OpenInNewTab")
    private boolean contentImageButton2NewTab;
    @JsonProperty("mediaCardItems")
    private List<StructuredPageMediaSectionItem> mediaCardItems;
    @JsonProperty("publishFlag")
    private String publishFlag;
    @JsonProperty("createdDt")
    private String createdDt;
    @JsonProperty("modifiedDt")
    private String modifiedDt;

    public StructuredPageMediaSection() {
        // Empty Constructor
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getContentImage() {
        return contentImage;
    }

    public void setContentImage(String contentImage) {
        this.contentImage = contentImage;
    }

    public String getContentImageTitle() {
        return contentImageTitle;
    }

    public void setContentImageTitle(String contentImageTitle) {
        this.contentImageTitle = contentImageTitle;
    }

    public String getContentImageDescription() {
        return contentImageDescription;
    }

    public void setContentImageDescription(String contentImageDescription) {
        this.contentImageDescription = contentImageDescription;
    }

    public String getContentImageButton1Label() {
        return contentImageButton1Label;
    }

    public void setContentImageButton1Label(String contentImageButton1Label) {
        this.contentImageButton1Label = contentImageButton1Label;
    }

    public String getContentImageButton1Url() {
        return contentImageButton1Url;
    }

    public void setContentImageButton1Url(String contentImageButton1Url) {
        this.contentImageButton1Url = contentImageButton1Url;
    }

    public boolean isContentImageButton1NewTab() {
        return contentImageButton1NewTab;
    }

    public void setContentImageButton1NewTab(boolean contentImageButton1NewTab) {
        this.contentImageButton1NewTab = contentImageButton1NewTab;
    }

    public String getContentImageButton2Label() {
        return contentImageButton2Label;
    }

    public void setContentImageButton2Label(String contentImageButton2Label) {
        this.contentImageButton2Label = contentImageButton2Label;
    }

    public String getContentImageButton2Url() {
        return contentImageButton2Url;
    }

    public void setContentImageButton2Url(String contentImageButton2Url) {
        this.contentImageButton2Url = contentImageButton2Url;
    }

    public boolean isContentImageButton2NewTab() {
        return contentImageButton2NewTab;
    }

    public void setContentImageButton2NewTab(boolean contentImageButton2NewTab) {
        this.contentImageButton2NewTab = contentImageButton2NewTab;
    }

    public List<StructuredPageMediaSectionItem> getMediaCardItems() {
        return mediaCardItems;
    }

    public void setMediaCardItems(List<StructuredPageMediaSectionItem> mediaCardItems) {
        this.mediaCardItems = mediaCardItems;
    }

    public String getPublishFlag() {
        return publishFlag;
    }

    public void setPublishFlag(String publishFlag) {
        this.publishFlag = publishFlag;
    }

    public String getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(String createdDt) {
        this.createdDt = createdDt;
    }

    public String getModifiedDt() {
        return modifiedDt;
    }

    public void setModifiedDt(String modifiedDt) {
        this.modifiedDt = modifiedDt;
    }
}
