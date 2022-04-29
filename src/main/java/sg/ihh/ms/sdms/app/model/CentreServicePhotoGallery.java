package sg.ihh.ms.sdms.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uid", "languageCode", "sectionIntro", "galleryItems", "publishFlag", "createdDt", "modifiedDt"})
public class CentreServicePhotoGallery extends BaseModel {

    @JsonProperty("sectionIntro")
    private String sectionIntro;
    @JsonProperty("galleryItems")
    private List<CentreServicePhotoGalleryItem> galleryItems;
    @JsonIgnore
    protected int order;

    public CentreServicePhotoGallery() {
    }

    public String getSectionIntro() {
        return sectionIntro;
    }

    public void setSectionIntro(String sectionIntro) {
        this.sectionIntro = sectionIntro;
    }

    public List<CentreServicePhotoGalleryItem> getGalleryItems() {
        return galleryItems;
    }

    public void setGalleryItems(List<CentreServicePhotoGalleryItem> galleryItems) {
        this.galleryItems = galleryItems;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public void setOrder(int order) {
        this.order = order;
    }
}
