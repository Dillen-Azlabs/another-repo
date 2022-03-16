package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StructuredPagePhotoGalleryItem {

    @JsonProperty("image")
    private String image;
    @JsonProperty("altText")
    private String imageAltText;
    @JsonProperty("title")
    private String title;
    @JsonProperty("caption")
    private String caption;

    public StructuredPagePhotoGalleryItem() {
        // Empty Constructor
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
