package sg.ihh.ms.sdms.app.model;

/*
//MDStaffProviderAppointmentFacilityTemp class is used to accept the mergeFieldNames and mergeFieldValues as String, which are returned by Database Query
//Next step, mergeFieldNames and mergeFieldValues values are transformed to String[] and pass to MDStaffProviderAppointmentFacility class
*/
public class MDStaffProviderAppointmentFacilityTemp {
	
	private String appointmentId;	
    private String facilityId;
    private String code;
    private String name;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
    //10
    private String telephone;    
    private String fax;
    private String email;
    private String url;
    private String lastUpdated;
    private String lastUpdatedText;
    private String updatedBy;
    private String comments;
    private String country;
    private boolean isArchived;
    //20
    private String uid;    
    private boolean archived;
    private String addressBlock;
	private String mergeFieldNames;
	private String mergeFieldValues;
    private int objectType;
    private String url2;
    private String columnId;
    private String userName;
    private String objectName;
    //30
    private boolean loadExistingObject;    
    private String subType;
    private boolean lazyLoad;
    private String customColumnId;
    private String id;
    private String objectDescription;
    private boolean useCustomFields;
    private String relativeObjectName;
    private boolean isNew;
    private boolean ignoredRequiredFields;
    private boolean isLoaded;

    public MDStaffProviderAppointmentFacilityTemp() {
        // Empty Constructor
    }

    public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
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
	public String getMergeFieldNames() {
		return mergeFieldNames;
	}

	public String getMergeFieldValues() {
		return mergeFieldValues;
	}

	public void setMergeFieldNames(String mergeFieldNames) {
		this.mergeFieldNames = mergeFieldNames;
	}

	public void setMergeFieldValues(String mergeFieldValues) {
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

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isIgnoredRequiredFields() {
        return ignoredRequiredFields;
    }

    public void setIgnoredRequiredFields(boolean ignoredRequiredFields) {
        this.ignoredRequiredFields = ignoredRequiredFields;
    }

    public boolean isIsLoaded() {
        return isLoaded;
    }

    public void setIsLoaded(boolean isLoaded) {
        this.isLoaded = isLoaded;
    }
}
