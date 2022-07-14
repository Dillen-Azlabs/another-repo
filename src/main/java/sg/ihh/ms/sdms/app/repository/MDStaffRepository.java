package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.*;
import sg.ihh.ms.sdms.app.repository.model.Pagination;
import sg.ihh.ms.sdms.app.repository.model.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MDStaffRepository extends BaseRepository {

    private static final Map<String, String> SORT_MAP = new HashMap<>();

    public MDStaffRepository() {
        log = getLogger(this.getClass());
    }

    public List<MDStaffProvider> list() {
        final String methodName = "list";
        start(methodName);

        String sql = "SELECT * FROM mdstaff_providers ";

        List<MDStaffProvider> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            result = query.mapToBean(MDStaffProvider.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<MDStaffProvider> search(String searchTerm, List<Sort> sortList, Pagination pagination) {
        final String methodName = "search";
        start(methodName);

        String sql = "SELECT mdp.*, mddt.other_id as mcr_number FROM mdstaff_providers mdp"
                + " LEFT JOIN mdstaff_demographic mddt ON mdp.provider_id = mddt.provider_id"
                + " WHERE LOWER(mdp.name) LIKE CONCAT('%',:searchTermName,'%') "
                + " OR LOWER(other_id) LIKE CONCAT('%',:searchTermMcrNumber,'%') ";

        sortList = sortList.stream().map(sort -> new Sort(SORT_MAP.get(sort.getField()), sort.getModifier()))
                .collect(Collectors.toList());

        sql += generateSort(sortList);
        sql += generatePagination(pagination);

        List<MDStaffProvider> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {

            query.bind("searchTermName", searchTerm.toLowerCase());
            query.bind("searchTermMcrNumber", searchTerm.toLowerCase());
            result = query.mapToBean(MDStaffProvider.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<MDStaffSite> getProviderClinics(String mcrNumber) {
        final String methodName = "getProviderClinics";
        start(methodName);

        String sql = "SELECT mds.* FROM mdstaff_address ma" +
                " INNER JOIN mdstaff_sites mds ON ma.medical_group_id = mds.site_id " +
                " LEFT JOIN mdstaff_providers mp ON ma.provider_id = mp.provider_id " +
                " LEFT JOIN mdstaff_demographic mddt ON mp.provider_id = mddt.provider_id " +
                " WHERE mddt.other_id = :mcrNumber";

        List<MDStaffSite> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bind("mcrNumber", mcrNumber);
            result = query.mapToBean(MDStaffSite.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    
    public List<MDStaffProviderAppointment> getProviderAppointment(String mcrNumber) {
        final String methodName = "getProviderAppointments";
        start(methodName);

        String sql = "SELECT appt.*  FROM mdstaff_appointment appt WHERE appt.other_id = :other_id";

        // Final result
        List<MDStaffProviderAppointment> result = new ArrayList<MDStaffProviderAppointment> ();
        
        // MDStaffProviderAppointmentTemp class is used to accept the warnings value as String, which is returned as String by Database Query        
        List<MDStaffProviderAppointmentTemp> tempResult = null;
        
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bind("other_id", mcrNumber);
            tempResult = query.mapToBean(MDStaffProviderAppointmentTemp.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        
         
        for(MDStaffProviderAppointmentTemp temp : tempResult) {  
        	
        	MDStaffProviderAppointment appt = new MDStaffProviderAppointment();
        	appt.setAppointmentId(temp.getAppointmentId());
        	appt.setProviderId(temp.getProviderId());
        	appt.setFacilityId(temp.getFacilityId());
        	appt.setPrimaryAddressId(temp.getPrimaryAddressId());
        	appt.setSecondaryAddressId(temp.getSecondaryAddressId());
        	appt.setMailingAddressId(temp.getMailingAddressId());
        	appt.setReportAddressId(temp.getReportAddressId());
        	appt.setBillingAddressId(temp.getBillingAddressId());
        	appt.setCampusAddressId(temp.getCampusAddressId());
        	
        	//10
        	appt.setAppointmentAddressId(temp.getAppointmentAddressId());
        	appt.setInitialAppointment(temp.getInitialAppointment());
        	appt.setInitialAppointmentText(temp.getInitialAppointmentText());        
        	appt.setLastAppointment(temp.getLastAppointment());
        	appt.setLastAppointmentText(temp.getLastAppointmentText());
        	appt.setNextAppointment(temp.getNextAppointment());
        	appt.setNextAppointmentText(temp.getNextAppointmentText());
        	appt.setResigned(temp.getResigned());
        	appt.setResignedText(temp.getResignedText());
        	appt.setAdvancement1(temp.getAdvancement1());
        	
        	//20
        	appt.setAdvancement1Text(temp.getAdvancement1Text());
        	appt.setAdvancement2(temp.getAdvancement2());
        	appt.setAdvancement2Text(temp.getAdvancement2Text());
        	appt.setApplicationTypeId(temp.getApplicationTypeId());
        	appt.setApplicationStatusId(temp.getApplicationStatusId());
        	appt.setDepartmentId_1(temp.getDepartmentId_1());
        	appt.setDepartmentId_2(temp.getDepartmentId_2());
        	appt.setDepartmentId_3(temp.getDepartmentId_3());
        	appt.setDivisionId(temp.getDivisionId());    
        	appt.setDivisionId_2(temp.getDivisionId_2());
        	
        	//30
        	appt.setDivisionId_3(temp.getDivisionId_3());
        	appt.setSectionId(temp.getSectionId());
        	appt.setSectionId_2(temp.getSectionId_2());
        	appt.setSectionId_3(temp.getSectionId_3());
        	appt.setStatusId(temp.getStatusId());
        	appt.setStaffTypeId(temp.getStaffTypeId());
        	appt.setPrivilegeClassId(temp.getPrivilegeClassId());
        	appt.setCorporateStatusId(temp.getCorporateStatusId());
        	appt.setDrgAttestation(temp.getDrgAttestation());
        	appt.setDrgAttestationText(temp.getDrgAttestationText());
        	
        	//40
        	appt.setDueAmount(temp.isDueAmount());
        	appt.setDuePaid(temp.getDuePaid());      
        	appt.setDuePaidText(temp.getDuePaidText());
        	appt.setMisc1(temp.getMisc1());
        	appt.setMisc2(temp.getMisc2());
        	appt.setMisc3(temp.getMisc3());
        	appt.setMisc4(temp.isMisc4());
        	appt.setMisc5(temp.getMisc5());
        	appt.setMisc1Date(temp.getMisc1Date());
        	appt.setMisc1DateText(temp.getMisc1DateText());
        	
        	//50
        	appt.setMisc2Date(temp.getMisc2Date());
        	appt.setMisc2DateText(temp.getMisc2DateText());
        	appt.setMisc3Date(temp.getMisc3Date());
        	appt.setMisc3DateText(temp.isMisc3DateText());
        	appt.setMisc4Date(temp.getMisc4Date());
        	appt.setMisc4DateText(temp.getMisc4DateText());
        	appt.setMisc5Date(temp.getMisc5Date());
        	appt.setMisc5DateText(temp.getMisc5DateText());
        	appt.setOtherID(temp.getOtherID());       
        	appt.setiDNumber(temp.getiDNumber());
        	
        	//60
        	appt.setProctor(temp.getProctor());
        	appt.setProctorRemovedDate(temp.getProctorRemovedDate());
        	appt.setProctorRemovedDateText(temp.getProctorRemovedDateText());
        	appt.setQaNumber(temp.getQaNumber());
        	appt.setTempPrivilegeDate(temp.getTempPrivilegeDate());
        	appt.setTempPrivilegeDateText(temp.getTempPrivilegeDateText());
        	appt.setApplicationSent(temp.getApplicationSent());
        	appt.setApplicationSentText(temp.getApplicationSentText());
        	appt.setApplicationReceived(temp.getApplicationReceived());
        	appt.setApplicationReceivedText(temp.getApplicationReceivedText());
        	
        	//70
        	appt.setBoardApproved(temp.getBoardApproved());      
        	appt.setBoardApprovedText(temp.getBoardApprovedText());
        	appt.setMedicalExecutiveCommitteeApproval(temp.getMedicalExecutiveCommitteeApproval());
        	appt.setMedicalExecutiveCommitteeApprovalText(temp.getMedicalExecutiveCommitteeApprovalText());
        	appt.setCredentialsCommitteeApproval(temp.getCredentialsCommitteeApproval());
        	appt.setCredentialsCommitteeApprovalText(temp.getCredentialsCommitteeApprovalText());
        	appt.setResignReason(temp.getResignReason());
        	appt.setTitle(temp.getTitle());
        	appt.setParkingNumber(temp.getParkingNumber());
        	appt.setParkingPermit(temp.getParkingPermit());
        	
        	//80
        	appt.setMailbox(temp.getMailbox());
        	appt.setVoting(temp.getVoting());
        	appt.setApplicationProcessed(temp.getApplicationProcessed());
        	appt.setApplicationProcessedText(temp.getApplicationProcessedText());
        	appt.setDisciplinaryActionComment(temp.getDisciplinaryActionComment());
        	appt.setLastUpdated(temp.getLastUpdated());
        	appt.setLastUpdatedText(temp.getLastUpdatedText());
        	appt.setUpdatedBy(temp.getUpdatedBy());    
        	appt.setAssignedTo(temp.getAssignedTo());
        	appt.setDateAssigned(temp.getDateAssigned());

        	//90
        	appt.setDateAssignedText(temp.getDateAssignedText());
        	appt.setCredentialingComplete(temp.isCredentialingComplete());     
        	appt.setOnStaff(temp.isOnStaff());
        	appt.setArchived(temp.isArchived());
        	appt.setDisciplinaryAction(temp.isDisciplinaryAction());
        	appt.setTakesERCall(temp.isTakesERCall());        	
        	appt.setAdmittingPrivileges(temp.isAdmittingPrivileges());
        	appt.setOnTheWeb(temp.isOnTheWeb());
        	appt.setSyncWithMainframe(temp.isSyncWithMainframe());        	
        	appt.setNotes(temp.getNotes());       	
        	
        	//100
        	appt.setNotesHtml(temp.getNotesHtml());
        	appt.setlOAExpires(temp.getlOAExpires());
        	appt.setlOAExpiresText(temp.getlOAExpiresText());
        	appt.setAnticipatedStartDate(temp.getAnticipatedStartDate());
        	appt.setAnticipatedStartDateText(temp.getAnticipatedStartDateText());
        	appt.setPreApplicationReceived(temp.getPreApplicationReceived());
        	appt.setPreApplicationReceivedText(temp.getPreApplicationReceivedText());
        	appt.setPreApplicationSent(temp.getPreApplicationSent());
        	appt.setPreApplicationSentText(temp.getPreApplicationSentText());
        	appt.setpCP(temp.ispCP());
        	
        	//110
        	appt.setApplicationReasonId(temp.getApplicationReasonId());
        	appt.setoPPEDate(temp.getoPPEDate());      
        	appt.setoPPEDateText(temp.getoPPEDateText());     
        	appt.setReappointmentPacketSent(temp.getReappointmentPacketSent());
        	appt.setReappointmentPacketSentText(temp.getReappointmentPacketSentText());
        	appt.setReappointmentApplicationReceived(temp.getReappointmentApplicationReceived());
        	appt.setReappointmentApplicationReceivedText(temp.getReappointmentApplicationReceivedText());
        	appt.setPhysicianOrdering(temp.isPhysicianOrdering());
        	appt.setElectronicSignature(temp.isElectronicSignature());   
        	appt.setfPPEDate(temp.getfPPEDate());
        	
        	//120
        	appt.setfPPEDateText(temp.getfPPEDateText());  
        	appt.setHospitalBasedId(temp.getHospitalBasedId());
        	appt.setContractStatusId(temp.getContractStatusId());
        	appt.setExecutiveOrder(temp.getExecutiveOrder());
        	appt.setExecutiveOrderText(temp.getExecutiveOrderText());
        	appt.setAttending(temp.isAttending());       	
        	appt.setiDNumberGroupId(temp.getiDNumberGroupId());
        	appt.setContractDate(temp.getContractDate());
        	appt.setContractDateText(temp.getContractDateText());
        	appt.setContractExpired(temp.getContractExpired());
        	
        	//130
        	appt.setContractExpiredText(temp.getContractExpiredText());
        	appt.setSuspended(temp.isSuspended());
        	appt.setCategoryId(temp.getCategoryId());
        	appt.setIsEmployed(temp.isIsEmployed());
        	appt.setIsPrimary(temp.isIsPrimary());
        	appt.setSpecialtyId_1(temp.getSpecialtyId_1());
        	appt.setTaxonomyId_1(temp.getTaxonomyId_1());
        	appt.setBoardCertificationId_1(temp.getBoardCertificationId_1());
        	appt.setSpecialtyCertificationStatusId_1(temp.getSpecialtyCertificationStatusId_1());
        	appt.setSpecialtyId_2(temp.getSpecialtyId_2());
        	
        	//140
        	appt.setTaxonomyId_2(temp.getTaxonomyId_2());
        	appt.setBoardCertificationId_2(temp.getBoardCertificationId_2());
        	appt.setSpecialtyCertificationStatusId_2(temp.getSpecialtyCertificationStatusId_2());
        	appt.setSpecialtyId_3(temp.getSpecialtyId_3());
        	appt.setTaxonomyId_3(temp.getTaxonomyId_3());
        	appt.setBoardCertificationId_3(temp.getBoardCertificationId_3());
        	appt.setSpecialtyCertificationStatusId_3(temp.getSpecialtyCertificationStatusId_3());
        	appt.setSpecialtyId_4(temp.getSpecialtyId_4());
        	appt.setTaxonomyId_4(temp.getTaxonomyId_4());
        	appt.setBoardCertificationId_4(temp.getBoardCertificationId_4());
        	
        	//150
        	appt.setSpecialtyCertificationStatusId_4(temp.getSpecialtyCertificationStatusId_4());
        	appt.setCustomAppointmentId(temp.getCustomAppointmentId());
        	appt.setAutoSavedHistory(temp.isAutoSavedHistory());
        	appt.setUnSuspendedPrivileges(temp.isUnSuspendedPrivileges());
        	
        	// Transform Warnings String to Warning String[]
        	String[] arrWarnings = null;
        	if(temp.getWarnings()!= null && temp.getWarnings().trim()!="") {
        		arrWarnings = new String[1];
        		arrWarnings[0] = temp.getWarnings();
        		appt.setWarnings(arrWarnings);
        	}else {
        		appt.setWarnings(new String[0]);
        	}
            
            appt.setObjectType(temp.getObjectType());
            appt.setColumn_Id(temp.getColumn_Id());
            appt.setUseCustomFields(temp.isUseCustomFields());
            appt.setFacilityName(temp.getFacilityName());
            appt.setDepartment1Description(temp.getDepartment1Description());
            
            //160
            appt.setDepartment2Description(temp.getDepartment2Description());
            appt.setDepartment3Description(temp.getDepartment3Description());
            appt.setStatusDescription(temp.getStatusDescription());
            appt.setCorporateStatusDescription(temp.getCorporateStatusDescription());
            appt.setParentField(temp.getParentField());
        	appt.setColumn_ProviderId(temp.getColumn_ProviderId());
        	appt.setUserName(temp.getUserName());
        	appt.setObjectName(temp.getObjectName());
        	appt.setLoadExistingObject(temp.isLoadExistingObject());
        	appt.setSubType(temp.getSubType());
        	
        	//170
        	appt.setLazyLoad(temp.isLazyLoad());
        	appt.setCustomColumn_Id(temp.getCustomColumn_Id());
        	appt.setiD(temp.getiD());
        	appt.setObjectDescription(temp.getObjectDescription());
        	appt.setRelativeObjectName(temp.getRelativeObjectName());
        	appt.setIsNew(temp.isIsNew());
        	appt.setIgnoreRequiredFields(temp.isIgnoreRequiredFields());
        	appt.setIsLoaded(temp.isIsLoaded());
        	
         	appt.setFacility(getFacility(temp.getFacilityId()));
         	
         	// Transformed object is added to final result list
         	result.add(appt);
        	
        }
        
        completed(methodName);
        return result;
    }
    
    public MDStaffProviderAppointmentFacility getFacility(String facilityId) {
        final String methodName = "getProviderAppointmentFacilities";
        start(methodName);

        String sql = "SELECT fac.* FROM mdstaff_facility fac WHERE fac.facility_Id = :facilityId";
        
        MDStaffProviderAppointmentFacilityTemp tempResult = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
        	 query.bind("facilityId", facilityId);
        	 tempResult = query.mapToBean(MDStaffProviderAppointmentFacilityTemp.class).one();
        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        
        // MDStaffProviderAppointmentFacilityTemp class is used to accept the mergeFieldNames and mergeFieldValues as String, which are returned as String by Database Query 
               
        MDStaffProviderAppointmentFacility result = new MDStaffProviderAppointmentFacility();
        result.setFacilityId(tempResult.getFacilityId());
        result.setCode(tempResult.getCode());
        result.setName(tempResult.getName());
        result.setAddress(tempResult.getAddress());
        result.setAddress2(tempResult.getAddress2());
        result.setCity(tempResult.getCity());
        result.setState(tempResult.getState());
        result.setZip(tempResult.getZip());
        result.setTelephone(tempResult.getTelephone());
        result.setFax(tempResult.getFax());
        result.setEmail(tempResult.getEmail());
        result.setUrl(tempResult.getUrl());
        result.setLastUpdated(tempResult.getLastUpdated());
        result.setLastUpdatedText(tempResult.getLastUpdatedText());
        result.setUpdatedBy(tempResult.getUpdatedBy());
        result.setComments(tempResult.getComments());
        result.setCountry(tempResult.getCountry());
        result.setIsArchived(tempResult.isIsArchived());
        result.setUid(tempResult.getUid());
        result.setArchived(tempResult.isArchived());
        result.setAddressBlock(tempResult.getAddressBlock());
        
        // Transform MergeFieldNames String to MergeFieldNames String[]
        String[] arrMergeFieldNames = null;
        if(tempResult.getMergeFieldNames() != null && tempResult.getMergeFieldNames().trim()!="")
        {
        	arrMergeFieldNames = new String[1];
        	arrMergeFieldNames[0] = tempResult.getMergeFieldNames();
        	result.setMergeFieldNames(arrMergeFieldNames);
        }else {
        	result.setMergeFieldNames(new String[0]);
        }
        
        // Transform arrMergeFielValues String to arrMergeFielValues String[]
        String[] arrMergeFielValues = null;
        if(tempResult.getMergeFieldValues() != null && tempResult.getMergeFieldValues().trim()!="")
        {
        	arrMergeFielValues = new String[1];
        	arrMergeFielValues[0] = tempResult.getMergeFieldValues();
        	result.setMergeFieldValues(arrMergeFielValues);
        }else {
        	result.setMergeFieldValues(new String[0]);
        }
        result.setObjectType(tempResult.getObjectType());
        result.setUrl(tempResult.getUrl());
        result.setColumnId(tempResult.getColumnId());
        result.setUserName(tempResult.getUserName());
        result.setObjectName(tempResult.getObjectName());
        result.setLoadExistingObject(tempResult.isLoadExistingObject());
        result.setSubType(tempResult.getSubType());
        result.setLazyLoad(tempResult.isLazyLoad());
        result.setCustomColumnId(tempResult.getCustomColumnId());
        result.setId(tempResult.getId());
        result.setObjectDescription(tempResult.getObjectDescription());
        result.setUseCustomFields(tempResult.isUseCustomFields());
        result.setRelativeObjectName(tempResult.getRelativeObjectName());
        result.setNew(tempResult.isNew());
        result.setIgnoredRequiredFields(tempResult.isIgnoredRequiredFields());
        result.setLoaded(tempResult.isLoaded());
        
        completed(methodName);
        return result;
    }
}
