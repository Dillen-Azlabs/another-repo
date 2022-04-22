package sg.ihh.ms.sdms.app.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "name", "address", "helplineTelephoneNumber", "telephoneNumbers", "email", "description", "repName", "repTelephoneNumber", "repEmail", "country", "qrCodeTitle1", "qrCodeImageUrl1", "qrCodeImageAltText1", "qrCodeTitle2", "qrCodeImageUrl2", "qrCodeImageAltText2", "order", "publishFlag", "createdDt", "modifiedDt"})
public class hPac extends BaseModel {

	
	@JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("helplineTelephoneNumber")
    private String helplineTelephoneNumber;
    @JsonProperty("telephoneNumbers")
    private String telephoneNumbers;
    @JsonProperty("email")
    private String email;
    @JsonProperty("description")
    private String description;
    @JsonProperty("repName")
    private String repName;
    @JsonProperty("repTelephoneNumber")
    private String repTelephoneNumber;
    @JsonProperty("repEmail")
    private String repEmail;
    @JsonProperty("country")
    private String country;
    @JsonProperty("qrCodeTitle1")
    private String qrCodeTitle1;
    @JsonProperty("qrCodeImageUrl1")
    private String qrCodeImageUrl1;
    @JsonProperty("qrCodeImageAltText1")
    private String qrCodeImageAltText1;
    @JsonProperty("qrCodeTitle2")
    private String qrCodeTitle2;
    @JsonProperty("qrCodeImageUrl2")
    private String qrCodeImageUrl2;
    @JsonProperty("qrCodeImageAltText2")
    private String qrCodeImageAltText2;

    
    public hPac() {
        // Empty Constructor
    }

    public String getName() {
        return name;
    }

    @ColumnName("name")
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    @ColumnName("address")
    public void setAddress(String address) {
        this.address = address;
    }

    public String getHelplineTelephoneNumber() {
        return helplineTelephoneNumber;
    }

    @ColumnName("helpline_number")
    public void setHelplineTelephoneNumber(String helplineTelephoneNumber) {
        this.helplineTelephoneNumber = helplineTelephoneNumber;
    }

    public String getTelephoneNumbers() {
        return telephoneNumbers;
    }

    @ColumnName("telephone_numbers")
    public void setTelephoneNumbers(String telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    @ColumnName("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    @ColumnName("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getRepName() {
        return repName;
    }

    @ColumnName("rep_name")
    public void setRepName(String repName) {
        this.repName = repName;
    }

    public String getRepTelephoneNumber() {
        return repTelephoneNumber;
    }

    @ColumnName("rep_telephone_number")
    public void setRepTelephoneNumber(String repTelephoneNumber) {
        this.repTelephoneNumber = repTelephoneNumber;
    }

    public String getRepEmail() {
        return repEmail;
    }

    @ColumnName("rep_email")
    public void setRepEmail(String repEmail) {
        this.repEmail = repEmail;
    }

    public String getCountry() {
        return country;
    }

    @ColumnName("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public String getQrCodeTitle1() {
        return qrCodeTitle1;
    }

    @ColumnName("qr_code_title_1")
    public void setQrCodeTitle1(String qrCodeTitle1) {
        this.qrCodeTitle1 = qrCodeTitle1;
    }

    public String getQrCodeImageUrl1() {
        return qrCodeImageUrl1;
    }

    @ColumnName("qr_code_image_url_1")
    public void setQrCodeImageUrl1(String qrCodeImageUrl1) {
        this.qrCodeImageUrl1 = qrCodeImageUrl1;
    }

    public String getQrCodeImageAltText1() {
        return qrCodeImageAltText1;
    }

    @ColumnName("qr_code_image_alt_text_1")
    public void setQrCodeImageAltText1(String qrCodeImageAltText1) {
        this.qrCodeImageAltText1 = qrCodeImageAltText1;
    }

    public String getQrCodeTitle2() {
        return qrCodeTitle2;
    }

    @ColumnName("qr_code_title_2")
    public void setQrCodeTitle2(String qrCodeTitle2) {
        this.qrCodeTitle2 = qrCodeTitle2;
    }

    public String getQrCodeImageUrl2() {
        return qrCodeImageUrl2;
    }

    @ColumnName("qr_code_image_url_2")
    public void setQrCodeImageUrl2(String qrCodeImageUrl2) {
        this.qrCodeImageUrl2 = qrCodeImageUrl2;
    }

    public String getQrCodeImageAltText2() {
        return qrCodeImageAltText2;
    }

    @ColumnName("qr_code_image_alt_text_2")
    public void setQrCodeImageAltText2(String qrCodeImageAltText2) {
        this.qrCodeImageAltText2 = qrCodeImageAltText2;
    }
}
