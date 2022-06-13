package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "iconImage", "header", "anchorID", "content", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ContentHubMainIconContent extends BaseModel{

    @JsonProperty("iconImage")
    private String iconImage;
    @JsonProperty("header")
    private String header;
    @JsonProperty("anchorID")
    private String anchorID;
    @JsonProperty("content")
    private String content;

    public ContentHubMainIconContent() {
        //Empty Constructor
    }

    public String getIconImage() {
        return iconImage;
    }

    public void setIconImage(String iconImage) {
        this.iconImage = iconImage;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getAnchorID() {
        return anchorID;
    }

    public void setAnchorID(String anchorID) {
        this.anchorID = anchorID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
