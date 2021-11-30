
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
public class MDStaffProviderAddressMedicalGroupEntity {

    @JsonProperty("EntityID")
    private String entityID;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ParentEntityID")
    private String parentEntityID;
    @JsonProperty("NPI")
    private String npi;
    @JsonProperty("TaxIDNumber")
    private String taxIDNumber;
    @JsonProperty("MedicareNumber")
    private String medicareNumber;
    @JsonProperty("MedicaidNumber")
    private String medicaidNumber;
    @JsonProperty("InUse")
    private String inUse;
    @JsonProperty("Comments")
    private String comments;
    @JsonProperty("CommentsHtml")
    private String commentsHtml;
    @JsonProperty("LastUpdated")
    private String lastUpdated;
    @JsonProperty("LastUpdatedText")
    private String lastUpdatedText;
    @JsonProperty("UpdatedBy")
    private String updatedBy;
    @JsonProperty("CustomEntityID")
    private String customEntityID;
    @JsonProperty("UseCustomFields")
    private String useCustomFields;
    @JsonProperty("CustomColumn_ID")
    private String customColumnID;
    @JsonProperty("Column_ID")
    private String columnID;
    @JsonProperty("ObjectType")
    private String objectType;
    @JsonProperty("ParentField")
    private String parentField;
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
    @JsonProperty("ID")
    private String id;
    @JsonProperty("ObjectDescription")
    private String objectDescription;
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

    public MDStaffProviderAddressMedicalGroupEntity() {
        // Empty Constructor
    }

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxIDNumber() {
        return taxIDNumber;
    }

    public void setTaxIDNumber(String taxIDNumber) {
        this.taxIDNumber = taxIDNumber;
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

    public String getParentEntityID() {
        return parentEntityID;
    }

    public void setParentEntityID(String parentEntityID) {
        this.parentEntityID = parentEntityID;
    }

    public String getCustomEntityID() {
        return customEntityID;
    }

    public void setCustomEntityID(String customEntityID) {
        this.customEntityID = customEntityID;
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

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getParentField() {
        return parentField;
    }

    public void setParentField(String parentField) {
        this.parentField = parentField;
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
