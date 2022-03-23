package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "sectionIntro", "galleryItems", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPagePhotoGallery {

    @JsonProperty("uid")
    private String uid;
    @JsonProperty("languageCode")
    private String languageCode;
    @JsonProperty("sectionIntro")
    private String photoSectionIntro;
    @JsonProperty("galleryItems")
    private List<StructuredPagePhotoGalleryItem> galleryItems;
    @JsonProperty("publishFlag")
    private String publishFlag;
    @JsonProperty("createdDt")
    private String createdDt;
    @JsonProperty("modifiedDt")
    private String modifiedDt;

    public StructuredPagePhotoGallery() {
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

    public String getPhotoSectionIntro() {
        return photoSectionIntro;
    }

    public void setPhotoSectionIntro(String photoSectionIntro) {
        this.photoSectionIntro = photoSectionIntro;
    }

    public List<StructuredPagePhotoGalleryItem> getGalleryItems() {
        return galleryItems;
    }

    public void setGalleryItems(List<StructuredPagePhotoGalleryItem> galleryItems) {
        this.galleryItems = galleryItems;
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
