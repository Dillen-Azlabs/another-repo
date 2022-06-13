package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "pageTitleH1Display", "itemUrl", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ContentHubMainItem extends BaseModel{

    @JsonProperty("pageTitleH1Display")
    private String pageTitle;
    @JsonProperty("itemUrl")
    private String itemUrl;

    public ContentHubMainItem() {
        //Empty Constructor
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

}
