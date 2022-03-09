package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "content1", "videoUrl", "content2", "addCTAUrl", "didYouKnowHighlight", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ContentHubSubBodySection extends BaseModel{

    @JsonProperty("content1")
    private String content1;
    @JsonProperty("videoUrl")
    private String videoUrl;
    @JsonProperty("content2")
    private String content2;
    @JsonProperty("didYouKnowHighlight")
    private String didYouKnowHighlight;

    public ContentHubSubBodySection() {
        //Empty Constructor
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getDidYouKnowHighlight() {
        return didYouKnowHighlight;
    }

    public void setDidYouKnowHighlight(String didYouKnowHighlight) {
        this.didYouKnowHighlight = didYouKnowHighlight;
    }
}
