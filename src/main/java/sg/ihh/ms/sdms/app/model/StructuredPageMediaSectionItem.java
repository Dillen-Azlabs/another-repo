package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"sectionIntro", "imageUrl", "altText", "title", "description"})
public class StructuredPageMediaSectionItem {

    @JsonProperty("sectionIntro")
    private String sectionIntro;
    @JsonProperty("imageUrl")
    private String image;
    @JsonProperty("altText")
    private String altText;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;

    public StructuredPageMediaSectionItem() {
        // Empty Constructor
    }

    public String getSectionIntro() {
        return sectionIntro;
    }

    public void setSectionIntro(String sectionIntro) {
        this.sectionIntro = sectionIntro;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
