package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationSdContact {
    @JsonProperty("header")
    private String contactHeader;
    @JsonProperty("number")
    private String contactNumber;
    @JsonProperty("order")
    private String displayOrder;

    public LocationSdContact() {
        //Empty Constructor
    }

    public String getContactHeader() {
        return contactHeader;
    }

    public void setContactHeader(String contactHeader) {
        this.contactHeader = contactHeader;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }
}
