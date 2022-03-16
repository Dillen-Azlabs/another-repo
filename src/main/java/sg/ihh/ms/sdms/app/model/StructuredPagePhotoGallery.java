package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "sectionIntro", "mediaCardItems", "order", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPagePhotoGallery extends BaseModel {

    @JsonProperty("sectionIntro")
    private String sectionIntro;
    @JsonProperty("mediaCardItems")
    private List<StructuredPagePhotoGalleryItem> mediaCardItems;

    public StructuredPagePhotoGallery() {
        // Empty Constructor
    }

    public String getSectionIntro() {
        return sectionIntro;
    }

    public void setSectionIntro(String sectionIntro) {
        this.sectionIntro = sectionIntro;
    }

    public List<StructuredPagePhotoGalleryItem> getMediaCardItems() {
        return mediaCardItems;
    }

    public void setMediaCardItems(List<StructuredPagePhotoGalleryItem> mediaCardItems) {
        this.mediaCardItems = mediaCardItems;
    }
}
