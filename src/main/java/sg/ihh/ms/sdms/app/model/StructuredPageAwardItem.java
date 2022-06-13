package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StructuredPageAwardItem {

    @JsonProperty("heading")
    private String heading;
    @JsonProperty("iconUrl")
    private String icon;
    @JsonProperty("description")
    private String description;
    @JsonProperty("order")
    private String displayOrder;

    public StructuredPageAwardItem() {
        // Empty Constructor
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }
}
