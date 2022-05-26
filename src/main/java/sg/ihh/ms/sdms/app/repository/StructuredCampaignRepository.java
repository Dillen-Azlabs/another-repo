package sg.ihh.ms.sdms.app.repository;


import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StructuredCampaignRepository extends BaseRepository {
    public StructuredCampaignRepository() {
        log = getLogger(this.getClass());
    }

    // START - Structured Campaign Basic Details
    public StructuredCampaignDetails getStructuredCampaignDetails(Version version, List<String> languageList, String structuredCampaignUrl, String hospitalCode){
        final String methodName = "StructuredCampaignDetails";
        start(methodName);

        String sql = "SELECT scs.uid, scs.language_code, scs.campaign_title, scs.item_url, scs.main_image, scs.main_image_alt_text, scsm.overview, scsm.benefits_list, scs.summary, scsm.social_summary, scsm.meta_title, scsm.meta_description, scs.publish_flag, scs.created_dt, scs.modified_dt FROM structured_campaign_sd scs " +
                "LEFT JOIN structured_campaign_sd_metadata scsm ON scs.uid  = scsm.structured_campaign_sd_uid " +
                "LEFT JOIN structured_campaign_sd_hospital scsh ON scs.uid  = scsh.structured_campaign_sd_uid " +
                "LEFT JOIN hospital hm ON hm.uid = scsm.hospital_uid " +
                "LEFT JOIN hospital hh ON hh.uid = scsh.hospital_uid " +
                "WHERE scs.language_code IN(<languageList>) AND scs.item_url = :item_url AND hm.hospital = :hospital AND hh.hospital = :hospital " +
                "AND scs.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        StructuredCampaignDetails structuredCampaignDetails = new StructuredCampaignDetails();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredCampaignUrl).bind("hospital", hospitalCode);
            structuredCampaignDetails = query.mapToBean(StructuredCampaignDetails.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);

        return structuredCampaignDetails;
    }

    // END - Structured Campaign Basic Details

    // START - Structured Campaign Accordion
    public List<StructuredCampaignAccordion> getStructuredCampaignAccordion(Version version, List<String> languageList, String structuredCampaignUrl, String hospitalCode){
        final String methodName = "getStructuredCampaignAccordion";
        start(methodName);

        String sql = " SELECT scsa.* FROM structured_campaign_sd scs " +
                "LEFT JOIN structured_campaign_sd_accordion scsa ON scs.uid = scsa.structured_campaign_sd_uid " +
                "LEFT JOIN structured_campaign_sd_hospital scsh ON scs.uid  = scsh.structured_campaign_sd_uid  " +
                "LEFT JOIN hospital h ON h.uid = scsh.hospital_uid " +
                "WHERE scs.language_code IN(<languageList>) AND scs.item_url = :item_url AND h.hospital = :hospital " +
                "AND scs.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        List<StructuredCampaignAccordion> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredCampaignUrl).bind("hospital", hospitalCode);
            result = query.mapToBean(StructuredCampaignAccordion.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);

        return result;
    }
    // END - Structured Campaign Accordion


    //START - Structured Campaign Body Section
    public List<StructuredCampaignBodySections> getStructuredCampaignBodySections(Version version, List<String> languageList, String structuredCampaignUrl, String country, String hospital) {
        final String methodName = "getStructuredCampaignBodySections";
        start(methodName);

        List<StructuredCampaignBodySections> structuredCampaignBodySectionsList = getStructuredCampaignBody(version, languageList, structuredCampaignUrl,country, hospital);

        for (StructuredCampaignBodySections structuredCampaignBodySections : structuredCampaignBodySectionsList){
            log.debug(methodName, structuredCampaignBodySections.getUid());
            List<StructuredCampaignMedicalProfessionalItem> structuredCampaignMedicalProfessionalItem = getStructuredCampaignBodyMedicalItem(version, structuredCampaignBodySections.getUid());
            structuredCampaignBodySections.setMedicalProfessionalItem(structuredCampaignMedicalProfessionalItem);
            log.error(methodName);
        }

        completed(methodName);
        return structuredCampaignBodySectionsList;
    }
    public List<StructuredCampaignBodySections> getStructuredCampaignBody(Version version, List<String> languageList, String structuredCampaignUrl, String country, String hospital) {
        final String methodName = "getStructuredCampaignBody";
        start(methodName);

        String sql = "SELECT scsb.* FROM structured_campaign_sd scs " +
                "LEFT JOIN structured_campaign_sd_body scsb ON scs.uid = scsb.structured_campaign_sd_uid " +
                "LEFT JOIN structured_campaign_sd_body_cor scsbc ON scsb.uid = scsbc.structured_campaign_sd_body_uid " +
                "LEFT JOIN country_of_residence cor ON cor.uid = scsbc.cor_uid " +
                "LEFT JOIN structured_campaign_sd_metadata scsm ON scs.uid = scsm.structured_campaign_sd_uid  " +
                "LEFT JOIN structured_campaign_sd_hospital scsh ON scs.uid = scsh.structured_campaign_sd_uid " +
                "LEFT JOIN hospital hm ON hm.uid = scsm.hospital_uid  " +
                "LEFT JOIN hospital hh ON hh.uid = scsh.hospital_uid " +
                "WHERE scs.language_code IN(<languageList>) AND scs.item_url = :item_url AND cor.cor = :country AND hm.hospital = :hospitalM AND hh.hospital = :hospital  " +
                "AND scs.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<StructuredCampaignBodySections> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredCampaignUrl).
            bind("country", country).bind("hospitalM", hospital).bind("hospital", hospital);
            result = query.mapToBean(StructuredCampaignBodySections.class).list();
        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    private List<StructuredCampaignMedicalProfessionalItem> getStructuredCampaignBodyMedicalItem(Version version,String uid)
    {
        String methodName = "getStructuredCampaignBodyMedicalItem";

        String sql = "SELECT mp.* FROM structured_campaign_sd scs " +
                "LEFT JOIN structured_campaign_sd_body scsb ON scs.uid = scsb.structured_campaign_sd_uid " +
                "LEFT JOIN structured_campaign_sd_body_medical_professional scsbmp ON scsb.uid = scsbmp.structured_campaign_sd_body_uid " +
                "LEFT JOIN medical_professional mp ON mp.uid = scsbmp.medical_professional_uid " +
                "WHERE scsb.uid = :uid AND scs.publish_flag = {PUBLISHED}";
        sql = getPublishVersion(version, sql);

        List<StructuredCampaignMedicalProfessionalItem> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bind("uid", uid);
            result = query.mapToBean(StructuredCampaignMedicalProfessionalItem.class).list();
        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Structured Campaign StructuredBody Block

    //START - Structured Page Faq Block
    public List<StructuredCampaignFaq> getStructuredCampaignFaq(Version version, List<String> languageList, String structuredCampaignUrl, String country) {
        final String methodName = "getStructuredCampaignFaq";
        start(methodName);

        String sql = "SELECT scsf.* FROM structured_campaign_sd scs  " +
                "LEFT JOIN structured_campaign_sd_faq scsf ON scs.uid = scsf.structured_campaign_sd_uid " +
                "LEFT JOIN structured_campaign_sd_faq_cor scsfc ON scsf.uid = scsfc.structured_campaign_sd_faq_uid " +
                "LEFT JOIN country_of_residence cor ON cor.uid = scsfc.cor_uid  " +
                "WHERE scs.language_code IN(<languageList>) AND scs.item_url = :item_url AND cor.cor = :country " +
                "AND scs.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<StructuredCampaignFaq> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredCampaignUrl).bind("country", country);
            result = query.mapToBean(StructuredCampaignFaq.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Structured Campaign Faq Block


    //START - Structured Campaign By Specialty Block
    public List<StructuredCampaignSd> getStructuredCampaignBySpecialty(Version version, List<String> languageList, String structuredCampaignUrl, String hospital) {
        final String methodName = "getStructuredCampaignBySpecialty";
        start(methodName);

        String sql = "SELECT scs.uid, scs.language_code, scs.campaign_title, scs.item_url, scs.main_image, " +
                "scs.main_image_alt_text, scs.publish_flag, scs.created_dt, scs.modified_dt " +
                "FROM structured_campaign_sd scs " +
                "LEFT JOIN structured_campaign_sd_specialty scss ON scs.uid = scss.structured_campaign_sd_uid " +
                "LEFT JOIN specialty s ON s.uid = scss.specialty_uid " +
                "LEFT JOIN structured_campaign_sd_child_specialty scscs ON scs.uid = scscs.structured_campaign_sd_uid  " +
                "LEFT JOIN child_specialty cs ON cs.uid = scscs.child_specialty_uid " +
                "LEFT JOIN specialty_sd ss ON ss.specialty_uid = s.uid " +
                "LEFT JOIN structured_campaign_sd_hospital scsh ON scs.uid = scsh.structured_campaign_sd_uid " +
                "LEFT JOIN hospital h ON h.uid = scsh.hospital_uid " +
                "WHERE scs.language_code IN(<languageList>) AND ss.item_url = :item_url AND h.hospital = :hospital " +
                "AND scs.publish_flag = {PUBLISHED} " +
                "GROUP BY scs.uid ";

        sql = getPublishVersion(version, sql);

        List<StructuredCampaignSd> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredCampaignUrl).bind("hospital", hospital);
            result = query.mapToBean(StructuredCampaignSd.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Campaign By Specialty Block

    //START - Structured Campaign By Condition Block
    public List<StructuredCampaignSd> getStructuredCampaignByCondition(Version version, List<String> languageList, String structuredCampaignUrl, String hospital) {
        final String methodName = "getStructuredCampaignByCondition";
        start(methodName);

        String sql = "SELECT scs.uid, scs.language_code, scs.campaign_title, scs.item_url, scs.main_image,  " +
                "scs.main_image_alt_text, scs.publish_flag, scs.created_dt, scs.modified_dt  " +
                "FROM structured_campaign_sd scs " +
                "LEFT JOIN structured_campaign_sd_specialty scss ON scs.uid = scss.structured_campaign_sd_uid " +
                "LEFT JOIN specialty s ON s.uid = scss.specialty_uid " +
                "LEFT JOIN structured_campaign_sd_child_specialty scscs ON scs.uid = scscs.structured_campaign_sd_uid  " +
                "LEFT JOIN child_specialty cs ON cs.uid = scscs.child_specialty_uid " +
                "LEFT JOIN condition_disease_sd cds ON scss.specialty_uid = cds.primary_specialty_uid " +
                "LEFT JOIN structured_campaign_sd_hospital scsh ON scs.uid = scsh.structured_campaign_sd_uid " +
                "LEFT JOIN hospital h ON h.uid = scsh.hospital_uid " +
                "WHERE scs.language_code IN(<languageList>) AND cds.item_url = :item_url AND h.hospital = :hospital " +
                "AND scs.publish_flag = {PUBLISHED} " +
                "GROUP BY scs.uid";

        sql = getPublishVersion(version, sql);

        List<StructuredCampaignSd> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredCampaignUrl).bind("hospital", hospital);
            result = query.mapToBean(StructuredCampaignSd.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Campaign By Condition Block


    //START - Structured Campaign By Test & Treatment Block
    public List<StructuredCampaignSd> getStructuredCampaignByTestTreatment(Version version, List<String> languageList, String structuredCampaignUrl, String hospital) {
        final String methodName = "getStructuredCampaignByTestTreatment";
        start(methodName);

        String sql = "SELECT scs.uid, scs.language_code, scs.campaign_title, scs.item_url, scs.main_image,   " +
                "scs.main_image_alt_text, scs.publish_flag, scs.created_dt, scs.modified_dt   " +
                "FROM structured_campaign_sd scs  " +
                "LEFT JOIN structured_campaign_sd_specialty scss ON scs.uid = scss.structured_campaign_sd_uid  " +
                "LEFT JOIN specialty s ON s.uid = scss.specialty_uid  " +
                "LEFT JOIN structured_campaign_sd_child_specialty scscs ON scs.uid = scscs.structured_campaign_sd_uid   " +
                "LEFT JOIN child_specialty cs ON cs.uid = scscs.child_specialty_uid  " +
                "LEFT JOIN test_treatment_primary_specialty ttps ON ttps.specialty_uid = scss.specialty_uid  " +
                "LEFT JOIN test_treatment tt ON tt.uid = ttps.test_treatment_uid  " +
                "LEFT JOIN test_treatment_sd tts ON tt.uid = tts.primary_treatment_uid  " +
                "LEFT JOIN structured_campaign_sd_hospital scsh ON scs.uid = scsh.structured_campaign_sd_uid  " +
                "LEFT JOIN hospital h ON h.uid = scsh.hospital_uid " +
                "WHERE scs.language_code IN(<languageList>) AND tts.item_url = :item_url AND h.hospital = :hospital " +
                "AND scs.publish_flag = {PUBLISHED} " +
                "GROUP BY scs.uid";

        sql = getPublishVersion(version, sql);

        List<StructuredCampaignSd> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredCampaignUrl).bind("hospital", hospital);
            result = query.mapToBean(StructuredCampaignSd.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Campaign By Test & Treatment Block
}
