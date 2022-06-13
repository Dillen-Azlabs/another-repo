package sg.ihh.ms.sdms.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "image", "title", "link", "countryOfResidence", "countryOfCare", "publishFlag", "createdDt", "modifiedDt"})
public class HighlightsSearch extends BaseModel {

    @JsonProperty("image")
    private String image;

    @JsonProperty("title")
    private String title;

    @JsonProperty("link")
    private String link;

    @JsonProperty("countryOfResidence")
    private String cor;

    @JsonProperty("countryOfCare")
    private String coc;

    @JsonIgnore
    private int order;

    public HighlightsSearch() {
        // Empty Constructor
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCoc() {
        return coc;
    }

    public void setCoc(String coc) {
        this.coc = coc;
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
