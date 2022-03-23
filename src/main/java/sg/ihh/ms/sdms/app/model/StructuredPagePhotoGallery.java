package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "sectionIntro", "galleryItems", "order", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPagePhotoGallery extends BaseModel {

    @JsonProperty("sectionIntro")
    private String sectionIntro;
    @JsonProperty("galleryItems")
    private List<StructuredPagePhotoGalleryItem> galleryItems;

    public StructuredPagePhotoGallery() {
        // Empty Constructor
    }

    public String getSectionIntro() {
        return sectionIntro;
    }

    public void setSectionIntro(String sectionIntro) {
        this.sectionIntro = sectionIntro;
    }

    public List<StructuredPagePhotoGalleryItem> getGalleryItems() {
        return galleryItems;
    }

    public void setGalleryItems(List<StructuredPagePhotoGalleryItem> galleryItems) {
        this.galleryItems = galleryItems;
    }
}
