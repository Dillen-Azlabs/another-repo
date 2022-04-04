package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestimonialImage {

    @JsonProperty("thumbnailUrl")
    private String imageUrl;
    @JsonProperty("thumbnailAltText")
    private String imageAltText;

    public TestimonialImage() {
        //Empty Constructor
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageAltText() {
        return imageAltText;
    }

    public void setImageAltText(String imageAltText) {
        this.imageAltText = imageAltText;
    }
}
