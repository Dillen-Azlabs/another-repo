package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CentreServicePhotoGalleryItem {

    @JsonProperty("imageUrl")
    private String image;

    @JsonProperty("altText")
    private String imageAltText;

    @JsonProperty("caption")
    private String caption;
    @JsonProperty("order")
    private String displayOrder;

    public CentreServicePhotoGalleryItem() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageAltText() {
        return imageAltText;
    }

    public void setImageAltText(String imageAltText) {
        this.imageAltText = imageAltText;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }
}
