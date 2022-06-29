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

    // START - Generic function for getting Centre & Service (Main) Metadata Hospital Images
    public Map<String, Object> getCentreServiceMainMetadata(Version version, List<String> languageList, String hospitalCode, String centreServiceMainUid) {
        final String methodName = "getCentreServiceMainMetadata";
        start(methodName);

        String sql = "SELECT csmsm.hospital_main_image, csmsm.hospital_main_image_alt_text FROM centre_service_main_sd csms " +
                "LEFT JOIN centre_service_main_sd_metadata csmsm  ON csms.uid = csmsm.centre_service_main_sd_uid " +
                "LEFT JOIN hospital h ON csmsm.hospital_uid  = h.uid " +
                "WHERE csms.language_code IN(<languageList>) AND h.hospital = :hospital AND csms.uid = :uid" +
                " AND csms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("hospital", hospitalCode).bind("uid", centreServiceMainUid);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    // END - Generic function for getting Centre & Service (Main) Metadata Hospital Images

    //START - Centre Service Main Specialty Block
    public List<CentreServiceMain> getCentreServiceMainSpecialty(Version version, List<String> languageList, String specialtyUrl, String hospitalCode) {
        final String methodName = "getCentreServiceMainSpecialty";
        start(methodName);

        String sql ="SELECT csms.uid, csms.language_code,csms.page_title, csms.summary, csms.main_image, csms.main_image_alt_text, csms.item_url, csms.display_order, csms.publish_flag, csms.created_dt, csms.modified_dt FROM centre_service_main_sd csms  " +
                    "LEFT JOIN centre_service_main_sd_specialty csmss  ON csms.uid = csmss.centre_service_main_sd_uid AND csms.language_code = csmss.language_code AND csms.status = csmss.status " +
                    "LEFT JOIN specialty_sd ss ON csmss.specialty_uid  = ss.specialty_uid AND csmss.language_code = ss.language_code AND csmss.status = ss.status " +
                    "LEFT JOIN centre_service_main_sd_hospital csmsh  ON csmsh.centre_service_main_sd_uid  = csms.uid AND csmsh.language_code = csms.language_code AND csmsh.status = csms.status " +
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
            Map<String, Object> metadata = getCentreServiceMainMetadata(version, languageList, hospitalCode, centreServiceMain.getUid());
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
    //END - Centre Service Main Specialty Block

    //START - Centre Service Main Medical Professional Block
    public List<CentreServiceMain> getCentreServiceMainMedPro(Version version, List<String> languageList, String medicalProfessionalUrl, String hospitalCode) {
        final String methodName = "getCentreServiceMainMedPro";
        start(methodName);

        String sql =" SELECT csms.uid, csms.language_code,csms.page_title, csms.summary, csms.main_image, csms.main_image_alt_text, csms.item_url, csms.display_order, csms.publish_flag, csms.created_dt, csms.modified_dt FROM centre_service_main_sd csms " +
                "LEFT JOIN medical_professional_centre_service mpcs  ON csms.uid = mpcs.centre_service_main_sd_uid AND csms.language_code = mpcs.language_code AND csms.status = mpcs.status " +
                "LEFT JOIN medical_professional mp  ON mpcs.medical_professional_uid  = mp.uid AND mpcs.language_code = mp.language_code AND mpcs.status = mp.status " +
                "LEFT JOIN medical_professional_centre_service_hospital mpcsh  ON mpcs.uid  = mpcsh.medical_professional_centre_service_uid AND mpcs.language_code = mpcsh.language_code AND mpcs.status = mpcsh.status " +
                "LEFT JOIN hospital h ON mpcsh.hospital_uid  = h.uid  " +
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
            Map<String, Object> metadata = getCentreServiceMainMetadata(version, languageList, hospitalCode, centreServiceMain.getUid());
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
    //END - Centre Service Main Medical Professional Block

    //START - Centre Service Main Condition Block
    public List<CentreServiceMain> getCentreServiceMainCondition(Version version, List<String> languageList, String conditionUrl, String hospitalCode) {
        final String methodName = "getCentreServiceMainCondition";
        start(methodName);

        String sql ="SELECT csms.uid, csms.language_code,csms.page_title, csms.summary, csms.main_image, csms.main_image_alt_text, csms.item_url, csms.display_order, csms.publish_flag, csms.created_dt, csms.modified_dt FROM centre_service_main_sd csms " +
                "LEFT JOIN condition_disease_sd_centre_service cdscs  ON csms.uid = cdscs.centre_service_main_sd_uid AND csms.language_code = cdscs.language_code AND csms.status = cdscs.status " +
                "LEFT JOIN condition_disease_sd cds  ON cdscs.condition_disease_sd_uid  = cds.uid AND cds.language_code = cdscs.language_code AND cds.status = cdscs.status " +
                "LEFT JOIN condition_disease_sd_centre_service_hospital cdscsh ON cdscs.uid  = cdscsh.condition_disease_sd_centre_service_uid AND cdscsh.language_code = cdscs.language_code AND cdscsh.status = cdscs.status " +
                "LEFT JOIN hospital h ON cdscsh.hospital_uid  = h.uid " +
                "WHERE csms.language_code IN(<languageList>) AND cds.item_url = :item_url AND h.hospital = :hospital " +
                " AND csms.publish_flag = {PUBLISHED} GROUP BY csms.uid";

        sql = getPublishVersion(version, sql);

        List<CentreServiceMain> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionUrl).bind("hospital", hospitalCode);
            result = query.mapToBean(CentreServiceMain.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        for (CentreServiceMain centreServiceMain : result) {
            Map<String, Object> metadata = getCentreServiceMainMetadata(version, languageList, hospitalCode, centreServiceMain.getUid());
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
    //END - Centre Service Main Condition Block

    //START - Centre Service Main Treatment Block
    public List<CentreServiceMain> getCentreServiceMainTreatment(Version version, List<String> languageList, String treatmentUrl, String hospitalCode) {
        final String methodName = "getCentreServiceMainTreatment";
        start(methodName);

        String sql ="SELECT csms.uid, csms.language_code,csms.page_title, csms.summary, csms.main_image, csms.main_image_alt_text, csms.item_url, csms.display_order, csms.publish_flag, csms.created_dt, csms.modified_dt FROM centre_service_main_sd csms " +
                "LEFT JOIN test_treatment_sd_centre_service ttscs ON csms.uid = ttscs.centre_service_main_sd_uid AND csms.language_code = ttscs.language_code AND csms.status = ttscs.status " +
                "LEFT JOIN test_treatment_sd tts  ON ttscs.test_treatment_sd_uid  = tts.uid AND ttscs.language_code = tts.language_code AND ttscs.status = tts.status " +
                "LEFT JOIN test_treatment_sd_centre_service_hospital ttscsh ON ttscs.uid  = ttscsh.test_treatment_sd_centre_service_uid AND ttscs.language_code = ttscsh.language_code AND ttscs.status = ttscsh.status " +
                "LEFT JOIN hospital h ON ttscsh.hospital_uid = h.uid " +
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
            Map<String, Object> metadata = getCentreServiceMainMetadata(version, languageList, hospitalCode, centreServiceMain.getUid());
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
    //END - Centre Service Main Treatment Block

    //START - Centre Service Main Content Hub Block
    public List<CentreServiceMain> getCentreServiceMainContentHub(Version version, List<String> languageList, String contentHubMUrl, String hospitalCode){
        final String methodName = "getCentreServiceMainContentHub";
        start(methodName);

        String sql ="SELECT csms.uid, csms.language_code,csms.page_title, csms.summary, csms.main_image, csms.main_image_alt_text, csms.item_url, csms.display_order, csms.publish_flag, csms.created_dt, csms.modified_dt FROM centre_service_main_sd csms " +
                "LEFT JOIN content_hub_main_sd_centre_service chmsc ON csms.uid = chmsc.centre_service_main_sd AND csms.language_code = chmsc.language_code AND csms.status = chmsc.status " +
                "LEFT JOIN content_hub_main_sd chms  ON chmsc.content_hub_main_sd_uid  = chms.uid AND chmsc.language_code = chms.language_code AND chmsc.status = chms.status " +
                "LEFT JOIN content_hub_main_sd_centre_service_hospital chmscsh ON chmsc.uid  = chmscsh.content_hub_main_sd_centre_service_uid AND chmsc.language_code = chmscsh.language_code AND chmsc.status = chmscsh.status " +
                "LEFT JOIN hospital h ON chmscsh.hospital_uid = h.uid  " +
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
            Map<String, Object> metadata = getCentreServiceMainMetadata(version, languageList, hospitalCode, centreServiceMain.getUid());
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
    //END - Centre Service Main Content Hub Block
}
