package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({"FacilityID", "Code", "Name", "Address","Address2","City","State","Zip","Telephone","Fax",
				"Email", "URL", "LastUpdated", "LastUpdatedText","UpdatedBy","Comments","Country","IsArchived","Uid","Archived",
				"AddressBlock", "MergeFieldNames", "MergeFieldValues", "ObjectType", "Url2","Column_ID","UserName","ObjectName","LoadExistingObject","SubType",
				"LazyLoad","CustomColumn_ID", "ID", "ObjectDescription", "UseCustomFields","RelativeObjectName","IsNew","IgnoredRequiredFields","IsLoaded"})

public class MDStaffProviderAppointmentFacility {
    
    @JsonProperty("FacilityID")
    private String facilityId;

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Name")
    private String name;

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

    @JsonProperty("Telephone")
    private String telephone;

    //10
    @JsonProperty("Fax")
    private String fax;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("URL")
    private String url;

    @JsonProperty("LastUpdated")
    private String lastUpdated;

    @JsonProperty("LastUpdatedText")
    private String lastUpdatedText;

    @JsonProperty("UpdatedBy")
    private String updatedBy;

    @JsonProperty("Comments")
    private String comments;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("IsArchived")
    private boolean isArchived;

    @JsonProperty("Uid")
    private String uid;

    //20
    @JsonProperty("Archived")
    private boolean archived;

    @JsonProperty("AddressBlock")
    private String addressBlock;

	@JsonProperty("MergeFieldNames")
    private String[] mergeFieldNames;	
	
	@JsonProperty("MergeFieldValues")
    private String[] mergeFieldValues;
    
    @JsonProperty("ObjectType")
    private int objectType;

    @JsonProperty("Url2")
    private String url2;

    @JsonProperty("Column_ID")
    private String columnId;

    @JsonProperty("UserName")
    private String userName;

    @JsonProperty("ObjectName")
    private String objectName;

    @JsonProperty("LoadExistingObject")
    private boolean loadExistingObject;

    @JsonProperty("SubType")
    private String subType;

    //30
    @JsonProperty("LazyLoad")
    private boolean lazyLoad;

    @JsonProperty("CustomColumn_ID")
    private String customColumnId;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("ObjectDescription")
    private String objectDescription;

    @JsonProperty("UseCustomFields")
    private boolean useCustomFields;

    @JsonProperty("RelativeObjectName")
    private String relativeObjectName;

    @JsonProperty("IsNew")
    private boolean isNew;

    @JsonProperty("IgnoredRequiredFields")
    private boolean ignoredRequiredFields;

    @JsonProperty("IsLoaded")
    private boolean isLoaded;

    public MDStaffProviderAppointmentFacility() {
        // Empty Constructor
    }
    
    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isIsArchived() {
        return isArchived;
    }

    public void setIsArchived(boolean isArchived) {
        this.isArchived = isArchived;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getAddressBlock() {
        return addressBlock;
    }

    public void setAddressBlock(String addressBlock) {
        this.addressBlock = addressBlock;
    }    

	public String[] getMergeFieldNames() {
		return mergeFieldNames;
	}

	public String[] getMergeFieldValues() {
		return mergeFieldValues;
	}	
	 
	public void setMergeFieldNames(String[] mergeFieldNames) {
		this.mergeFieldNames = mergeFieldNames;
	}

	public void setMergeFieldValues(String[] mergeFieldValues) {
		this.mergeFieldValues = mergeFieldValues;
	}

    public int getObjectType() {
        return objectType;
    }

    public void setObjectType(int objectType) {
        this.objectType = objectType;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
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

    public boolean isLoadExistingObject() {
        return loadExistingObject;
    }

    public void setLoadExistingObject(boolean loadExistingObject) {
        this.loadExistingObject = loadExistingObject;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public boolean isLazyLoad() {
        return lazyLoad;
    }

    public void setLazyLoad(boolean lazyLoad) {
        this.lazyLoad = lazyLoad;
    }

    public String getCustomColumnId() {
        return customColumnId;
    }

    public void setCustomColumnId(String customColumnId) {
        this.customColumnId = customColumnId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjectDescription() {
        return objectDescription;
    }

    public void setObjectDescription(String objectDescription) {
        this.objectDescription = objectDescription;
    }

    public boolean isUseCustomFields() {
        return useCustomFields;
    }

    public void setUseCustomFields(boolean useCustomFields) {
        this.useCustomFields = useCustomFields;
    }

    public String getRelativeObjectName() {
        return relativeObjectName;
    }

    public void setRelativeObjectName(String relativeObjectName) {
        this.relativeObjectName = relativeObjectName;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isIgnoredRequiredFields() {
        return ignoredRequiredFields;
    }

    public void setIgnoredRequiredFields(boolean ignoredRequiredFields) {
        this.ignoredRequiredFields = ignoredRequiredFields;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean isLoaded) {
        this.isLoaded = isLoaded;
    }
}
