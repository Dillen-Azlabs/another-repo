package sg.ihh.ms.sdms.app.repository;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;

import sg.ihh.ms.sdms.app.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SpecialtySdRepository extends BaseRepository{
    public SpecialtySdRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "specialty_sd");
        tableMap.put(Version.PUBLISHED.getKey(), "specialty_sd_ro");

    }

    public SpecialtyDetail getSpecialtyDetail(Version version, List<String> languageList, String specialtyItemUrl, String hospitalCode) {
        final String methodName = "getSpecialtyDetail";
        start(methodName);

        String sql = "SELECT ss.* FROM specialty_sd ss " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url ";

        sql = getTableVersion(version, tableMap, sql);

        SpecialtyDetail result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl);
            result = query.mapToBean(SpecialtyDetail.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        if (isHospitalValid(hospitalCode) && result != null) {
            Map<String, Object> metadataDetails = getMetadataDetails(version, languageList, specialtyItemUrl, hospitalCode);
            if (metadataDetails.get("hospital_main_image") != null) {
                result.setMainImageUrl((String) metadataDetails.get("hospital_main_image"));
            }
            if (metadataDetails.get("hospital_main_text") != null) {
                result.setMainImageAltText((String) metadataDetails.get("hospital_main_text"));
            }
        }

        completed(methodName);
        return result;
    }

    public Map<String, Object> getMetadataDetails(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getMetadataDetails";
        start(methodName);

        String sql = "SELECT ssm.hospital_main_image,ssm.hospital_main_text FROM specialty_sd ss " +
                " LEFT JOIN specialty_sd_metadata ssm ON ss.uid = ssm.specialty_sd_uid  " +
                "LEFT JOIN hospital h ON ssm.hospital_uid = h.uid"+
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url AND h.hospital = :hospital";

        sql = getTableVersion(version, tableMap, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl).bind("hospital", hospitalCode);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public SpecialtyCta getSpecialtyCta(Version version, List<String> languageList, String specialtyItemUrl) {
        final String methodName = "getSpecialtyCta";
        start(methodName);

        String sql = "SELECT ss.* FROM specialty_sd ss " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url ";

        sql = getTableVersion(version, tableMap, sql);

        SpecialtyCta result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl);
            result = query.mapToBean(SpecialtyCta.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    private boolean isHospitalValid(String hospitalCode) {
        final String methodName = "isHospitalValid";
        start(methodName);

        String sql = "SELECT uid FROM hospital " +
                " WHERE hospital = :hospital";

        String hospitalUid = "";

        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bind("hospital", hospitalCode);
            hospitalUid = query.mapTo(String.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);

        return !hospitalUid.isEmpty();
    }

    public SpecialtyOverview getSpecialtyOverview(Version version, List<String> languageList, String specialtyItemUrl, String hospitalCode) {
        final String methodName = "getSpecialtyOverview";
        start(methodName);

        String sql = "SELECT ss.* FROM specialty_sd ss " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url ";

        sql = getTableVersion(version, tableMap, sql);

        SpecialtyOverview result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl);
            result = query.mapToBean(SpecialtyOverview.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        // these 2 fields need to set separately as they should be null when hospitalCode dont match.
        // the other fields should still display if the hospitalCode doesn't match
        if (result != null) {
            Map<String, Object> metadata = getMetadata(version, languageList, specialtyItemUrl, hospitalCode);
            result.setOverviewMetaTitle((String) metadata.get("overview_meta_title"));
            result.setOverviewMetaDesc((String) metadata.get("overview_meta_desc"));
            result.setOai((String) metadata.get("oai"));
            result.setOavu((String) metadata.get("oavu"));
            result.setWcu((String) metadata.get("wcu"));
            result.setWcuvu((String) metadata.get("wcuvu"));
        }

        completed(methodName);
        return result;
    }

    public Map<String, Object> getMetadata(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getMetadata";
        start(methodName);

        String sql = "SELECT ssm.overview_meta_title,ssm.overview_meta_desc, ssm.oai,ssm.oavu,ssm.wcu,ssm.wcuvu FROM specialty_sd ss " +
                " LEFT JOIN specialty_sd_metadata ssm ON ss.uid = ssm.specialty_sd_uid  " +
                " LEFT JOIN hospital h ON h.uid = ssm.hospital_uid  " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url AND h.hospital = :hospital";

        sql = getTableVersion(version, tableMap, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl).bind("hospital", hospitalCode);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public SpecialtyRelatedCondition getSpecialtyRelatedCondition(Version version, List<String> languageList, String specialtyItemUrl, String hospitalCode) {
        final String methodName = "getSpecialtyRelatedCondition";
        start(methodName);

        String sql = "SELECT ss.* FROM specialty_sd ss " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url ";

        sql = getTableVersion(version, tableMap, sql);

        SpecialtyRelatedCondition result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl);
            result = query.mapToBean(SpecialtyRelatedCondition.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        // these 2 fields need to set separately as they should be null when hospitalCode dont match.
        // the other fields should still display if the hospitalCode doesn't match
        if (result != null) {
            Map<String, Object> metadata = getSpecialtyRelatedConditionMetadata(version, languageList, specialtyItemUrl, hospitalCode);
            result.setRelatedConditionMetaTitle((String) metadata.get("related_condition_meta_title"));
            result.setRelatedConditionMetaDesc((String) metadata.get("related_condition_meta_desc"));
        }

        completed(methodName);
        return result;
    }

    private Map<String, Object> getSpecialtyRelatedConditionMetadata(Version version, List<String> languageList, String specialtyItemUrl, String hospitalCode) {
        final String methodName = "getSpecialtyRelatedConditionMetadata";
        start(methodName);

        String sql = "SELECT ssm.related_condition_meta_title,ssm.related_condition_meta_desc FROM specialty_sd ss " +
                " LEFT JOIN specialty_sd_metadata ssm ON ss.uid = ssm.specialty_sd_uid  " +
                " LEFT JOIN hospital h ON h.uid = ssm.hospital_uid  " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url AND h.hospital = :hospital";

        sql = getTableVersion(version, tableMap, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl).bind("hospital", hospitalCode);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public SpecialtyRelatedTreatment getSpecialtyRelatedTreatment(Version version, List<String> languageList, String specialtyItemUrl, String hospitalCode) {
        final String methodName = "getSpecialtyRelatedTreatment";
        start(methodName);

        String sql = "SELECT ss.* FROM specialty_sd ss " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url ";

        sql = getTableVersion(version, tableMap, sql);

        SpecialtyRelatedTreatment result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl);
            result = query.mapToBean(SpecialtyRelatedTreatment.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        // these 2 fields need to set separately as they should be null when hospitalCode dont match.
        // the other fields should still display if the hospitalCode doesn't match
        if (result != null) {
            Map<String, Object> metadata = getSpecialtyRelatedTreatmentMetadata(version, languageList, specialtyItemUrl, hospitalCode);
            result.setRelatedTreatmentMetaTitle((String) metadata.get("related_treatment_meta_title"));
            result.setRelatedTreatmentMetaDesc((String) metadata.get("related_treatment_meta_desc"));
            result.setRelatedTreatmentContent((String) metadata.get("related_treatment_content"));
        }

        completed(methodName);
        return result;
    }

    private Map<String, Object> getSpecialtyRelatedTreatmentMetadata(Version version, List<String> languageList, String specialtyItemUrl, String hospitalCode) {
        final String methodName = "getSpecialtyRelatedTreatmentMetadata";
        start(methodName);

        String sql = "SELECT ssm.related_treatment_meta_title, ssm.related_treatment_meta_desc, ssm.related_treatment_content FROM specialty_sd ss " +
                " LEFT JOIN specialty_sd_metadata ssm ON ss.uid = ssm.specialty_sd_uid  " +
                " LEFT JOIN hospital h ON h.uid = ssm.hospital_uid  " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url AND h.hospital = :hospital";

        sql = getTableVersion(version, tableMap, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl).bind("hospital", hospitalCode);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public SpecialtyExpertise getSpecialtyExpertise(Version version, List<String> languageList, String specialtyItemUrl, String hospitalCode) {
        final String methodName = "getSpecialtyExpertise";
        start(methodName);

        String sql = "SELECT ss.* FROM specialty_sd ss " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url ";

        sql = getTableVersion(version, tableMap, sql);

        SpecialtyExpertise result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl);
            result = query.mapToBean(SpecialtyExpertise.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        // these 2 fields need to set separately as they should be null when hospitalCode dont match.
        // the other fields should still display if the hospitalCode doesn't match
        if (result != null) {
            Map<String, Object> metadata = getMetadataOurDoc(version, languageList, specialtyItemUrl, hospitalCode);
            result.setOurDocMetaTitle((String) metadata.get("our_doc_meta_title"));
            result.setOurDocMetaDesc((String) metadata.get("our_doc_meta_desc"));
            result.setOurDocIntro((String) metadata.get("our_doc_intro"));
        }

        completed(methodName);
        return result;
    }

    public Map<String, Object> getMetadataOurDoc(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getMetadata";
        start(methodName);

        String sql = "SELECT ssm.our_doc_meta_title,ssm.our_doc_meta_desc, ssm.our_doc_intro FROM specialty_sd ss " +
                " LEFT JOIN specialty_sd_metadata ssm ON ss.uid = ssm.specialty_sd_uid  " +
                " LEFT JOIN hospital h ON h.uid = ssm.hospital_uid  " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url AND h.hospital = :hospital";

        sql = getTableVersion(version, tableMap, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl).bind("hospital", hospitalCode);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    private SpecialtyFaq getSpecialty(Version version, List<String> languageList,String specialtyItemUrl, String hospitalCode)
    {
        String methodName = "getSpecialty";
        String sql = "SELECT uid, language_code, publish_flag, created_dt, modified_dt,additional_resource FROM specialty_sd " +
                "WHERE language_code IN(<languageList>) AND item_url = :item_url;";
        sql = getTableVersion(version, tableMap, sql);

        SpecialtyFaq result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl);
            result = query.mapToBean(SpecialtyFaq.class).one();
        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }
        return result;
    }

    public SpecialtyFaq getSpecialtyFaq(Version version, List<String> languageList, String specialtyItemUrl,String hospitalCode) {
        final String methodName = "getFaq";
        start(methodName);

        SpecialtyFaq specialtyFaq = getSpecialty(version, languageList, specialtyItemUrl, hospitalCode);

        if (specialtyFaq != null) {
            List<SpecialtySdFaq> specialtySdFaqs = getSpecialtySdFaq(version, languageList, specialtyItemUrl, hospitalCode);

            specialtyFaq.setFaqs(specialtySdFaqs);
        }
        Map<String, Object> metadataFaq = getMetadataFaq(version, languageList, specialtyItemUrl, hospitalCode);
        SpecialtyFaq result = new SpecialtyFaq();

        result.setFaqTitle((String) metadataFaq.get("faq_title"));
        result.setFaqDesc((String) metadataFaq.get("faq_desc"));

        completed(methodName);
        return specialtyFaq;
    }
    private List<SpecialtySdFaq> getSpecialtySdFaq(Version version, List<String> languageList, String specialtyItemUrl, String hospitalCode)
    {
        final String methodName = "getSpecialtySdFaq";
        start(methodName);

        String sql = "SELECT ss.*, ssf.question, ssf.answer FROM specialty_sd ss " +
                " LEFT JOIN specialty_sd_faq ssf ON ss.uid = ssf.specialty_sd_uid  " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url ";

        sql = getTableVersion(version, tableMap, sql);

        List<SpecialtySdFaq> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl);
            result = query.mapToBean(SpecialtySdFaq.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }


    public Map<String, Object> getMetadataFaq(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getFaq";
        start(methodName);

        String sql = "SELECT ssm.faq_title, ssm.faq_desc FROM specialty_sd ss " +
                " LEFT JOIN specialty_sd_metadata ssm ON ss.uid = ssm.specialty_sd_uid  " +
                " LEFT JOIN hospital h ON h.uid = ssm.hospital_uid " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url AND h.hospital = :hospital";

        sql = getTableVersion(version, tableMap, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl).bind("hospital", hospitalCode);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
}
