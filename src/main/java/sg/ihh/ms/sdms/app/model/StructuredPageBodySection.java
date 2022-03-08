package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "content1", "videoUrl", "content2", "buttonLabel1", "buttonUrl1", "button1NewTab", "buttonLabel2", "buttonUrl2", "button2NewTab", "didYouKnowHighlight", "noteHighlight", "downloadHighlight", "order", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredPageBodySection extends BaseModel{

    @JsonProperty("content1")
    private String content1;
    @JsonProperty("videoUrl")
    private String videoUrl;
    @JsonProperty("content2")
    private String content2;
    @JsonProperty("buttonLabel1")
    private String buttonLabel1;
    @JsonProperty("buttonUrl1")
    private String buttonUrl1;
    @JsonProperty("button1NewTab")
    private boolean button1NewTab;
    @JsonProperty("buttonLabel2")
    private String buttonLabel2;
    @JsonProperty("buttonUrl2")
    private String buttonUrl2;
    @JsonProperty("button2NewTab")
    private boolean button2NewTab;
    @JsonProperty("didYouKnowHighlight")
    private String didYouKnowHighlight;
    @JsonProperty("noteHighlight")
    private String noteHighlight;
    @JsonProperty("downloadHighlight")
    private String downloadHighlight;

    public StructuredPageBodySection() {
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

    public String getButtonLabel1() {
        return buttonLabel1;
    }

    public void setButtonLabel1(String buttonLabel1) {
        this.buttonLabel1 = buttonLabel1;
    }

    public String getButtonUrl1() {
        return buttonUrl1;
    }

    public void setButtonUrl1(String buttonUrl1) {
        this.buttonUrl1 = buttonUrl1;
    }

    public boolean isButton1NewTab() {
        return button1NewTab;
    }

    public void setButton1NewTab(boolean button1NewTab) {
        this.button1NewTab = button1NewTab;
    }

    public String getButtonLabel2() {
        return buttonLabel2;
    }

    public void setButtonLabel2(String buttonLabel2) {
        this.buttonLabel2 = buttonLabel2;
    }

    public String getButtonUrl2() {
        return buttonUrl2;
    }

    public void setButtonUrl2(String buttonUrl2) {
        this.buttonUrl2 = buttonUrl2;
    }

    public boolean isButton2NewTab() {
        return button2NewTab;
    }

    public void setButton2NewTab(boolean button2NewTab) {
        this.button2NewTab = button2NewTab;
    }

    public String getDidYouKnowHighlight() {
        return didYouKnowHighlight;
    }

    public void setDidYouKnowHighlight(String didYouKnowHighlight) {
        this.didYouKnowHighlight = didYouKnowHighlight;
    }

    public String getNoteHighlight() {
        return noteHighlight;
    }

    public void setNoteHighlight(String noteHighlight) {
        this.noteHighlight = noteHighlight;
    }

    public String getDownloadHighlight() {
        return downloadHighlight;
    }

    public void setDownloadHighlight(String downloadHighlight) {
        this.downloadHighlight = downloadHighlight;
    }
}
