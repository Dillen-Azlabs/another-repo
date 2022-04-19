package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CentreServiceMainSdRepository extends BaseRepository{

    public CentreServiceMainSdRepository() {
        log = getLogger(this.getClass());
    }

    //START - Centre Service Main CTA Block
    public CentreServiceMainCta getCentreServiceCta(Version version, List<String> languageList, String centreServiceMUrl) {
        final String methodName = "getCentreServiceCta";
        start(methodName);

        String sql = " SELECT csms.* FROM centre_service_main_sd csms " +
                " WHERE csms.language_code IN(<languageList>) AND csms.item_url = :item_url " +
                " GROUP BY csms.uid " +
                " AND csms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        CentreServiceMainCta result = new CentreServiceMainCta();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", centreServiceMUrl);
            result = query.mapToBean(CentreServiceMainCta.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Centre Service Main CTA Block

    //START - Centre Service Main Specialty Block
    public List<CentreServiceMain> getCentreServiceMainSpecialty(Version version, List<String> languageList, String specialtyUrl, String hospitalCode) {
        final String methodName = "getCentreServiceMainSpecialty";
        start(methodName);

        String sql ="SELECT csms.uid, csms.language_code,csms.page_title, csms.summary, csms.main_image, csms.main_image_alt_text, ss.item_url, csms.publish_flag, csms.created_dt, csms.modified_dt FROM centre_service_main_sd csms  " +
                    "LEFT JOIN centre_service_main_sd_specialty csmss  ON csms.uid = csmss.centre_service_main_sd_uid " +
                    "LEFT JOIN specialty_sd ss ON csmss.specialty_uid  = ss.specialty_uid " +
                    "LEFT JOIN centre_service_main_sd_hospital csmsh  ON csmsh.centre_service_main_sd_uid  = csms.uid " +
                    "LEFT JOIN hospital h ON csmsh.hospital_uid  = h.uid " +
                    "WHERE csms.language_code IN(<languageList>) AND ss.item_url = :item_url AND h.hospital = :hospital " +
                    " AND csms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<CentreServiceMain> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyUrl).bind("hospital", hospitalCode);
            result = query.mapToBean(CentreServiceMain.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        for (CentreServiceMain centreServiceMain : result) {
            Map<String, Object> metadata = getCentreServiceMainMetadata(version, languageList, specialtyUrl, hospitalCode, centreServiceMain.getUid());
            if (metadata.get("hospital_main_image") != null && !metadata.get("hospital_main_image").equals("")) {
                centreServiceMain.setMainImage((String) metadata.get("hospital_main_image"));
            }
            if (metadata.get("hospital_main_image_alt_text") != null && !metadata.get("hospital_main_image_alt_text").equals("")) {
                centreServiceMain.setMainImageAltText((String) metadata.get("hospital_main_image_alt_text"));
            }
        }
        completed(methodName);
        return result;
    }

    public Map<String, Object> getCentreServiceMainMetadata(Version version, List<String> languageList, String specialtyUrl, String hospitalCode, String uid) {
        final String methodName = "getCentreServiceMainMetadata";
        start(methodName);

        String sql = "SELECT csmsm.hospital_main_image, csmsm.hospital_main_image_alt_text FROM centre_service_main_sd csms " +
                "LEFT JOIN centre_service_main_sd_metadata csmsm  ON csms.uid = csmsm.centre_service_main_sd_uid " +
                "LEFT JOIN centre_service_main_sd_specialty csmss  ON csms.uid = csmss.centre_service_main_sd_uid " +
                "LEFT JOIN specialty_sd ss ON csmss.specialty_uid  = ss.specialty_uid " +
                "LEFT JOIN centre_service_main_sd_hospital csmsh  ON csmsh.centre_service_main_sd_uid  = csms.uid " +
                "LEFT JOIN hospital h ON csmsh.hospital_uid  = h.uid " +
                "WHERE csms.language_code IN(<languageList>) AND ss.item_url = :item_url AND h.hospital = :hospital AND csms.uid = :uid" +
                " AND csms.publish_flag = {PUBLISHED} AND csmsm.centre_service_main_sd_uid  is not null";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyUrl).bind("hospital", hospitalCode).bind("uid", uid);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Centre Service Main Specialty Block

    //START - Centre Service Main Medical Professional Block
    public List<CentreServiceMain> getCentreServiceMainMedPro(Version version, List<String> languageList, String medicalProfessionalUrl, String hospitalCode) {
        final String methodName = "getCentreServiceMainMedPro";
        start(methodName);

        String sql =" SELECT csms.uid, csms.language_code,csms.page_title, csms.summary, csms.main_image, csms.main_image_alt_text, mp.item_url, csms.publish_flag, csms.created_dt, csms.modified_dt FROM centre_service_main_sd csms " +
                "LEFT JOIN medical_professional_centre_service mpcs  ON csms.uid = mpcs.centre_service_main_sd " +
                "LEFT JOIN medical_professional mp  ON mpcs.medical_professional_uid  = mp.uid " +
                "LEFT JOIN centre_service_main_sd_hospital csmsh ON csms.uid  = csmsh.centre_service_main_sd_uid " +
                "LEFT JOIN hospital h ON csmsh.hospital_uid  = h.uid  " +
                "WHERE csms.language_code IN(<languageList>) AND mp.item_url = :item_url AND h.hospital = :hospital " +
                " AND csms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<CentreServiceMain> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalUrl).bind("hospital", hospitalCode);
            result = query.mapToBean(CentreServiceMain.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        for (CentreServiceMain centreServiceMain : result) {
            Map<String, Object> metadata = getMetadataMedPro(version, languageList, medicalProfessionalUrl, hospitalCode, centreServiceMain.getUid());
            if (metadata.get("hospital_main_image") != null && !metadata.get("hospital_main_image").equals("")) {
                centreServiceMain.setMainImage((String) metadata.get("hospital_main_image"));
            }
            if (metadata.get("hospital_main_image_alt_text") != null && !metadata.get("hospital_main_image_alt_text").equals("")) {
                centreServiceMain.setMainImageAltText((String) metadata.get("hospital_main_image_alt_text"));
            }
        }
        completed(methodName);
        return result;
    }

    public Map<String, Object> getMetadataMedPro(Version version, List<String> languageList, String medicalProfessionalUrl, String hospitalCode, String uid) {
        final String methodName = "getMetadataMedPro";
        start(methodName);

        String sql = "SELECT csmsm.hospital_main_image, csmsm.hospital_main_image_alt_text FROM centre_service_main_sd csms " +
                "LEFT JOIN centre_service_main_sd_metadata csmsm  ON csms.uid = csmsm.centre_service_main_sd_uid " +
                "LEFT JOIN medical_professional_centre_service mpcs  ON csms.uid = mpcs.centre_service_main_sd " +
                "LEFT JOIN medical_professional mp  ON mpcs.medical_professional_uid  = mp.uid " +
                "LEFT JOIN hospital h ON mpcs.hospital_uid  = h.uid " +
                "WHERE csms.language_code IN(<languageList>) AND mp.item_url = :item_url AND h.hospital = :hospital AND csms.uid = :uid" +
                " AND csms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalUrl).bind("hospital", hospitalCode).bind("uid", uid);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Centre Service Main Medical Professional Block

    //START - Centre Service Main Condition Block
    public List<CentreServiceMain> getCentreServiceMainCondition(Version version, List<String> languageList, String conditionUrl, String hospitalCode) {
        final String methodName = "getCentreServiceMainCondition";
        start(methodName);

        String sql ="SELECT csms.uid, csms.language_code,csms.page_title, csms.summary, csms.main_image, csms.main_image_alt_text, cds.item_url, csms.publish_flag, csms.created_dt, csms.modified_dt FROM centre_service_main_sd csms " +
                "LEFT JOIN condition_disease_sd_centre_service cdscs  ON csms.uid = cdscs.centre_service_main_sd " +
                "LEFT JOIN condition_disease_sd cds  ON cdscs.condition_disease_sd_uid  = cds.uid " +
                "LEFT JOIN centre_service_main_sd_hospital csmsh ON csms.uid  = csmsh.centre_service_main_sd_uid " +
                "LEFT JOIN hospital h ON csmsh.hospital_uid  = h.uid  " +
                "WHERE csms.language_code IN(<languageList>) AND cds.item_url = :item_url AND h.hospital = :hospital " +
                " AND csms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<CentreServiceMain> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionUrl).bind("hospital", hospitalCode);
            result = query.mapToBean(CentreServiceMain.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        for (CentreServiceMain centreServiceMain : result) {
            Map<String, Object> metadata = getMetadataCondition(version, languageList, conditionUrl, hospitalCode, centreServiceMain.getUid());
            if (metadata.get("hospital_main_image") != null && !metadata.get("hospital_main_image").equals("")) {
                centreServiceMain.setMainImage((String) metadata.get("hospital_main_image"));
            }
            if (metadata.get("hospital_main_image_alt_text") != null && !metadata.get("hospital_main_image_alt_text").equals("")) {
                centreServiceMain.setMainImageAltText((String) metadata.get("hospital_main_image_alt_text"));
            }
        }
        completed(methodName);
        return result;
    }

    public Map<String, Object> getMetadataCondition(Version version, List<String> languageList, String conditionUrl, String hospitalCode, String uid) {
        final String methodName = "getMetadataCondition";
        start(methodName);

        String sql = "SELECT csmsm.hospital_main_image, csmsm.hospital_main_image_alt_text FROM centre_service_main_sd csms " +
                "LEFT JOIN centre_service_main_sd_metadata csmsm  ON csms.uid = csmsm.centre_service_main_sd_uid " +
                "LEFT JOIN condition_disease_sd_centre_service cdscs  ON csms.uid = cdscs.centre_service_main_sd " +
                "LEFT JOIN condition_disease_sd cds  ON cdscs.condition_disease_sd_uid  = cds.uid " +
                "LEFT JOIN hospital h ON cdscs.hospital_uid  = h.uid " +
                "WHERE csms.language_code IN(<languageList>) AND cds.item_url = :item_url AND h.hospital = :hospital AND csms.uid = :uid" +
                " AND csms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionUrl).bind("hospital", hospitalCode).bind("uid", uid);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Centre Service Main Condition Block

    //START - Centre Service Main Treatment Block
    public List<CentreServiceMain> getCentreServiceMainTreatment(Version version, List<String> languageList, String treatmentUrl, String hospitalCode) {
        final String methodName = "getCentreServiceMainTreatment";
        start(methodName);

        String sql ="SELECT csms.uid, csms.language_code,csms.page_title, csms.summary, csms.main_image, csms.main_image_alt_text, tts.item_url, csms.publish_flag, csms.created_dt, csms.modified_dt FROM centre_service_main_sd csms " +
                "LEFT JOIN test_treatment_sd_centre_service ttscs ON csms.uid = ttscs.centre_service_main_sd " +
                "LEFT JOIN test_treatment_sd tts  ON ttscs.test_treatment_sd_uid  = tts.uid " +
                "LEFT JOIN centre_service_main_sd_hospital csmsh ON csms.uid  = csmsh.centre_service_main_sd_uid " +
                "LEFT JOIN hospital h ON csmsh.hospital_uid  = h.uid  " +
                "WHERE csms.language_code IN(<languageList>) AND tts.item_url = :item_url AND h.hospital = :hospital " +
                " AND csms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<CentreServiceMain> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", treatmentUrl).bind("hospital", hospitalCode);
            result = query.mapToBean(CentreServiceMain.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        for (CentreServiceMain centreServiceMain : result) {
            Map<String, Object> metadata = getMetadataTreatment(version, languageList, treatmentUrl, hospitalCode, centreServiceMain.getUid());
            if (metadata.get("hospital_main_image") != null && !metadata.get("hospital_main_image").equals("")) {
                centreServiceMain.setMainImage((String) metadata.get("hospital_main_image"));
            }
            if (metadata.get("hospital_main_image_alt_text") != null && !metadata.get("hospital_main_image_alt_text").equals("")) {
                centreServiceMain.setMainImageAltText((String) metadata.get("hospital_main_image_alt_text"));
            }
        }
        completed(methodName);
        return result;
    }

    public Map<String, Object> getMetadataTreatment(Version version, List<String> languageList, String treatmentUrl, String hospitalCode, String uid) {
        final String methodName = "getMetadataTreatment";
        start(methodName);

        String sql = "SELECT csmsm.hospital_main_image, csmsm.hospital_main_image_alt_text FROM centre_service_main_sd csms " +
                "LEFT JOIN centre_service_main_sd_metadata csmsm  ON csms.uid = csmsm.centre_service_main_sd_uid " +
                "LEFT JOIN test_treatment_sd_centre_service ttscs ON csms.uid = ttscs.centre_service_main_sd  " +
                "LEFT JOIN test_treatment_sd tts  ON ttscs.test_treatment_sd_uid  = tts.uid " +
                "LEFT JOIN hospital h ON ttscs.hospital_uid  = h.uid " +
                "WHERE csms.language_code IN(<languageList>) AND tts.item_url = :item_url AND h.hospital = :hospital AND csms.uid = :uid" +
                " AND csms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", treatmentUrl).bind("hospital", hospitalCode).bind("uid", uid);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Centre Service Main Treatment Block

    //START - Centre Service Main Content Hub Block
    public List<CentreServiceMain> getCentreServiceMainContentHub(Version version, List<String> languageList, String contentHubMUrl, String hospitalCode){
        final String methodName = "getCentreServiceMainContentHub";
        start(methodName);

        String sql ="SELECT csms.uid, csms.language_code,csms.page_title, csms.summary, csms.main_image, csms.main_image_alt_text, chms.item_url, csms.publish_flag, csms.created_dt, csms.modified_dt FROM centre_service_main_sd csms " +
                "LEFT JOIN content_hub_main_sd_centre_service chmsc ON csms.uid = chmsc.centre_service_main_sd  " +
                "LEFT JOIN content_hub_main_sd chms  ON chmsc.content_hub_main_sd_uid  = chms.uid " +
                "LEFT JOIN hospital h ON chmsc.hospital_uid  = h.uid " +
                "WHERE csms.language_code IN(<languageList>) AND chms.item_url = :item_url AND h.hospital = :hospital " +
                " AND csms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<CentreServiceMain> result = new ArrayList<>();

        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", contentHubMUrl).bind("hospital", hospitalCode);
            result = query.mapToBean(CentreServiceMain.class).list();
        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        for (CentreServiceMain centreServiceMain : result) {
            Map<String, Object> metadata = getMetadataContentHub(version, languageList, contentHubMUrl, hospitalCode, centreServiceMain.getUid());
            if (metadata.get("hospital_main_image") != null && !metadata.get("hospital_main_image").equals("")) {
                centreServiceMain.setMainImage((String) metadata.get("hospital_main_image"));
            }
            if (metadata.get("hospital_main_image_alt_text") != null && !metadata.get("hospital_main_image_alt_text").equals("")) {
                centreServiceMain.setMainImageAltText((String) metadata.get("hospital_main_image_alt_text"));
            }
        }
        completed(methodName);

        return result;
    }

    public Map<String, Object> getMetadataContentHub(Version version, List<String> languageList, String contentHubMUrl, String hospitalCode, String uid){
        final String methodName = "getMetadataTreatment";
        start(methodName);
        String sql ="SELECT csms.uid, csms.language_code,csms.page_title, csms.summary, csms.main_image, csms.main_image_alt_text, chms.item_url, csms.publish_flag, csms.created_dt, csms.modified_dt FROM centre_service_main_sd csms " +
                "LEFT JOIN centre_service_main_sd_metadata csmsm  ON csms.uid = csmsm.centre_service_main_sd_uid " +
                "LEFT JOIN content_hub_main_sd_centre_service chmsc ON csms.uid = chmsc.centre_service_main_sd  " +
                "LEFT JOIN content_hub_main_sd chms  ON chmsc.content_hub_main_sd_uid  = chms.uid " +
                "LEFT JOIN hospital h ON chmsc.hospital_uid  = h.uid " +
                "WHERE csms.language_code IN(<languageList>) AND chms.item_url = :item_url AND h.hospital = :hospital " +
                " AND csms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();

        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", contentHubMUrl).bind("hospital", hospitalCode).bind("uid", uid);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);

        return result;
    }
    //END - Centre Service Main Content Hub Block


}
