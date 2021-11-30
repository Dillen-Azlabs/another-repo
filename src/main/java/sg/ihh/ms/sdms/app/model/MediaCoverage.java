
package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "title", "imageUrl", "imageAltText", "summary", "source", "articleDate", "resourceType", "landingUrl", "order", "publishFlag", "createdDt", "modifiedDt"})
public class MediaCoverage extends BaseModel {

    @JsonProperty("title")
    private String title;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("imageAltText")
    private String imageAltText;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("source")
    private String source;
    @JsonProperty("articleDate")
    private String articleDate;
    @JsonProperty("resourceType")
    private String resourceType;
    @JsonProperty("landingUrl")
    private String landingUrl;

    public MediaCoverage() {
        // Empty Constructor
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getLandingUrl() {
        return landingUrl;
    }

    public void setLandingUrl(String landingUrl) {
        this.landingUrl = landingUrl;
    }
}
