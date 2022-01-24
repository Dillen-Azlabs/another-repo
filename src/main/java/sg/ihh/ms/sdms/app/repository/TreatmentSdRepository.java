package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;

import sg.ihh.ms.sdms.app.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Map;

@Repository
public class TreatmentSdRepository extends BaseRepository{

    public TreatmentSdRepository() {
        log = getLogger(this.getClass());
    }

    public TreatmentCta getTreatmentCta(Version version, List<String> languageList, String treatmentItemUrl) {
        final String methodName = "getTreatmentCta";
        start(methodName);

        String sql = "SELECT tts.* FROM test_treatment_sd tts " +
                " WHERE tts.language_code IN(<languageList>) AND tts.item_url = :item_url " +
                " AND tts.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        TreatmentCta result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", treatmentItemUrl);
            result = query.mapToBean(TreatmentCta.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }
    //START - Treatment FAQ Block
    public TreatmentFaq getTreatmentFaq(Version version, List<String> languageList, String treatmentItemUrl) {
        final String methodName = "getTreatmentFaq";
        start(methodName);

        TreatmentFaq treatmentFaq = getTreatmentSd(version, languageList, treatmentItemUrl);

        if (treatmentFaq != null) {
            List<TreatmentSdFaq> treatmentSdFaqs = getTreatmentSdFaq(version, languageList, treatmentItemUrl);

            treatmentFaq.setFaqs(treatmentSdFaqs);
        }

        completed(methodName);
        return treatmentFaq;
    }
    private TreatmentFaq getTreatmentSd(Version version, List<String> languageList, String treatmentItemUrl) {
        String methodName = "getTreatmentSd";
        String sql = "SELECT uid, language_code, publish_flag, created_dt, modified_dt,additional_resource FROM test_treatment_sd " +
                "WHERE language_code IN(<languageList>) AND item_url = :item_url " +
                " AND publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        TreatmentFaq result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", treatmentItemUrl);
            result = query.mapToBean(TreatmentFaq.class).one();
        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        return result;
    }
    private List<TreatmentSdFaq> getTreatmentSdFaq(Version version, List<String> languageList, String treatmentItemUrl) {
        final String methodName = "getTreatmentSdFaq";
        start(methodName);

        String sql = "SELECT ttsf.question, ttsf.answer, ttsf.display_order FROM test_treatment_sd tts " +
                " LEFT JOIN test_treatment_sd_faq ttsf ON tts.uid = ttsf.test_treatment_sd_uid AND tts.language_code = ttsf.language_code " +
                " WHERE tts.language_code IN(<languageList>) AND tts.item_url = :item_url" +
                " AND tts.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<TreatmentSdFaq> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", treatmentItemUrl);
            result = query.mapToBean(TreatmentSdFaq.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }
    //END - Treatment FAQ Block
    //START - Treatment What to Expect Block
    public TreatmentWhatToExpect getTreatmentWhatToExpect(Version version, List<String> languageList, String treatmentItemUrl) {
        final String methodName = "getTreatmentWhatToExpect";
        start(methodName);

        String sql = "SELECT tts.* FROM test_treatment_sd tts " +
                " WHERE tts.language_code IN(<languageList>) AND tts.item_url = :item_url " +
                " AND tts.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        TreatmentWhatToExpect result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", treatmentItemUrl);
            result = query.mapToBean(TreatmentWhatToExpect.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }
    //END - Treatment What to Expect Block
    public TreatmentExpertise getTreatmentExpertise(Version version, List<String> languageList, String specialtyItemUrl, String hospitalCode) {
        final String methodName = "getTreatmentExpertise";
        start(methodName);

        String sql = "SELECT tts.* FROM test_treatment_sd tts " +
                " WHERE tts.language_code IN(<languageList>) AND tts.item_url = :item_url " +
                " AND tts.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        TreatmentExpertise result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl);
            result = query.mapToBean(TreatmentExpertise.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        if (result != null) {
            Map<String, Object> metadata = getMetadata(version, languageList, specialtyItemUrl, hospitalCode);

            List<String> specialties = new ArrayList<>();
            List<String> primarySpecialty = getPrimarySpecialty(version, languageList, result.getUid());
            List<String> primaryChildSpecialty = getPrimaryChildSpecialty(version, languageList, result.getUid());

            if (!primarySpecialty.isEmpty()) {

                primarySpecialty = primarySpecialty.stream()
                        .distinct()
                        .collect(Collectors.toList());
                specialties.addAll(primarySpecialty);
            }
            if (!primaryChildSpecialty.isEmpty()) {

                primaryChildSpecialty = primaryChildSpecialty.stream()
                        .distinct()
                        .collect(Collectors.toList());
                specialties.addAll(primaryChildSpecialty);
            }

            result.setWcu((String) metadata.get("wcu"));
            result.setDocIntro((String) metadata.get("doc_intro"));
            result.setSpecialties(specialties);
        }

        completed(methodName);
        return result;
    }
    private List<String> getPrimarySpecialty(Version version, List<String> languageList, String treatmentUid) {
        final String methodName = "getPrimarySpecialty";
        start(methodName);

        String sql = "SELECT s.specialty FROM specialty s " +
                "INNER JOIN test_treatment_sd tts ON tts.language_code = s.language_code " +
                "INNER JOIN test_treatment_primary_specialty ttps ON ttps.test_treatment_uid = tts.primary_treatment_uid  AND ttps.specialty_uid = s.uid " +
                "WHERE ttps.language_code IN(<languageList>) AND ttps.publish_flag = {PUBLISHED} AND tts.uid  = :uid;";

        sql = getPublishVersion(version, sql);

        List<String> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("uid", treatmentUid);
            result = query.mapTo(String.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    private List<String> getPrimaryChildSpecialty(Version version, List<String> languageList, String treatmentUid) {

        final String methodName = "getPrimaryChildSpecialty";
        start(methodName);

        String sql = "SELECT child_specialty FROM child_specialty cs " +
                "INNER JOIN test_treatment_sd tts ON tts.language_code = cs.language_code " +
                "INNER JOIN test_treatment_primary_child_specialty ttpcs ON ttpcs.test_treatment_uid = tts.primary_treatment_uid  AND ttpcs.child_specialty_uid = cs.uid " +
                "WHERE ttpcs.language_code IN(<languageList>) AND ttpcs.publish_flag = {PUBLISHED} AND tts.uid  = :uid;";

        sql = getPublishVersion(version, sql);

        List<String> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("uid", treatmentUid);
            result = query.mapTo(String.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    public Map<String, Object> getMetadata(Version version, List<String> languageList, String treatmentItemUrl, String hospitalCode) {
        final String methodName = "getMetadata";
        start(methodName);

        String sql = "SELECT ttsm.wcu, ttsm.doc_intro FROM test_treatment_sd tts " +
                " LEFT JOIN test_treatment_sd_metadata ttsm ON tts.uid = ttsm.test_treatment_sd_uid  " +
                " LEFT JOIN hospital h ON h.uid = ttsm.hospital_uid  " +
                " WHERE tts.language_code IN(<languageList>) AND tts.item_url = :item_url AND h.hospital = :hospital" +
                " AND tts.publish_flag = {PUBLISHED} " +
                "GROUP BY ttsm.test_treatment_sd_uid";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", treatmentItemUrl).bind("hospital", hospitalCode);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //START - Treatment Overview Block
    public TreatmentOverview getTreatmentOverview(Version version, List<String> languageList, String treatmentItemUrl) {
        final String methodName = "getTreatmentOverview";
        start(methodName);

        String sql = "SELECT tts.* FROM test_treatment_sd tts " +
                " WHERE tts.language_code IN(<languageList>) AND tts.item_url = :item_url "+
                " AND tts.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        TreatmentOverview result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", treatmentItemUrl);
            result = query.mapToBean(TreatmentOverview.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }
    //END - Treatment Overview Block
    //START - Treatment Detail Block
    public TreatmentDetail getTreatmentDetail(Version version, List<String> languageList, String treatmentItemUrl, String hospitalCode) {
        final String methodName = "getTreatmentDetail";
        start(methodName);

        String sql = "SELECT tts.* FROM test_treatment_sd tts " +
                " LEFT JOIN test_treatment_sd_metadata ttsm ON tts.uid = ttsm.test_treatment_sd_uid  " +
                " WHERE tts.language_code IN(<languageList>) AND tts.item_url = :item_url "+
                " AND tts.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        TreatmentDetail result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", treatmentItemUrl);
            result = query.mapToBean(TreatmentDetail.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        if (result != null) {
            Map<String, Object> metadataDetails = getMetadataDetails(version, languageList, treatmentItemUrl, hospitalCode);
            if (metadataDetails.get("hospital_main_image") != null && !metadataDetails.get("hospital_main_image").equals("")) {
                result.setMainImageUrl((String) metadataDetails.get("hospital_main_image"));
            }
            if (metadataDetails.get("hospital_main_text") != null && !metadataDetails.get("hospital_main_text").equals("")) {
                result.setMainImageAltText((String) metadataDetails.get("hospital_main_text"));
            }
            result.setMetaTitle((String) metadataDetails.get("meta_title"));
            result.setMetaDesc((String) metadataDetails.get("meta_desc"));
        }

        completed(methodName);
        return result;
    }
    public Map<String, Object> getMetadataDetails(Version version, List<String> languageList, String treatmentItemUrl, String hospitalCode) {
        final String methodName = "getMetadataDetails";
        start(methodName);

        String sql = "SELECT ttsm.hospital_main_image,ttsm.hospital_main_text,ttsm.meta_title,ttsm.meta_desc FROM test_treatment_sd tts " +
                " LEFT JOIN test_treatment_sd_metadata ttsm ON tts.uid = ttsm.test_treatment_sd_uid  " +
                "LEFT JOIN hospital h ON ttsm.hospital_uid = h.uid"+
                " WHERE tts.language_code IN(<languageList>) AND tts.item_url = :item_url AND h.hospital = :hospital"+
                " AND tts.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", treatmentItemUrl).bind("hospital", hospitalCode);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Treatment Detail Block
}
