package sg.ihh.ms.sdms.app.model;
/*
// MDStaffProviderAppointmentTemp class is used to accept the Warning value as String, which is returned by Database Query
// Next step, Warning String value is transformed to String[] and pass to MDStaffProviderAppointment class
 */

public class MDStaffProviderAppointmentTemp {
	
 	public MDStaffProviderAppointmentTemp() {
 		
 		//Empty constructor
 	}

    private String appointmentId;
    private String providerId;
    private String facilityId;
    private String primaryAddressId;
    private String secondaryAddressId;
    private String mailingAddressId;
    private String reportAddressId;
    private String billingAddressId;
    private String campusAddressId;
    //10
    private String appointmentAddressId;    
    private String initialAppointment;
    private String initialAppointmentText;
    private String lastAppointment;
    private String lastAppointmentText;
    private String nextAppointment;
    private String nextAppointmentText;
    private String resigned;
    private String resignedText;
    private String advancement1;
    //20
    private String advancement1Text;
    private String advancement2;
    private String advancement2Text;
    private String applicationTypeId;
    private String applicationStatusId;
    private String departmentId_1;
    private String departmentId_2;
    private String departmentId_3;
    private String divisionId;
    private String divisionId_2;
    //30
    private String divisionId_3;
    private String sectionId;
    private String sectionId_2;
    private String sectionId_3;
    private String statusId;
    private String staffTypeId;
    private String privilegeClassId;
    private String corporateStatusId;
    private String drgAttestation;
    private String drgAttestationText;
    //40
    private boolean dueAmount;
    private String duePaid;
    private String duePaidText;
    private String misc1;
    private String misc2;
    private String misc3;
    private boolean misc4;
    private String misc5;
    private String misc1Date;
    private String misc1DateText;
    //50
    private String misc2Date;
    private String misc2DateText;
    private String misc3Date;
    private boolean misc3DateText;
    private String misc4Date;
    private String misc4DateText;
    private String misc5Date;
    private String misc5DateText;
    private String otherID;
    private String iDNumber;
    //60
    private String proctor;
    private String proctorRemovedDate;
    private String proctorRemovedDateText;
    private String qaNumber;
    private String tempPrivilegeDate;
    private String tempPrivilegeDateText;
    private String applicationSent;
    private String applicationSentText;
    private String applicationReceived;    
    private String applicationReceivedText;
    //70
    private String boardApproved;
    private String boardApprovedText;
    private String medicalExecutiveCommitteeApproval;
    private String medicalExecutiveCommitteeApprovalText;
    private String credentialsCommitteeApproval;
    private String credentialsCommitteeApprovalText;
    private String resignReason;
    private String title;
    private String parkingNumber;
    private String parkingPermit;
    //80
    private String mailbox;
    private String voting;
    private String applicationProcessed;
    private String applicationProcessedText;
    private String disciplinaryActionComment;
    private String lastUpdated;
    private String lastUpdatedText;
    private String updatedBy;
    private String assignedTo;
    private String dateAssigned;
    //90
    private String dateAssignedText;    
    private boolean credentialingComplete;
    private boolean onStaff;
    private boolean archived;
    private boolean disciplinaryAction;
    private boolean takesERCall;
    private boolean admittingPrivileges;
    private boolean onTheWeb;
    private boolean syncWithMainframe;
    private String notes;
    //100
    private String notesHtml;
    private String lOAExpires;
    private String lOAExpiresText;
    private String anticipatedStartDate;
    private String anticipatedStartDateText;
    private String preApplicationReceived;
    private String preApplicationReceivedText;
    private String preApplicationSent;
    private String preApplicationSentText;
    private boolean pCP;
    //110
    private String applicationReasonId;
    private String oPPEDate;
    private String oPPEDateText;
    private String reappointmentPacketSent;
    private String reappointmentPacketSentText;
    private String reappointmentApplicationReceived;
    private String reappointmentApplicationReceivedText;
    private boolean physicianOrdering;
    private boolean electronicSignature;
    private String fPPEDate;
    //120
    private String fPPEDateText;
    private String hospitalBasedId;
    private String contractStatusId;
    private String executiveOrder;
    private String executiveOrderText;
    private boolean attending;
    private String iDNumberGroupId;
    private String contractDate;    
    private String contractDateText;
    private String contractExpired;
    //130
    private String contractExpiredText;
    private boolean suspended;
    private String categoryId;
    private boolean isEmployed;
    private boolean isPrimary;
    private String specialtyId_1;
    private String taxonomyId_1;
    private String boardCertificationId_1;
    private String specialtyCertificationStatusId_1;
    private String specialtyId_2;
    //140
    private String taxonomyId_2;
    private String boardCertificationId_2;
    private String specialtyCertificationStatusId_2;
    private String specialtyId_3;
    private String taxonomyId_3;
    private String boardCertificationId_3;
    private String specialtyCertificationStatusId_3;
    private String specialtyId_4;
    private String taxonomyId_4;
    private String boardCertificationId_4;
    //150
    private String specialtyCertificationStatusId_4;
    private String customAppointmentId;
    private boolean autoSavedHistory;
    private boolean unSuspendedPrivileges;
    private String warnings;
    private int objectType;
    private String column_Id;
    private boolean useCustomFields;
    private String facilityName;
    private MDStaffProviderAppointmentFacility facility;
    private String department1Description;
    //160
    private String department2Description;
    private String department3Description;
    private String statusDescription;    
    private String corporateStatusDescription;
    private String parentField;
    private String column_ProviderId;
    private String userName;
    private String objectName;
    private boolean loadExistingObject;
    private String subType;
    //170
    private boolean lazyLoad;
    private String customColumn_Id;
    private String iD;
    private String objectDescription;
    private String relativeObjectName;    
    private boolean isNew;    
    private boolean ignoreRequiredFields;
    private boolean isLoaded;

	public String getAppointmentId() {
		return appointmentId;
	}

	public String getProviderId() {
		return providerId;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public String getPrimaryAddressId() {
		return primaryAddressId;
	}

	public String getSecondaryAddressId() {
		return secondaryAddressId;
	}

	public String getMailingAddressId() {
		return mailingAddressId;
	}

	public String getReportAddressId() {
		return reportAddressId;
	}

	public String getBillingAddressId() {
		return billingAddressId;
	}

	public String getCampusAddressId() {
		return campusAddressId;
	}

	public String getAppointmentAddressId() {
		return appointmentAddressId;
	}

	public String getInitialAppointment() {
		return initialAppointment;
	}

	public String getInitialAppointmentText() {
		return initialAppointmentText;
	}

	public String getLastAppointment() {
		return lastAppointment;
	}

	public String getLastAppointmentText() {
		return lastAppointmentText;
	}

	public String getNextAppointment() {
		return nextAppointment;
	}

	public String getNextAppointmentText() {
		return nextAppointmentText;
	}

	public String getResigned() {
		return resigned;
	}

	public String getResignedText() {
		return resignedText;
	}

	public String getAdvancement1() {
		return advancement1;
	}

	public String getAdvancement1Text() {
		return advancement1Text;
	}

	public String getAdvancement2() {
		return advancement2;
	}

	public String getAdvancement2Text() {
		return advancement2Text;
	}

	public String getApplicationTypeId() {
		return applicationTypeId;
	}

	public String getApplicationStatusId() {
		return applicationStatusId;
	}

	public String getDepartmentId_1() {
		return departmentId_1;
	}

	public String getDepartmentId_2() {
		return departmentId_2;
	}

	public String getDepartmentId_3() {
		return departmentId_3;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public String getDivisionId_2() {
		return divisionId_2;
	}

	public String getDivisionId_3() {
		return divisionId_3;
	}

	public String getSectionId() {
		return sectionId;
	}

	public String getSectionId_2() {
		return sectionId_2;
	}

	public String getSectionId_3() {
		return sectionId_3;
	}

	public String getStatusId() {
		return statusId;
	}

	public String getStaffTypeId() {
		return staffTypeId;
	}

	public String getPrivilegeClassId() {
		return privilegeClassId;
	}

	public String getCorporateStatusId() {
		return corporateStatusId;
	}

	public String getDrgAttestation() {
		return drgAttestation;
	}

	public String getDrgAttestationText() {
		return drgAttestationText;
	}

	public boolean isDueAmount() {
		return dueAmount;
	}

	public String getDuePaid() {
		return duePaid;
	}

	public String getDuePaidText() {
		return duePaidText;
	}

	public String getMisc1() {
		return misc1;
	}

	public String getMisc2() {
		return misc2;
	}

	public String getMisc3() {
		return misc3;
	}

	public boolean isMisc4() {
		return misc4;
	}

	public String getMisc5() {
		return misc5;
	}

	public String getMisc1Date() {
		return misc1Date;
	}

	public String getMisc1DateText() {
		return misc1DateText;
	}

	public String getMisc2Date() {
		return misc2Date;
	}

	public String getMisc2DateText() {
		return misc2DateText;
	}

	public String getMisc3Date() {
		return misc3Date;
	}

	public boolean isMisc3DateText() {
		return misc3DateText;
	}

	public String getMisc4Date() {
		return misc4Date;
	}

	public String getMisc4DateText() {
		return misc4DateText;
	}

	public String getMisc5Date() {
		return misc5Date;
	}

	public String getMisc5DateText() {
		return misc5DateText;
	}

	public String getOtherID() {
		return otherID;
	}

	public String getiDNumber() {
		return iDNumber;
	}

	public String getProctor() {
		return proctor;
	}

	public String getProctorRemovedDate() {
		return proctorRemovedDate;
	}

	public String getProctorRemovedDateText() {
		return proctorRemovedDateText;
	}

	public String getQaNumber() {
		return qaNumber;
	}

	public String getTempPrivilegeDate() {
		return tempPrivilegeDate;
	}

	public String getTempPrivilegeDateText() {
		return tempPrivilegeDateText;
	}

	public String getApplicationSent() {
		return applicationSent;
	}

	public String getApplicationSentText() {
		return applicationSentText;
	}

	public String getApplicationReceived() {
		return applicationReceived;
	}

	public String getApplicationReceivedText() {
		return applicationReceivedText;
	}

	public String getBoardApproved() {
		return boardApproved;
	}

	public String getBoardApprovedText() {
		return boardApprovedText;
	}

	public String getMedicalExecutiveCommitteeApproval() {
		return medicalExecutiveCommitteeApproval;
	}

	public String getMedicalExecutiveCommitteeApprovalText() {
		return medicalExecutiveCommitteeApprovalText;
	}

	public String getCredentialsCommitteeApproval() {
		return credentialsCommitteeApproval;
	}

	public String getCredentialsCommitteeApprovalText() {
		return credentialsCommitteeApprovalText;
	}

	public String getResignReason() {
		return resignReason;
	}

	public String getTitle() {
		return title;
	}

	public String getParkingNumber() {
		return parkingNumber;
	}

	public String getParkingPermit() {
		return parkingPermit;
	}

	public String getMailbox() {
		return mailbox;
	}

	public String getVoting() {
		return voting;
	}

	public String getApplicationProcessed() {
		return applicationProcessed;
	}

	public String getApplicationProcessedText() {
		return applicationProcessedText;
	}

	public String getDisciplinaryActionComment() {
		return disciplinaryActionComment;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public String getLastUpdatedText() {
		return lastUpdatedText;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public String getDateAssigned() {
		return dateAssigned;
	}

	public String getDateAssignedText() {
		return dateAssignedText;
	}

	public boolean isCredentialingComplete() {
		return credentialingComplete;
	}

	public boolean isOnStaff() {
		return onStaff;
	}

	public boolean isArchived() {
		return archived;
	}

	public boolean isDisciplinaryAction() {
		return disciplinaryAction;
	}

	public boolean isTakesERCall() {
		return takesERCall;
	}

	public boolean isAdmittingPrivileges() {
		return admittingPrivileges;
	}

	public boolean isOnTheWeb() {
		return onTheWeb;
	}

	public boolean isSyncWithMainframe() {
		return syncWithMainframe;
	}

	public String getNotes() {
		return notes;
	}

	public String getNotesHtml() {
		return notesHtml;
	}

	public String getlOAExpires() {
		return lOAExpires;
	}

	public String getlOAExpiresText() {
		return lOAExpiresText;
	}

	public String getAnticipatedStartDate() {
		return anticipatedStartDate;
	}

	public String getAnticipatedStartDateText() {
		return anticipatedStartDateText;
	}

	public String getPreApplicationReceived() {
		return preApplicationReceived;
	}

	public String getPreApplicationReceivedText() {
		return preApplicationReceivedText;
	}

	public String getPreApplicationSent() {
		return preApplicationSent;
	}

	public String getPreApplicationSentText() {
		return preApplicationSentText;
	}

	public boolean ispCP() {
		return pCP;
	}

	public String getApplicationReasonId() {
		return applicationReasonId;
	}

	public String getoPPEDate() {
		return oPPEDate;
	}

	public String getoPPEDateText() {
		return oPPEDateText;
	}

	public String getReappointmentPacketSent() {
		return reappointmentPacketSent;
	}

	public String getReappointmentPacketSentText() {
		return reappointmentPacketSentText;
	}

	public String getReappointmentApplicationReceived() {
		return reappointmentApplicationReceived;
	}

	public String getReappointmentApplicationReceivedText() {
		return reappointmentApplicationReceivedText;
	}

	public boolean isPhysicianOrdering() {
		return physicianOrdering;
	}

	public boolean isElectronicSignature() {
		return electronicSignature;
	}

	public String getfPPEDate() {
		return fPPEDate;
	}

	public String getfPPEDateText() {
		return fPPEDateText;
	}

	public String getHospitalBasedId() {
		return hospitalBasedId;
	}

	public String getContractStatusId() {
		return contractStatusId;
	}

	public String getExecutiveOrder() {
		return executiveOrder;
	}

	public String getExecutiveOrderText() {
		return executiveOrderText;
	}

	public boolean isAttending() {
		return attending;
	}

	public String getiDNumberGroupId() {
		return iDNumberGroupId;
	}

	public String getContractDate() {
		return contractDate;
	}

	public String getContractDateText() {
		return contractDateText;
	}

	public String getContractExpired() {
		return contractExpired;
	}

	public String getContractExpiredText() {
		return contractExpiredText;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public String getCategoryId() {
		return categoryId;
	}
	

    public boolean isIsEmployed() {
		return isEmployed;
	}


	public boolean isIsPrimary() {
		return isPrimary;
	}

	public String getSpecialtyId_1() {
		return specialtyId_1;
	}

	public String getTaxonomyId_1() {
		return taxonomyId_1;
	}

	public String getBoardCertificationId_1() {
		return boardCertificationId_1;
	}

	public String getSpecialtyCertificationStatusId_1() {
		return specialtyCertificationStatusId_1;
	}

	public String getSpecialtyId_2() {
		return specialtyId_2;
	}

	public String getTaxonomyId_2() {
		return taxonomyId_2;
	}

	public String getBoardCertificationId_2() {
		return boardCertificationId_2;
	}

	public String getSpecialtyCertificationStatusId_2() {
		return specialtyCertificationStatusId_2;
	}

	public String getSpecialtyId_3() {
		return specialtyId_3;
	}

	public String getTaxonomyId_3() {
		return taxonomyId_3;
	}

	public String getBoardCertificationId_3() {
		return boardCertificationId_3;
	}

	public String getSpecialtyCertificationStatusId_3() {
		return specialtyCertificationStatusId_3;
	}

	public String getSpecialtyId_4() {
		return specialtyId_4;
	}

	public String getTaxonomyId_4() {
		return taxonomyId_4;
	}

	public String getBoardCertificationId_4() {
		return boardCertificationId_4;
	}

	public String getSpecialtyCertificationStatusId_4() {
		return specialtyCertificationStatusId_4;
	}

	public String getCustomAppointmentId() {
		return customAppointmentId;
	}

	public boolean isAutoSavedHistory() {
		return autoSavedHistory;
	}

	public boolean isUnSuspendedPrivileges() {
		return unSuspendedPrivileges;
	}

	public int getObjectType() {
		return objectType;
	}

	public String getColumn_Id() {
		return column_Id;
	}

	public boolean isUseCustomFields() {
		return useCustomFields;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public MDStaffProviderAppointmentFacility getFacility() {
		return facility;
	}

	public String getDepartment1Description() {
		return department1Description;
	}

	public String getDepartment2Description() {
		return department2Description;
	}

	public String getDepartment3Description() {
		return department3Description;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public String getCorporateStatusDescription() {
		return corporateStatusDescription;
	}

	public String getParentField() {
		return parentField;
	}

	public String getColumn_ProviderId() {
		return column_ProviderId;
	}

	public String getUserName() {
		return userName;
	}

	public String getObjectName() {
		return objectName;
	}

	public boolean isLoadExistingObject() {
		return loadExistingObject;
	}

	public String getSubType() {
		return subType;
	}

	public boolean isLazyLoad() {
		return lazyLoad;
	}

	public String getCustomColumn_Id() {
		return customColumn_Id;
	}

	public String getiD() {
		return iD;
	}

	public String getObjectDescription() {
		return objectDescription;
	}

	public String getRelativeObjectName() {
		return relativeObjectName;
	}

	public boolean isIsNew() {
		return isNew;
	}

	public boolean isIgnoreRequiredFields() {
		return ignoreRequiredFields;
	}

	public boolean isIsLoaded() {
		return isLoaded;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public void setPrimaryAddressId(String primaryAddressId) {
		this.primaryAddressId = primaryAddressId;
	}

	public void setSecondaryAddressId(String secondaryAddressId) {
		this.secondaryAddressId = secondaryAddressId;
	}

	public void setMailingAddressId(String mailingAddressId) {
		this.mailingAddressId = mailingAddressId;
	}

	public void setReportAddressId(String reportAddressId) {
		this.reportAddressId = reportAddressId;
	}

	public void setBillingAddressId(String billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public void setCampusAddressId(String campusAddressId) {
		this.campusAddressId = campusAddressId;
	}

	public void setAppointmentAddressId(String appointmentAddressId) {
		this.appointmentAddressId = appointmentAddressId;
	}

	public void setInitialAppointment(String initialAppointment) {
		this.initialAppointment = initialAppointment;
	}

	public void setInitialAppointmentText(String initialAppointmentText) {
		this.initialAppointmentText = initialAppointmentText;
	}

	public void setLastAppointment(String lastAppointment) {
		this.lastAppointment = lastAppointment;
	}

	public void setLastAppointmentText(String lastAppointmentText) {
		this.lastAppointmentText = lastAppointmentText;
	}

	public void setNextAppointment(String nextAppointment) {
		this.nextAppointment = nextAppointment;
	}

	public void setNextAppointmentText(String nextAppointmentText) {
		this.nextAppointmentText = nextAppointmentText;
	}

	public void setResigned(String resigned) {
		this.resigned = resigned;
	}

	public void setResignedText(String resignedText) {
		this.resignedText = resignedText;
	}

	public void setAdvancement1(String advancement1) {
		this.advancement1 = advancement1;
	}

	public void setAdvancement1Text(String advancement1Text) {
		this.advancement1Text = advancement1Text;
	}

	public void setAdvancement2(String advancement2) {
		this.advancement2 = advancement2;
	}

	public void setAdvancement2Text(String advancement2Text) {
		this.advancement2Text = advancement2Text;
	}

	public void setApplicationTypeId(String applicationTypeId) {
		this.applicationTypeId = applicationTypeId;
	}

	public void setApplicationStatusId(String applicationStatusId) {
		this.applicationStatusId = applicationStatusId;
	}

	public void setDepartmentId_1(String departmentId_1) {
		this.departmentId_1 = departmentId_1;
	}

	public void setDepartmentId_2(String departmentId_2) {
		this.departmentId_2 = departmentId_2;
	}

	public void setDepartmentId_3(String departmentId_3) {
		this.departmentId_3 = departmentId_3;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public void setDivisionId_2(String divisionId_2) {
		this.divisionId_2 = divisionId_2;
	}

	public void setDivisionId_3(String divisionId_3) {
		this.divisionId_3 = divisionId_3;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public void setSectionId_2(String sectionId_2) {
		this.sectionId_2 = sectionId_2;
	}

	public void setSectionId_3(String sectionId_3) {
		this.sectionId_3 = sectionId_3;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public void setStaffTypeId(String staffTypeId) {
		this.staffTypeId = staffTypeId;
	}

	public void setPrivilegeClassId(String privilegeClassId) {
		this.privilegeClassId = privilegeClassId;
	}

	public void setCorporateStatusId(String corporateStatusId) {
		this.corporateStatusId = corporateStatusId;
	}

	public void setDrgAttestation(String drgAttestation) {
		this.drgAttestation = drgAttestation;
	}

	public void setDrgAttestationText(String drgAttestationText) {
		this.drgAttestationText = drgAttestationText;
	}

	public void setDueAmount(boolean dueAmount) {
		this.dueAmount = dueAmount;
	}

	public void setDuePaid(String duePaid) {
		this.duePaid = duePaid;
	}

	public void setDuePaidText(String duePaidText) {
		this.duePaidText = duePaidText;
	}

	public void setMisc1(String misc1) {
		this.misc1 = misc1;
	}

	public void setMisc2(String misc2) {
		this.misc2 = misc2;
	}

	public void setMisc3(String misc3) {
		this.misc3 = misc3;
	}

	public void setMisc4(boolean misc4) {
		this.misc4 = misc4;
	}

	public void setMisc5(String misc5) {
		this.misc5 = misc5;
	}

	public void setMisc1Date(String misc1Date) {
		this.misc1Date = misc1Date;
	}

	public void setMisc1DateText(String misc1DateText) {
		this.misc1DateText = misc1DateText;
	}

	public void setMisc2Date(String misc2Date) {
		this.misc2Date = misc2Date;
	}

	public void setMisc2DateText(String misc2DateText) {
		this.misc2DateText = misc2DateText;
	}

	public void setMisc3Date(String misc3Date) {
		this.misc3Date = misc3Date;
	}

	public void setMisc3DateText(boolean misc3DateText) {
		this.misc3DateText = misc3DateText;
	}

	public void setMisc4Date(String misc4Date) {
		this.misc4Date = misc4Date;
	}

	public void setMisc4DateText(String misc4DateText) {
		this.misc4DateText = misc4DateText;
	}

	public void setMisc5Date(String misc5Date) {
		this.misc5Date = misc5Date;
	}

	public void setMisc5DateText(String misc5DateText) {
		this.misc5DateText = misc5DateText;
	}

	public void setOtherID(String otherID) {
		this.otherID = otherID;
	}

	public void setiDNumber(String iDNumber) {
		this.iDNumber = iDNumber;
	}

	public void setProctor(String proctor) {
		this.proctor = proctor;
	}

	public void setProctorRemovedDate(String proctorRemovedDate) {
		this.proctorRemovedDate = proctorRemovedDate;
	}

	public void setProctorRemovedDateText(String proctorRemovedDateText) {
		this.proctorRemovedDateText = proctorRemovedDateText;
	}

	public void setQaNumber(String qaNumber) {
		this.qaNumber = qaNumber;
	}

	public void setTempPrivilegeDate(String tempPrivilegeDate) {
		this.tempPrivilegeDate = tempPrivilegeDate;
	}

	public void setTempPrivilegeDateText(String tempPrivilegeDateText) {
		this.tempPrivilegeDateText = tempPrivilegeDateText;
	}

	public void setApplicationSent(String applicationSent) {
		this.applicationSent = applicationSent;
	}

	public void setApplicationSentText(String applicationSentText) {
		this.applicationSentText = applicationSentText;
	}

	public void setApplicationReceived(String applicationReceived) {
		this.applicationReceived = applicationReceived;
	}

	public void setApplicationReceivedText(String applicationReceivedText) {
		this.applicationReceivedText = applicationReceivedText;
	}

	public void setBoardApproved(String boardApproved) {
		this.boardApproved = boardApproved;
	}

	public void setBoardApprovedText(String boardApprovedText) {
		this.boardApprovedText = boardApprovedText;
	}

	public void setMedicalExecutiveCommitteeApproval(String medicalExecutiveCommitteeApproval) {
		this.medicalExecutiveCommitteeApproval = medicalExecutiveCommitteeApproval;
	}

	public void setMedicalExecutiveCommitteeApprovalText(String medicalExecutiveCommitteeApprovalText) {
		this.medicalExecutiveCommitteeApprovalText = medicalExecutiveCommitteeApprovalText;
	}

	public void setCredentialsCommitteeApproval(String credentialsCommitteeApproval) {
		this.credentialsCommitteeApproval = credentialsCommitteeApproval;
	}

	public void setCredentialsCommitteeApprovalText(String credentialsCommitteeApprovalText) {
		this.credentialsCommitteeApprovalText = credentialsCommitteeApprovalText;
	}

	public void setResignReason(String resignReason) {
		this.resignReason = resignReason;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setParkingNumber(String parkingNumber) {
		this.parkingNumber = parkingNumber;
	}

	public void setParkingPermit(String parkingPermit) {
		this.parkingPermit = parkingPermit;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public void setVoting(String voting) {
		this.voting = voting;
	}

	public void setApplicationProcessed(String applicationProcessed) {
		this.applicationProcessed = applicationProcessed;
	}

	public void setApplicationProcessedText(String applicationProcessedText) {
		this.applicationProcessedText = applicationProcessedText;
	}

	public void setDisciplinaryActionComment(String disciplinaryActionComment) {
		this.disciplinaryActionComment = disciplinaryActionComment;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setLastUpdatedText(String lastUpdatedText) {
		this.lastUpdatedText = lastUpdatedText;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public void setDateAssigned(String dateAssigned) {
		this.dateAssigned = dateAssigned;
	}

	public void setDateAssignedText(String dateAssignedText) {
		this.dateAssignedText = dateAssignedText;
	}

	public void setCredentialingComplete(boolean credentialingComplete) {
		this.credentialingComplete = credentialingComplete;
	}

	public void setOnStaff(boolean onStaff) {
		this.onStaff = onStaff;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public void setDisciplinaryAction(boolean disciplinaryAction) {
		this.disciplinaryAction = disciplinaryAction;
	}

	public void setTakesERCall(boolean takesERCall) {
		this.takesERCall = takesERCall;
	}

	public void setAdmittingPrivileges(boolean admittingPrivileges) {
		this.admittingPrivileges = admittingPrivileges;
	}

	public void setOnTheWeb(boolean onTheWeb) {
		this.onTheWeb = onTheWeb;
	}

	public void setSyncWithMainframe(boolean syncWithMainframe) {
		this.syncWithMainframe = syncWithMainframe;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setNotesHtml(String notesHtml) {
		this.notesHtml = notesHtml;
	}

	public void setlOAExpires(String lOAExpires) {
		this.lOAExpires = lOAExpires;
	}

	public void setlOAExpiresText(String lOAExpiresText) {
		this.lOAExpiresText = lOAExpiresText;
	}

	public void setAnticipatedStartDate(String anticipatedStartDate) {
		this.anticipatedStartDate = anticipatedStartDate;
	}

	public void setAnticipatedStartDateText(String anticipatedStartDateText) {
		this.anticipatedStartDateText = anticipatedStartDateText;
	}

	public void setPreApplicationReceived(String preApplicationReceived) {
		this.preApplicationReceived = preApplicationReceived;
	}

	public void setPreApplicationReceivedText(String preApplicationReceivedText) {
		this.preApplicationReceivedText = preApplicationReceivedText;
	}

	public void setPreApplicationSent(String preApplicationSent) {
		this.preApplicationSent = preApplicationSent;
	}

	public void setPreApplicationSentText(String preApplicationSentText) {
		this.preApplicationSentText = preApplicationSentText;
	}

	public void setpCP(boolean pCP) {
		this.pCP = pCP;
	}

	public void setApplicationReasonId(String applicationReasonId) {
		this.applicationReasonId = applicationReasonId;
	}

	public void setoPPEDate(String oPPEDate) {
		this.oPPEDate = oPPEDate;
	}

	public void setoPPEDateText(String oPPEDateText) {
		this.oPPEDateText = oPPEDateText;
	}

	public void setReappointmentPacketSent(String reappointmentPacketSent) {
		this.reappointmentPacketSent = reappointmentPacketSent;
	}

	public void setReappointmentPacketSentText(String reappointmentPacketSentText) {
		this.reappointmentPacketSentText = reappointmentPacketSentText;
	}

	public void setReappointmentApplicationReceived(String reappointmentApplicationReceived) {
		this.reappointmentApplicationReceived = reappointmentApplicationReceived;
	}

	public void setReappointmentApplicationReceivedText(String reappointmentApplicationReceivedText) {
		this.reappointmentApplicationReceivedText = reappointmentApplicationReceivedText;
	}

	public void setPhysicianOrdering(boolean physicianOrdering) {
		this.physicianOrdering = physicianOrdering;
	}

	public void setElectronicSignature(boolean electronicSignature) {
		this.electronicSignature = electronicSignature;
	}

	public void setfPPEDate(String fPPEDate) {
		this.fPPEDate = fPPEDate;
	}

	public void setfPPEDateText(String fPPEDateText) {
		this.fPPEDateText = fPPEDateText;
	}

	public void setHospitalBasedId(String hospitalBasedId) {
		this.hospitalBasedId = hospitalBasedId;
	}

	public void setContractStatusId(String contractStatusId) {
		this.contractStatusId = contractStatusId;
	}

	public void setExecutiveOrder(String executiveOrder) {
		this.executiveOrder = executiveOrder;
	}

	public void setExecutiveOrderText(String executiveOrderText) {
		this.executiveOrderText = executiveOrderText;
	}

	public void setAttending(boolean attending) {
		this.attending = attending;
	}

	public void setiDNumberGroupId(String iDNumberGroupId) {
		this.iDNumberGroupId = iDNumberGroupId;
	}

	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}

	public void setContractDateText(String contractDateText) {
		this.contractDateText = contractDateText;
	}

	public void setContractExpired(String contractExpired) {
		this.contractExpired = contractExpired;
	}

	public void setContractExpiredText(String contractExpiredText) {
		this.contractExpiredText = contractExpiredText;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}

	public void setIsEmployed(boolean isEmployed) {
		this.isEmployed = isEmployed;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	
	public void setIsPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public void setSpecialtyId_1(String specialtyId_1) {
		this.specialtyId_1 = specialtyId_1;
	}

	public void setTaxonomyId_1(String taxonomyId_1) {
		this.taxonomyId_1 = taxonomyId_1;
	}

	public void setBoardCertificationId_1(String boardCertificationId_1) {
		this.boardCertificationId_1 = boardCertificationId_1;
	}

	public void setSpecialtyCertificationStatusId_1(String specialtyCertificationStatusId_1) {
		this.specialtyCertificationStatusId_1 = specialtyCertificationStatusId_1;
	}

	public void setSpecialtyId_2(String specialtyId_2) {
		this.specialtyId_2 = specialtyId_2;
	}

	public void setTaxonomyId_2(String taxonomyId_2) {
		this.taxonomyId_2 = taxonomyId_2;
	}

	public void setBoardCertificationId_2(String boardCertificationId_2) {
		this.boardCertificationId_2 = boardCertificationId_2;
	}

	public void setSpecialtyCertificationStatusId_2(String specialtyCertificationStatusId_2) {
		this.specialtyCertificationStatusId_2 = specialtyCertificationStatusId_2;
	}

	public void setSpecialtyId_3(String specialtyId_3) {
		this.specialtyId_3 = specialtyId_3;
	}

	public void setTaxonomyId_3(String taxonomyId_3) {
		this.taxonomyId_3 = taxonomyId_3;
	}

	public void setBoardCertificationId_3(String boardCertificationId_3) {
		this.boardCertificationId_3 = boardCertificationId_3;
	}

	public void setSpecialtyCertificationStatusId_3(String specialtyCertificationStatusId_3) {
		this.specialtyCertificationStatusId_3 = specialtyCertificationStatusId_3;
	}

	public void setSpecialtyId_4(String specialtyId_4) {
		this.specialtyId_4 = specialtyId_4;
	}

	public void setTaxonomyId_4(String taxonomyId_4) {
		this.taxonomyId_4 = taxonomyId_4;
	}

	public void setBoardCertificationId_4(String boardCertificationId_4) {
		this.boardCertificationId_4 = boardCertificationId_4;
	}

	public void setSpecialtyCertificationStatusId_4(String specialtyCertificationStatusId_4) {
		this.specialtyCertificationStatusId_4 = specialtyCertificationStatusId_4;
	}

	public void setCustomAppointmentId(String customAppointmentId) {
		this.customAppointmentId = customAppointmentId;
	}

	public void setAutoSavedHistory(boolean autoSavedHistory) {
		this.autoSavedHistory = autoSavedHistory;
	}

	public void setUnSuspendedPrivileges(boolean unSuspendedPrivileges) {
		this.unSuspendedPrivileges = unSuspendedPrivileges;
	}
	
	public void setObjectType(int objectType) {
		this.objectType = objectType;
	}

	public String getWarnings() {
		return warnings;
	}

	public void setWarnings(String warnings) {
		this.warnings = warnings;
	}

	public void setColumn_Id(String column_Id) {
		this.column_Id = column_Id;
	}

	public void setUseCustomFields(boolean useCustomFields) {
		this.useCustomFields = useCustomFields;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public void setFacility(MDStaffProviderAppointmentFacility facility) {
		this.facility = facility;
	}

	public void setDepartment1Description(String department1Description) {
		this.department1Description = department1Description;
	}

	public void setDepartment2Description(String department2Description) {
		this.department2Description = department2Description;
	}

	public void setDepartment3Description(String department3Description) {
		this.department3Description = department3Description;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public void setCorporateStatusDescription(String corporateStatusDescription) {
		this.corporateStatusDescription = corporateStatusDescription;
	}

	public void setParentField(String parentField) {
		this.parentField = parentField;
	}

	public void setColumn_ProviderId(String column_ProviderId) {
		this.column_ProviderId = column_ProviderId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public void setLoadExistingObject(boolean loadExistingObject) {
		this.loadExistingObject = loadExistingObject;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public void setLazyLoad(boolean lazyLoad) {
		this.lazyLoad = lazyLoad;
	}

	public void setCustomColumn_Id(String customColumn_Id) {
		this.customColumn_Id = customColumn_Id;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public void setObjectDescription(String objectDescription) {
		this.objectDescription = objectDescription;
	}

	public void setRelativeObjectName(String relativeObjectName) {
		this.relativeObjectName = relativeObjectName;
	}

	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}

	public void setIgnoreRequiredFields(boolean ignoreRequiredFields) {
		this.ignoreRequiredFields = ignoreRequiredFields;
	}

	public void setIsLoaded(boolean isLoaded) {
		this.isLoaded = isLoaded;
	}
}
