
package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

@JsonPropertyOrder({"providerId", "name", "specialtyId", "specialty", "createdDt", "modifiedDt"})
public class MDStaffProviderAddress {

    @JsonProperty("AddressID")
    private String addressId;
    @JsonProperty("ProviderID")
    private String providerID;
    @JsonProperty("AddressType")
    private String addressType;
    @JsonProperty("MedicalGroupID")
    private String medicalGroupID;
    @JsonProperty("Address")
    private String address;
    @JsonProperty("Address2")
    private String address2;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("Zip")
    private String zip;
    @JsonProperty("CountyId")
    private String countyId;
    @JsonProperty("CountryId")
    private String countryId;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Telephone")
    private String telephone;
    @JsonProperty("Fax")
    private String fax;
    @JsonProperty("Backline")
    private String backline;
    @JsonProperty("Manager")
    private String manager;
    @JsonProperty("URL")
    private String url;
    @JsonProperty("NPI")
    private String npi;
    @JsonProperty("MedicareNumber")
    private String medicareNumber;
    @JsonProperty("MedicaidNumber")
    private String medicaidNumber;
    @JsonProperty("MondayHours")
    private String mondayHours;
    @JsonProperty("TuesdayHours")
    private String tuesdayHours;
    @JsonProperty("WednesdayHours")
    private String wednesdayHours;
    @JsonProperty("ThursdayHours")
    private String thursdayHours;
    @JsonProperty("FridayHours")
    private String fridayHours;
    @JsonProperty("SaturdayHours")
    private String saturdayHours;
    @JsonProperty("SundayHours")
    private String sundayHours;
    @JsonProperty("TaxID")
    private String taxID;
    @JsonProperty("ReviewDate")
    private String reviewDate;
    @JsonProperty("ReviewDateText")
    private String reviewDateText;
    @JsonProperty("ReviewedBy")
    private String reviewedBy;
    @JsonProperty("NextReviewDate")
    private String nextReviewDate;
    @JsonProperty("NextReviewDateText")
    private String nextReviewDateText;
    @JsonProperty("Comments")
    private String comments;
    @JsonProperty("CommentsHtml")
    private String commentsHtml;
    @JsonProperty("ReviewScore")
    private String reviewScore;
    @JsonProperty("LastUpdated")
    private String lastUpdated;
    @JsonProperty("LastUpdatedText")
    private String lastUpdatedText;
    @JsonProperty("UpdatedBy")
    private String updatedBy;
    @JsonProperty("InUse")
    private String inUse;
    @JsonProperty("IDNumber")
    private String iDNumber;
    @JsonProperty("Location")
    private String location;
    @JsonProperty("PCPLimitID")
    private String pCPLimitID;
    @JsonProperty("MedicaidPanelStatusID")
    private String medicaidPanelStatusID;
    @JsonProperty("CommercialPanelStatusID")
    private String commercialPanelStatusID;
    @JsonProperty("WheelchairAccess")
    private String wheelchairAccess;
    @JsonProperty("StartDate")
    private String startDate;
    @JsonProperty("StartDateText")
    private String startDateText;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("EndDateText")
    private String endDateText;
    @JsonProperty("AccreditationDate")
    private String accreditationDate;
    @JsonProperty("AccreditationDateText")
    private String accreditationDateText;
    @JsonProperty("Publish")
    private String publish;
    @JsonProperty("AgeRangeID")
    private String ageRangeID;
    @JsonProperty("Contact")
    private String contact;
    @JsonProperty("FacilityAssociationID")
    private String facilityAssociationID;
    @JsonProperty("BillingAddress")
    private String billingAddress;
    @JsonProperty("BillingAddress2")
    private String billingAddress2;
    @JsonProperty("BillingCity")
    private String billingCity;
    @JsonProperty("BillingState")
    private String billingState;
    @JsonProperty("BillingZip")
    private String billingZip;
    @JsonProperty("BillingCountyID")
    private String billingCountyID;
    @JsonProperty("BillingCountryID")
    private String billingCountryID;
    @JsonProperty("BillingTelephone")
    private String billingTelephone;
    @JsonProperty("BillingFax")
    private String billingFax;
    @JsonProperty("BillingNPI")
    private String billingNPI;
    @JsonProperty("BillingTaxID")
    private String billingTaxID;
    @JsonProperty("BillingAddressSourceID")
    private String billingAddressSourceID;
    @JsonProperty("BillingEmail")
    private String billingEmail;
    @JsonProperty("BillingURL")
    private String billingURL;
    @JsonProperty("MailingAddress")
    private String mailingAddress;
    @JsonProperty("MailingAddress2")
    private String mailingAddress2;
    @JsonProperty("MailingCity")
    private String mailingCity;
    @JsonProperty("MailingState")
    private String mailingState;
    @JsonProperty("MailingZip")
    private String mailingZip;
    @JsonProperty("MailingCountyID")
    private String mailingCountyID;
    @JsonProperty("MailingCountryID")
    private String mailingCountryID;
    @JsonProperty("MailingTelephone")
    private String mailingTelephone;
    @JsonProperty("MailingFax")
    private String mailingFax;
    @JsonProperty("MailingNPI")
    private String mailingNPI;
    @JsonProperty("MailingTaxID")
    private String mailingTaxID;
    @JsonProperty("MailingAddressSourceID")
    private String mailingAddressSourceID;
    @JsonProperty("MailingEmail")
    private String mailingEmail;
    @JsonProperty("MailingURL")
    private String mailingURL;
    @JsonProperty("CustomAddressID")
    private String customAddressID;
    @JsonProperty("UseCustomFields")
    private String useCustomFields;
    @JsonProperty("ObjectType")
    private String objectType;
    @JsonProperty("Column_ID")
    private String columnID;
    @JsonProperty("ObjectDescription")
    private String objectDescription;
    @JsonProperty("AddressTypeCode")
    private String addressTypeCode;
    @JsonProperty("AddressTypeItem")
    private MDStaffProviderAddressTypeItem addressTypeItem;
    @JsonProperty("SubType")
    private String subType;
    @JsonProperty("MedicalGroup")
    private MDStaffProviderAddressMedicalGroup medicalGroup;
    @JsonProperty("Address1")
    private String address1;
    @JsonProperty("BillingAddressName")
    private String billingAddressName;
    @JsonProperty("BillingAddressID")
    private String billingAddressID;
    @JsonProperty("MailingAddressName")
    private String mailingAddressName;
    @JsonProperty("MailingAddressID")
    private String mailingAddressID;
    @JsonProperty("AddressBlock")
    private String addressBlock;
    @JsonProperty("ParentField")
    private String parentField;
    @JsonProperty("Column_ProviderID")
    private String columnProviderID;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("ObjectName")
    private String objectName;
    @JsonProperty("LoadExistingObject")
    private String loadExistingObject;
    @JsonProperty("LazyLoad")
    private String lazyLoad;
    @JsonProperty("CustomColumn_ID")
    private String customColumnID;
    @JsonProperty("ID")
    private String id;
    @JsonProperty("RelativeObjectName")
    private String relativeObjectName;
    @JsonProperty("IsNew")
    private String isNew;
    @JsonProperty("IgnoreRequiredFields")
    private String ignoreRequiredFields;
    @JsonProperty("IsLoaded")
    private String isLoaded;

    @JsonProperty("createdDt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    protected LocalDateTime createdDt;

    @JsonProperty("modifiedDt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    protected LocalDateTime modifiedDt;

    public MDStaffProviderAddress() {
        // Empty Constructor
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getMedicalGroupID() {
        return medicalGroupID;
    }

    public void setMedicalGroupID(String medicalGroupID) {
        this.medicalGroupID = medicalGroupID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getBackline() {
        return backline;
    }

    public void setBackline(String backline) {
        this.backline = backline;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNpi() {
        return npi;
    }

    public void setNpi(String npi) {
        this.npi = npi;
    }

    public String getMedicareNumber() {
        return medicareNumber;
    }

    public void setMedicareNumber(String medicareNumber) {
        this.medicareNumber = medicareNumber;
    }

    public String getMedicaidNumber() {
        return medicaidNumber;
    }

    public void setMedicaidNumber(String medicaidNumber) {
        this.medicaidNumber = medicaidNumber;
    }

    public String getMondayHours() {
        return mondayHours;
    }

    public void setMondayHours(String mondayHours) {
        this.mondayHours = mondayHours;
    }

    public String getTuesdayHours() {
        return tuesdayHours;
    }

    public void setTuesdayHours(String tuesdayHours) {
        this.tuesdayHours = tuesdayHours;
    }

    public String getWednesdayHours() {
        return wednesdayHours;
    }

    public void setWednesdayHours(String wednesdayHours) {
        this.wednesdayHours = wednesdayHours;
    }

    public String getThursdayHours() {
        return thursdayHours;
    }

    public void setThursdayHours(String thursdayHours) {
        this.thursdayHours = thursdayHours;
    }

    public String getFridayHours() {
        return fridayHours;
    }

    public void setFridayHours(String fridayHours) {
        this.fridayHours = fridayHours;
    }

    public String getSaturdayHours() {
        return saturdayHours;
    }

    public void setSaturdayHours(String saturdayHours) {
        this.saturdayHours = saturdayHours;
    }

    public String getSundayHours() {
        return sundayHours;
    }

    public void setSundayHours(String sundayHours) {
        this.sundayHours = sundayHours;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewDateText() {
        return reviewDateText;
    }

    public void setReviewDateText(String reviewDateText) {
        this.reviewDateText = reviewDateText;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public String getNextReviewDate() {
        return nextReviewDate;
    }

    public void setNextReviewDate(String nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
    }

    public String getNextReviewDateText() {
        return nextReviewDateText;
    }

    public void setNextReviewDateText(String nextReviewDateText) {
        this.nextReviewDateText = nextReviewDateText;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCommentsHtml() {
        return commentsHtml;
    }

    public void setCommentsHtml(String commentsHtml) {
        this.commentsHtml = commentsHtml;
    }

    public String getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(String reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdatedText() {
        return lastUpdatedText;
    }

    public void setLastUpdatedText(String lastUpdatedText) {
        this.lastUpdatedText = lastUpdatedText;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getInUse() {
        return inUse;
    }

    public void setInUse(String inUse) {
        this.inUse = inUse;
    }

    public String getiDNumber() {
        return iDNumber;
    }

    public void setiDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getpCPLimitID() {
        return pCPLimitID;
    }

    public void setpCPLimitID(String pCPLimitID) {
        this.pCPLimitID = pCPLimitID;
    }

    public String getMedicaidPanelStatusID() {
        return medicaidPanelStatusID;
    }

    public void setMedicaidPanelStatusID(String medicaidPanelStatusID) {
        this.medicaidPanelStatusID = medicaidPanelStatusID;
    }

    public String getCommercialPanelStatusID() {
        return commercialPanelStatusID;
    }

    public void setCommercialPanelStatusID(String commercialPanelStatusID) {
        this.commercialPanelStatusID = commercialPanelStatusID;
    }

    public String getWheelchairAccess() {
        return wheelchairAccess;
    }

    public void setWheelchairAccess(String wheelchairAccess) {
        this.wheelchairAccess = wheelchairAccess;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDateText() {
        return startDateText;
    }

    public void setStartDateText(String startDateText) {
        this.startDateText = startDateText;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDateText() {
        return endDateText;
    }

    public void setEndDateText(String endDateText) {
        this.endDateText = endDateText;
    }

    public String getAccreditationDate() {
        return accreditationDate;
    }

    public void setAccreditationDate(String accreditationDate) {
        this.accreditationDate = accreditationDate;
    }

    public String getAccreditationDateText() {
        return accreditationDateText;
    }

    public void setAccreditationDateText(String accreditationDateText) {
        this.accreditationDateText = accreditationDateText;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getAgeRangeID() {
        return ageRangeID;
    }

    public void setAgeRangeID(String ageRangeID) {
        this.ageRangeID = ageRangeID;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFacilityAssociationID() {
        return facilityAssociationID;
    }

    public void setFacilityAssociationID(String facilityAssociationID) {
        this.facilityAssociationID = facilityAssociationID;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingAddress2() {
        return billingAddress2;
    }

    public void setBillingAddress2(String billingAddress2) {
        this.billingAddress2 = billingAddress2;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingZip() {
        return billingZip;
    }

    public void setBillingZip(String billingZip) {
        this.billingZip = billingZip;
    }

    public String getBillingCountyID() {
        return billingCountyID;
    }

    public void setBillingCountyID(String billingCountyID) {
        this.billingCountyID = billingCountyID;
    }

    public String getBillingCountryID() {
        return billingCountryID;
    }

    public void setBillingCountryID(String billingCountryID) {
        this.billingCountryID = billingCountryID;
    }

    public String getBillingTelephone() {
        return billingTelephone;
    }

    public void setBillingTelephone(String billingTelephone) {
        this.billingTelephone = billingTelephone;
    }

    public String getBillingFax() {
        return billingFax;
    }

    public void setBillingFax(String billingFax) {
        this.billingFax = billingFax;
    }

    public String getBillingNPI() {
        return billingNPI;
    }

    public void setBillingNPI(String billingNPI) {
        this.billingNPI = billingNPI;
    }

    public String getBillingTaxID() {
        return billingTaxID;
    }

    public void setBillingTaxID(String billingTaxID) {
        this.billingTaxID = billingTaxID;
    }

    public String getBillingAddressSourceID() {
        return billingAddressSourceID;
    }

    public void setBillingAddressSourceID(String billingAddressSourceID) {
        this.billingAddressSourceID = billingAddressSourceID;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    public String getBillingURL() {
        return billingURL;
    }

    public void setBillingURL(String billingURL) {
        this.billingURL = billingURL;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getMailingAddress2() {
        return mailingAddress2;
    }

    public void setMailingAddress2(String mailingAddress2) {
        this.mailingAddress2 = mailingAddress2;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    public String getMailingState() {
        return mailingState;
    }

    public void setMailingState(String mailingState) {
        this.mailingState = mailingState;
    }

    public String getMailingZip() {
        return mailingZip;
    }

    public void setMailingZip(String mailingZip) {
        this.mailingZip = mailingZip;
    }

    public String getMailingCountyID() {
        return mailingCountyID;
    }

    public void setMailingCountyID(String mailingCountyID) {
        this.mailingCountyID = mailingCountyID;
    }

    public String getMailingCountryID() {
        return mailingCountryID;
    }

    public void setMailingCountryID(String mailingCountryID) {
        this.mailingCountryID = mailingCountryID;
    }

    public String getMailingTelephone() {
        return mailingTelephone;
    }

    public void setMailingTelephone(String mailingTelephone) {
        this.mailingTelephone = mailingTelephone;
    }

    public String getMailingFax() {
        return mailingFax;
    }

    public void setMailingFax(String mailingFax) {
        this.mailingFax = mailingFax;
    }

    public String getMailingNPI() {
        return mailingNPI;
    }

    public void setMailingNPI(String mailingNPI) {
        this.mailingNPI = mailingNPI;
    }

    public String getMailingTaxID() {
        return mailingTaxID;
    }

    public void setMailingTaxID(String mailingTaxID) {
        this.mailingTaxID = mailingTaxID;
    }

    public String getMailingAddressSourceID() {
        return mailingAddressSourceID;
    }

    public void setMailingAddressSourceID(String mailingAddressSourceID) {
        this.mailingAddressSourceID = mailingAddressSourceID;
    }

    public String getMailingEmail() {
        return mailingEmail;
    }

    public void setMailingEmail(String mailingEmail) {
        this.mailingEmail = mailingEmail;
    }

    public String getMailingURL() {
        return mailingURL;
    }

    public void setMailingURL(String mailingURL) {
        this.mailingURL = mailingURL;
    }

    public String getCustomAddressID() {
        return customAddressID;
    }

    public void setCustomAddressID(String customAddressID) {
        this.customAddressID = customAddressID;
    }

    public String getUseCustomFields() {
        return useCustomFields;
    }

    public void setUseCustomFields(String useCustomFields) {
        this.useCustomFields = useCustomFields;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getColumnID() {
        return columnID;
    }

    public void setColumnID(String columnID) {
        this.columnID = columnID;
    }

    public String getObjectDescription() {
        return objectDescription;
    }

    public void setObjectDescription(String objectDescription) {
        this.objectDescription = objectDescription;
    }

    public String getAddressTypeCode() {
        return addressTypeCode;
    }

    public void setAddressTypeCode(String addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
    }

    public MDStaffProviderAddressTypeItem getAddressTypeItem() {
        return addressTypeItem;
    }

    public void setAddressTypeItem(MDStaffProviderAddressTypeItem addressTypeItem) {
        this.addressTypeItem = addressTypeItem;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public MDStaffProviderAddressMedicalGroup getMedicalGroup() {
        return medicalGroup;
    }

    public void setMedicalGroup(MDStaffProviderAddressMedicalGroup medicalGroup) {
        this.medicalGroup = medicalGroup;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getBillingAddressName() {
        return billingAddressName;
    }

    public void setBillingAddressName(String billingAddressName) {
        this.billingAddressName = billingAddressName;
    }

    public String getBillingAddressID() {
        return billingAddressID;
    }

    public void setBillingAddressID(String billingAddressID) {
        this.billingAddressID = billingAddressID;
    }

    public String getMailingAddressName() {
        return mailingAddressName;
    }

    public void setMailingAddressName(String mailingAddressName) {
        this.mailingAddressName = mailingAddressName;
    }

    public String getMailingAddressID() {
        return mailingAddressID;
    }

    public void setMailingAddressID(String mailingAddressID) {
        this.mailingAddressID = mailingAddressID;
    }

    public String getAddressBlock() {
        return addressBlock;
    }

    public void setAddressBlock(String addressBlock) {
        this.addressBlock = addressBlock;
    }

    public String getParentField() {
        return parentField;
    }

    public void setParentField(String parentField) {
        this.parentField = parentField;
    }

    public String getColumnProviderID() {
        return columnProviderID;
    }

    public void setColumnProviderID(String columnProviderID) {
        this.columnProviderID = columnProviderID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getLoadExistingObject() {
        return loadExistingObject;
    }

    public void setLoadExistingObject(String loadExistingObject) {
        this.loadExistingObject = loadExistingObject;
    }

    public String getLazyLoad() {
        return lazyLoad;
    }

    public void setLazyLoad(String lazyLoad) {
        this.lazyLoad = lazyLoad;
    }

    public String getCustomColumnID() {
        return customColumnID;
    }

    public void setCustomColumnID(String customColumnID) {
        this.customColumnID = customColumnID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRelativeObjectName() {
        return relativeObjectName;
    }

    public void setRelativeObjectName(String relativeObjectName) {
        this.relativeObjectName = relativeObjectName;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String getIgnoreRequiredFields() {
        return ignoreRequiredFields;
    }

    public void setIgnoreRequiredFields(String ignoreRequiredFields) {
        this.ignoreRequiredFields = ignoreRequiredFields;
    }

    public String getIsLoaded() {
        return isLoaded;
    }

    public void setIsLoaded(String isLoaded) {
        this.isLoaded = isLoaded;
    }

    public LocalDateTime getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(LocalDateTime createdDt) {
        this.createdDt = createdDt;
    }

    public LocalDateTime getModifiedDt() {
        return modifiedDt;
    }

    public void setModifiedDt(LocalDateTime modifiedDt) {
        this.modifiedDt = modifiedDt;
    }
}
