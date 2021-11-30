
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
public class MDStaffProviderAddressTypeItem {

    @JsonProperty("ID")
    private String id;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("SortOrder")
    private String sortOrder;
    @JsonProperty("ReadOnly")
    private String readOnly;
    @JsonProperty("ObjectType")
    private String objectType;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("ObjectName")
    private String objectName;
    @JsonProperty("LoadExistingObject")
    private String loadExistingObject;
    @JsonProperty("SubType")
    private String subType;
    @JsonProperty("LazyLoad")
    private String lazyLoad;
    @JsonProperty("Column_ID")
    private String columnID;
    @JsonProperty("CustomColumn_ID")
    private String customColumnID;
    @JsonProperty("ObjectDescription")
    private String objectDescription;
    @JsonProperty("UseCustomFields")
    private String useCustomFields;
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

    public MDStaffProviderAddressTypeItem() {
        // Empty Constructor
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(String readOnly) {
        this.readOnly = readOnly;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
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
