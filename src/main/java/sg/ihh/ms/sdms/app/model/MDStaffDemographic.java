package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({"providerId", "ssn", "firstName", "middleName", "lastName", "suffix", "salutation", "preferredName", "degreeId1", "degreeId2", "degreeId3", "specialityId1", "specialityId2", "specialityId3", "specialityId4", "otherFirstName", "otherMiddleName", "otherLastName", "gender", "maritalStatus", "spaoseName", "birthPlace", "birthDate", "birthDateText", "citizen", "ethnicity", "graduate", "graduateText", "associateTelephone", "associate1", "associate2", "associate3", "associate4", "associate5", "pager", "practice", "taxId", "otherId", "answeringService", "cellPhone", "email", "acceptNewPatient", "acceptMedicare", "medicareNumber", "acceptMedicaId", "medicaIdNumber", "medicalSanction", "upin", "lastUpdated", "lastUpdatedText", "updatedBy", "npi", "notifyBy", "languageId1", "languageId2", "languageId3", "languageId4", "languageId5", "taxonomyId1", "taxonomyId2", "taxonomyId3", "taxonomyId4", "fieldOfLicensureId", "fieldOfLicensureOther", "formattedName", "formattedNameWithDegree", "formalName", "formalNameWithDegree", "comments", "commentsHtml", "customProviderId", "others1", "others2", "pcrc", "cts", "ctsDate", "ctsDateText", "ctsEnd", "ctsEndText", "retired", "deceased", "retiredDate", "retiredDateText", "suspensionDate", "suspensionDateText", "deceasedDate", "deceasedDateText", "suspensionEndDate", "suspensionEndDateText"})
public class MDStaffDemographic {

    @JsonProperty("providerId")
    private String providerId;
    @JsonProperty("ssn")
    private String ssn;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("suffix")
    private String suffix;
    @JsonProperty("salutation")
    private String salutation;
    @JsonProperty("preferredName")
    private String preferredName;
    @JsonProperty("degreeId1")
    private String degreeId1;
    @JsonProperty("degreeId2")
    private String degreeId2;
    @JsonProperty("degreeId3")
    private String degreeId3;
    @JsonProperty("specialityId1")
    private String specialityId1;
    @JsonProperty("specialityId2")
    private String specialityId2;
    @JsonProperty("specialityId3")
    private String specialityId3;
    @JsonProperty("specialityId4")
    private String specialityId4;
    @JsonProperty("otherFirstName")
    private String otherFirstName;
    @JsonProperty("otherMiddleName")
    private String otherMiddleName;
    @JsonProperty("otherLastName")
    private String otherLastName;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("maritalStatus")
    private String maritalStatus;
    @JsonProperty("spaoseName")
    private String spaoseName;
    @JsonProperty("birthPlace")
    private String birthPlace;
    @JsonProperty("birthDate")
    private LocalDateTime birthDate;
    @JsonProperty("birthDateText")
    private String birthDateText;
    @JsonProperty("citizen")
    private String citizen;
    @JsonProperty("ethnicity")
    private String ethnicity;
    @JsonProperty("graduate")
    private String graduate;
    @JsonProperty("graduateText")
    private String graduateText;
    @JsonProperty("associateTelephone")
    private String associateTelephone;
    @JsonProperty("associate1")
    private String associate1;
    @JsonProperty("associate2")
    private String associate2;
    @JsonProperty("associate3")
    private String associate3;
    @JsonProperty("associate4")
    private String associate4;
    @JsonProperty("associate5")
    private String associate5;
    @JsonProperty("pager")
    private String pager;
    @JsonProperty("practice")
    private String practice;
    @JsonProperty("taxId")
    private String taxId;
    @JsonProperty("otherId")
    private String otherId;
    @JsonProperty("answeringService")
    private String answeringService;
    @JsonProperty("cellPhone")
    private String cellPhone;
    @JsonProperty("email")
    private String email;
    @JsonProperty("acceptNewPatient")
    private Integer acceptNewPatient;
    @JsonProperty("acceptMedicare")
    private Integer acceptMedicare;
    @JsonProperty("medicareNumber")
    private String medicareNumber;
    @JsonProperty("acceptMedicaId")
    private Integer acceptMedicaId;
    @JsonProperty("medicaIdNumber")
    private String medicaIdNumber;
    @JsonProperty("medicalSanction")
    private String medicalSanction;
    @JsonProperty("upin")
    private String upin;
    @JsonProperty("lastUpdated")
    private LocalDateTime lastUpdated;
    @JsonProperty("lastUpdatedText")
    private String lastUpdatedText;
    @JsonProperty("updatedBy")
    private String updatedBy;
    @JsonProperty("npi")
    private String npi;
    @JsonProperty("notifyBy")
    private String notifyBy;
    @JsonProperty("languageId1")
    private String languageId1;
    @JsonProperty("languageId2")
    private String languageId2;
    @JsonProperty("languageId3")
    private String languageId3;
    @JsonProperty("languageId4")
    private String languageId4;
    @JsonProperty("languageId5")
    private String languageId5;
    @JsonProperty("taxonomyId1")
    private String taxonomyId1;
    @JsonProperty("taxonomyId2")
    private String taxonomyId2;
    @JsonProperty("taxonomyId3")
    private String taxonomyId3;
    @JsonProperty("taxonomyId4")
    private LocalDateTime taxonomyId4;
    @JsonProperty("fieldOfLicensureId")
    private String fieldOfLicensureId;
    @JsonProperty("fieldOfLicensureOther")
    private String fieldOfLicensureOther;
    @JsonProperty("formattedName")
    private String formattedName;
    @JsonProperty("formattedNameWithDegree")
    private String formattedNameWithDegree;
    @JsonProperty("formalName")
    private String formalName;
    @JsonProperty("formalNameWithDegree")
    private String formalNameWithDegree;
    @JsonProperty("comments")
    private String comments;
    @JsonProperty("commentsHtml")
    private String commentsHtml;
    @JsonProperty("customProviderId")
    private String customProviderId;
    @JsonProperty("others1")
    private String others1;
    @JsonProperty("others2")
    private String others2;
    @JsonProperty("pcrc")
    private Integer pcrc;
    @JsonProperty("cts")
    private Integer cts;
    @JsonProperty("ctsDate")
    private LocalDateTime ctsDate;
    @JsonProperty("ctsDateText")
    private String ctsDateText;
    @JsonProperty("ctsEnd")
    private String ctsEnd;
    @JsonProperty("ctsEndText")
    private String ctsEndText;
    @JsonProperty("retired")
    private Integer retired;
    @JsonProperty("deceased")
    private Integer deceased;
    @JsonProperty("retiredDate")
    private LocalDateTime retiredDate;
    @JsonProperty("retiredDateText")
    private String retiredDateText;
    @JsonProperty("suspensionDate")
    private LocalDateTime suspensionDate;
    @JsonProperty("suspensionDateText")
    private String suspensionDateText;
    @JsonProperty("deceasedDate")
    private LocalDateTime deceasedDate;
    @JsonProperty("deceasedDateText")
    private String deceasedDateText;
    @JsonProperty("suspensionEndDate")
    private LocalDateTime suspensionEndDate;
    @JsonProperty("suspensionEndDateText")
    private String suspensionEndDateText;
    @JsonProperty("clinicalInterest1")
    private String clinicalInterest1;
    @JsonProperty("clinicalInterest2")
    private String clinicalInterest2;
    @JsonProperty("clinicalInterest3")
    private String clinicalInterest3;
    @JsonProperty("clinicalInterest4")
    private String clinicalInterest4;
    @JsonProperty("suspendedReason")
    private String suspendedReason;
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("nationalityobjId")
    private String nationalityobjId;
    @JsonProperty("objectDescription")
    private String objectDescription;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nameWithDegree")
    private String nameWithDegree;
    @JsonProperty("age")
    private String age;
    @JsonProperty("warnings")
    private String warnings;
    @JsonProperty("objectType")
    private String objectType;
    @JsonProperty("columnId")
    private String columnId;
    @JsonProperty("useCustomFields")
    private Integer useCustomFields;
    @JsonProperty("middleInitial")
    private String middleInitial;
    @JsonProperty("nameChanged")
    private Integer nameChanged;
    @JsonProperty("maskedSsn")
    private String maskedSsn;
    @JsonProperty("parentField")
    private String parentField;
    @JsonProperty("columnProviderId")
    private String columnProviderId;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("objectName")
    private String objectName;
    @JsonProperty("loadExistingObject")
    private Integer loadExistingObject;
    @JsonProperty("subType")
    private String subType;
    @JsonProperty("lazyLoad")
    private Integer lazyLoad;
    @JsonProperty("customColumnId")
    private String customColumnId;
    @JsonProperty("id")
    private String id;
    @JsonProperty("relativeObjectName")
    private String relativeObjectName;
    @JsonProperty("isNew")
    private Integer isNew;
    @JsonProperty("ignoreRequiredFields")
    private Integer ignoreRequiredFields;
    @JsonProperty("isLoaded")
    private Integer isLoaded;
    @JsonProperty("createdDt")
    private LocalDateTime createdDt;
    @JsonProperty("modifiedDt")
    private LocalDateTime modifiedDt;

    public MDStaffDemographic() {
        // Empty Constructor
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getDegreeId1() {
        return degreeId1;
    }

    public void setDegreeId1(String degreeId1) {
        this.degreeId1 = degreeId1;
    }

    public String getDegreeId2() {
        return degreeId2;
    }

    public void setDegreeId2(String degreeId2) {
        this.degreeId2 = degreeId2;
    }

    public String getDegreeId3() {
        return degreeId3;
    }

    public void setDegreeId3(String degreeId3) {
        this.degreeId3 = degreeId3;
    }

    public String getSpecialityId1() {
        return specialityId1;
    }

    public void setSpecialityId1(String specialityId1) {
        this.specialityId1 = specialityId1;
    }

    public String getSpecialityId2() {
        return specialityId2;
    }

    public void setSpecialityId2(String specialityId2) {
        this.specialityId2 = specialityId2;
    }

    public String getSpecialityId3() {
        return specialityId3;
    }

    public void setSpecialityId3(String specialityId3) {
        this.specialityId3 = specialityId3;
    }

    public String getSpecialityId4() {
        return specialityId4;
    }

    public void setSpecialityId4(String specialityId4) {
        this.specialityId4 = specialityId4;
    }

    public String getOtherFirstName() {
        return otherFirstName;
    }

    public void setOtherFirstName(String otherFirstName) {
        this.otherFirstName = otherFirstName;
    }

    public String getOtherMiddleName() {
        return otherMiddleName;
    }

    public void setOtherMiddleName(String otherMiddleName) {
        this.otherMiddleName = otherMiddleName;
    }

    public String getOtherLastName() {
        return otherLastName;
    }

    public void setOtherLastName(String otherLastName) {
        this.otherLastName = otherLastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSpaoseName() {
        return spaoseName;
    }

    public void setSpaoseName(String spaoseName) {
        this.spaoseName = spaoseName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDateText() {
        return birthDateText;
    }

    public void setBirthDateText(String birthDateText) {
        this.birthDateText = birthDateText;
    }

    public String getCitizen() {
        return citizen;
    }

    public void setCitizen(String citizen) {
        this.citizen = citizen;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getGraduate() {
        return graduate;
    }

    public void setGraduate(String graduate) {
        this.graduate = graduate;
    }

    public String getGraduateText() {
        return graduateText;
    }

    public void setGraduateText(String graduateText) {
        this.graduateText = graduateText;
    }

    public String getAssociateTelephone() {
        return associateTelephone;
    }

    public void setAssociateTelephone(String associateTelephone) {
        this.associateTelephone = associateTelephone;
    }

    public String getAssociate1() {
        return associate1;
    }

    public void setAssociate1(String associate1) {
        this.associate1 = associate1;
    }

    public String getAssociate2() {
        return associate2;
    }

    public void setAssociate2(String associate2) {
        this.associate2 = associate2;
    }

    public String getAssociate3() {
        return associate3;
    }

    public void setAssociate3(String associate3) {
        this.associate3 = associate3;
    }

    public String getAssociate4() {
        return associate4;
    }

    public void setAssociate4(String associate4) {
        this.associate4 = associate4;
    }

    public String getAssociate5() {
        return associate5;
    }

    public void setAssociate5(String associate5) {
        this.associate5 = associate5;
    }

    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getOtherId() {
        return otherId;
    }

    public void setOtherId(String otherId) {
        this.otherId = otherId;
    }

    public String getAnsweringService() {
        return answeringService;
    }

    public void setAnsweringService(String answeringService) {
        this.answeringService = answeringService;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAcceptNewPatient() {
        return acceptNewPatient;
    }

    public void setAcceptNewPatient(Integer acceptNewPatient) {
        this.acceptNewPatient = acceptNewPatient;
    }

    public Integer getAcceptMedicare() {
        return acceptMedicare;
    }

    public void setAcceptMedicare(Integer acceptMedicare) {
        this.acceptMedicare = acceptMedicare;
    }

    public String getMedicareNumber() {
        return medicareNumber;
    }

    public void setMedicareNumber(String medicareNumber) {
        this.medicareNumber = medicareNumber;
    }

    public Integer getAcceptMedicaId() {
        return acceptMedicaId;
    }

    public void setAcceptMedicaId(Integer acceptMedicaId) {
        this.acceptMedicaId = acceptMedicaId;
    }

    public String getMedicaIdNumber() {
        return medicaIdNumber;
    }

    public void setMedicaIdNumber(String medicaIdNumber) {
        this.medicaIdNumber = medicaIdNumber;
    }

    public String getMedicalSanction() {
        return medicalSanction;
    }

    public void setMedicalSanction(String medicalSanction) {
        this.medicalSanction = medicalSanction;
    }

    public String getUpin() {
        return upin;
    }

    public void setUpin(String upin) {
        this.upin = upin;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
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

    public String getNpi() {
        return npi;
    }

    public void setNpi(String npi) {
        this.npi = npi;
    }

    public String getNotifyBy() {
        return notifyBy;
    }

    public void setNotifyBy(String notifyBy) {
        this.notifyBy = notifyBy;
    }

    public String getLanguageId1() {
        return languageId1;
    }

    public void setLanguageId1(String languageId1) {
        this.languageId1 = languageId1;
    }

    public String getLanguageId2() {
        return languageId2;
    }

    public void setLanguageId2(String languageId2) {
        this.languageId2 = languageId2;
    }

    public String getLanguageId3() {
        return languageId3;
    }

    public void setLanguageId3(String languageId3) {
        this.languageId3 = languageId3;
    }

    public String getLanguageId4() {
        return languageId4;
    }

    public void setLanguageId4(String languageId4) {
        this.languageId4 = languageId4;
    }

    public String getLanguageId5() {
        return languageId5;
    }

    public void setLanguageId5(String languageId5) {
        this.languageId5 = languageId5;
    }

    public String getTaxonomyId1() {
        return taxonomyId1;
    }

    public void setTaxonomyId1(String taxonomyId1) {
        this.taxonomyId1 = taxonomyId1;
    }

    public String getTaxonomyId2() {
        return taxonomyId2;
    }

    public void setTaxonomyId2(String taxonomyId2) {
        this.taxonomyId2 = taxonomyId2;
    }

    public String getTaxonomyId3() {
        return taxonomyId3;
    }

    public void setTaxonomyId3(String taxonomyId3) {
        this.taxonomyId3 = taxonomyId3;
    }

    public LocalDateTime getTaxonomyId4() {
        return taxonomyId4;
    }

    public void setTaxonomyId4(LocalDateTime taxonomyId4) {
        this.taxonomyId4 = taxonomyId4;
    }

    public String getFieldOfLicensureId() {
        return fieldOfLicensureId;
    }

    public void setFieldOfLicensureId(String fieldOfLicensureId) {
        this.fieldOfLicensureId = fieldOfLicensureId;
    }

    public String getFieldOfLicensureOther() {
        return fieldOfLicensureOther;
    }

    public void setFieldOfLicensureOther(String fieldOfLicensureOther) {
        this.fieldOfLicensureOther = fieldOfLicensureOther;
    }

    public String getFormattedName() {
        return formattedName;
    }

    public void setFormattedName(String formattedName) {
        this.formattedName = formattedName;
    }

    public String getFormattedNameWithDegree() {
        return formattedNameWithDegree;
    }

    public void setFormattedNameWithDegree(String formattedNameWithDegree) {
        this.formattedNameWithDegree = formattedNameWithDegree;
    }

    public String getFormalName() {
        return formalName;
    }

    public void setFormalName(String formalName) {
        this.formalName = formalName;
    }

    public String getFormalNameWithDegree() {
        return formalNameWithDegree;
    }

    public void setFormalNameWithDegree(String formalNameWithDegree) {
        this.formalNameWithDegree = formalNameWithDegree;
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

    public String getCustomProviderId() {
        return customProviderId;
    }

    public void setCustomProviderId(String customProviderId) {
        this.customProviderId = customProviderId;
    }

    public String getOthers1() {
        return others1;
    }

    public void setOthers1(String others1) {
        this.others1 = others1;
    }

    public String getOthers2() {
        return others2;
    }

    public void setOthers2(String others2) {
        this.others2 = others2;
    }

    public Integer getPcrc() {
        return pcrc;
    }

    public void setPcrc(Integer pcrc) {
        this.pcrc = pcrc;
    }

    public Integer getCts() {
        return cts;
    }

    public void setCts(Integer cts) {
        this.cts = cts;
    }

    public LocalDateTime getCtsDate() {
        return ctsDate;
    }

    public void setCtsDate(LocalDateTime ctsDate) {
        this.ctsDate = ctsDate;
    }

    public String getCtsDateText() {
        return ctsDateText;
    }

    public void setCtsDateText(String ctsDateText) {
        this.ctsDateText = ctsDateText;
    }

    public String getCtsEnd() {
        return ctsEnd;
    }

    public void setCtsEnd(String ctsEnd) {
        this.ctsEnd = ctsEnd;
    }

    public String getCtsEndText() {
        return ctsEndText;
    }

    public void setCtsEndText(String ctsEndText) {
        this.ctsEndText = ctsEndText;
    }

    public Integer getRetired() {
        return retired;
    }

    public void setRetired(Integer retired) {
        this.retired = retired;
    }

    public Integer getDeceased() {
        return deceased;
    }

    public void setDeceased(Integer deceased) {
        this.deceased = deceased;
    }

    public LocalDateTime getRetiredDate() {
        return retiredDate;
    }

    public void setRetiredDate(LocalDateTime retiredDate) {
        this.retiredDate = retiredDate;
    }

    public String getRetiredDateText() {
        return retiredDateText;
    }

    public void setRetiredDateText(String retiredDateText) {
        this.retiredDateText = retiredDateText;
    }

    public LocalDateTime getSuspensionDate() {
        return suspensionDate;
    }

    public void setSuspensionDate(LocalDateTime suspensionDate) {
        this.suspensionDate = suspensionDate;
    }

    public String getSuspensionDateText() {
        return suspensionDateText;
    }

    public void setSuspensionDateText(String suspensionDateText) {
        this.suspensionDateText = suspensionDateText;
    }

    public LocalDateTime getDeceasedDate() {
        return deceasedDate;
    }

    public void setDeceasedDate(LocalDateTime deceasedDate) {
        this.deceasedDate = deceasedDate;
    }

    public String getDeceasedDateText() {
        return deceasedDateText;
    }

    public void setDeceasedDateText(String deceasedDateText) {
        this.deceasedDateText = deceasedDateText;
    }

    public LocalDateTime getSuspensionEndDate() {
        return suspensionEndDate;
    }

    public void setSuspensionEndDate(LocalDateTime suspensionEndDate) {
        this.suspensionEndDate = suspensionEndDate;
    }

    public String getSuspensionEndDateText() {
        return suspensionEndDateText;
    }

    public void setSuspensionEndDateText(String suspensionEndDateText) {
        this.suspensionEndDateText = suspensionEndDateText;
    }

    public String getClinicalInterest1() {
        return clinicalInterest1;
    }

    public void setClinicalInterest1(String clinicalInterest1) {
        this.clinicalInterest1 = clinicalInterest1;
    }

    public String getClinicalInterest2() {
        return clinicalInterest2;
    }

    public void setClinicalInterest2(String clinicalInterest2) {
        this.clinicalInterest2 = clinicalInterest2;
    }

    public String getClinicalInterest3() {
        return clinicalInterest3;
    }

    public void setClinicalInterest3(String clinicalInterest3) {
        this.clinicalInterest3 = clinicalInterest3;
    }

    public String getClinicalInterest4() {
        return clinicalInterest4;
    }

    public void setClinicalInterest4(String clinicalInterest4) {
        this.clinicalInterest4 = clinicalInterest4;
    }

    public String getSuspendedReason() {
        return suspendedReason;
    }

    public void setSuspendedReason(String suspendedReason) {
        this.suspendedReason = suspendedReason;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationalityobjId() {
        return nationalityobjId;
    }

    public void setNationalityobjId(String nationalityobjId) {
        this.nationalityobjId = nationalityobjId;
    }

    public String getObjectDescription() {
        return objectDescription;
    }

    public void setObjectDescription(String objectDescription) {
        this.objectDescription = objectDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameWithDegree() {
        return nameWithDegree;
    }

    public void setNameWithDegree(String nameWithDegree) {
        this.nameWithDegree = nameWithDegree;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public Integer getUseCustomFields() {
        return useCustomFields;
    }

    public void setUseCustomFields(Integer useCustomFields) {
        this.useCustomFields = useCustomFields;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public Integer getNameChanged() {
        return nameChanged;
    }

    public void setNameChanged(Integer nameChanged) {
        this.nameChanged = nameChanged;
    }

    public String getMaskedSsn() {
        return maskedSsn;
    }

    public void setMaskedSsn(String maskedSsn) {
        this.maskedSsn = maskedSsn;
    }

    public String getParentField() {
        return parentField;
    }

    public void setParentField(String parentField) {
        this.parentField = parentField;
    }

    public String getColumnProviderId() {
        return columnProviderId;
    }

    public void setColumnProviderId(String columnProviderId) {
        this.columnProviderId = columnProviderId;
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

    public Integer getLoadExistingObject() {
        return loadExistingObject;
    }

    public void setLoadExistingObject(Integer loadExistingObject) {
        this.loadExistingObject = loadExistingObject;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public Integer getLazyLoad() {
        return lazyLoad;
    }

    public void setLazyLoad(Integer lazyLoad) {
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

    public String getRelativeObjectName() {
        return relativeObjectName;
    }

    public void setRelativeObjectName(String relativeObjectName) {
        this.relativeObjectName = relativeObjectName;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getIgnoreRequiredFields() {
        return ignoreRequiredFields;
    }

    public void setIgnoreRequiredFields(Integer ignoreRequiredFields) {
        this.ignoreRequiredFields = ignoreRequiredFields;
    }

    public Integer getIsLoaded() {
        return isLoaded;
    }

    public void setIsLoaded(Integer isLoaded) {
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
