package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ConditionRepository extends BaseRepository {
    public ConditionRepository() {
        log = getLogger(this.getClass());
    }

    public ConditionDetail getDetails(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getDetails";
        start(methodName);

        String sql = "SELECT cd.* FROM condition_disease_sd cd " +
                " WHERE cd.language_code IN(<languageList>) AND cd.item_url = :item_url " +
                " AND cd.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        ConditionDetail result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl);
            result = query.mapToBean(ConditionDetail.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        if (isHospitalValid(hospitalCode)) {
            Map<String, Object> metadataDetails = getMetadataDetails(version, languageList, conditionItemUrl, hospitalCode);
            if (metadataDetails.get("hospital_main_image") != null && !metadataDetails.get("hospital_main_image").equals("")){
                result.setMainImageUrl((String) metadataDetails.get("hospital_main_image"));
            }
            if (metadataDetails.get("hospital_main_text") != null && !metadataDetails.get("hospital_main_text").equals("")) {
                result.setMainImageAltText((String) metadataDetails.get("hospital_main_text"));
            }
        }

        completed(methodName);
        return result;
    }

    public Map<String, Object> getMetadataDetails(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getMetadataDetails";
        start(methodName);

        String sql = "SELECT cdsm.hospital_main_image, cdsm.hospital_main_text FROM condition_disease_sd cd " +
                " LEFT JOIN condition_disease_sd_metadata cdsm ON cd.uid = cdsm.condition_disease_sd_uid  " +
                "LEFT JOIN hospital h ON cdsm.hospital_uid = h.uid"+
                " WHERE cd.language_code IN(<languageList>) AND cd.item_url = :item_url AND h.hospital = :hospital" +
                " AND cd.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

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

    public ConditionCta getCta(Version version, List<String> languageList, String conditionItemUrl) {
        final String methodName = "getDetails";
        start(methodName);

        String sql = "SELECT c.* FROM condition_disease_sd c " +
                " WHERE c.language_code IN(<languageList>) AND c.item_url = :item_url " +
                " GROUP BY c.uid, c.language_code" +
                " AND c.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        ConditionCta result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl);
            result = query.mapToBean(ConditionCta.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public ConditionSymptom getSymptom(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getSymptom";
        start(methodName);

        String sql = "SELECT cd.* FROM condition_disease_sd cd " +
                " WHERE cd.language_code IN(<languageList>) AND cd.item_url = :item_url" +
                " AND cd.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        ConditionSymptom result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl);
            result = query.mapToBean(ConditionSymptom.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        // these 2 fields need to set separately as they should be null when hospitalCode dont match.
        // the other fields should still display if the hospitalCode doesn't match
        if (result != null) {
            Map<String, Object> metadata = getSymptomMetadata(version, languageList, conditionItemUrl, hospitalCode);
            result.setSymptomsMetaTitle((String) metadata.get("symptoms_meta_title"));
            result.setSymptomsMetaDesc((String) metadata.get("symptoms_meta_desc"));
        }

        completed(methodName);
        return result;
    }

    public Map<String, Object> getSymptomMetadata(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getSymptomMetadata";
        start(methodName);

        String sql = "SELECT cdsm.symptoms_meta_title, cdsm.symptoms_meta_desc FROM condition_disease_sd cd " +
                " LEFT JOIN condition_disease_sd_metadata cdsm ON cd.uid = cdsm.condition_disease_sd_uid  " +
                " LEFT JOIN hospital h ON h.uid = cdsm.hospital_uid " +
                " WHERE cd.language_code IN(<languageList>) AND cd.item_url = :item_url AND h.hospital = :hospital " +
                " AND cd.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

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

    public ConditionDiagnosis getDiagnosis(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getDiagnosis";
        start(methodName);

        String sql = "SELECT cd.* FROM condition_disease_sd cd " +
                " WHERE cd.language_code IN(<languageList>) AND cd.item_url = :item_url" +
                " AND cd.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        ConditionDiagnosis result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl);
            result = query.mapToBean(ConditionDiagnosis.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        // these 2 fields need to set separately as they should be null when hospitalCode dont match.
        // the other fields should still display if the hospitalCode doesn't match
        if (result != null) {
            Map<String, Object> metadata = getDiagnosisMetadata(version, languageList, conditionItemUrl, hospitalCode);
            result.setDiagnosisMetaTitle((String) metadata.get("diagnosis_meta_title"));
            result.setDiagnosisMetaDesc((String) metadata.get("diagnosis_meta_desc"));
        }

        completed(methodName);
        return result;
    }

    public Map<String, Object> getDiagnosisMetadata(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getDiagnosisMetadata";
        start(methodName);

        String sql = "SELECT cdsm.diagnosis_meta_title,cdsm.diagnosis_meta_desc FROM condition_disease_sd cd " +
                " LEFT JOIN condition_disease_sd_metadata cdsm ON cd.uid = cdsm.condition_disease_sd_uid  " +
                " LEFT JOIN hospital h ON h.uid = cdsm.hospital_uid " +
                " WHERE cd.language_code IN(<languageList>) AND cd.item_url = :item_url AND h.hospital = :hospital" +
                " AND cd.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

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

    public ConditionExpertise getConditionExpertise(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getConditionExpertise";
        start(methodName);

        ConditionExpertise conditionExpertise = getConditionDiseaseSd(version, languageList, conditionItemUrl);

        if (conditionExpertise != null) {
            Map<String, Object> metadata = getExpertiseMetadata(version, languageList, conditionItemUrl, hospitalCode);
            conditionExpertise.setExpertiseMetaTitle((String) metadata.get("expertise_meta_title"));
            conditionExpertise.setExpertiseMetaDesc((String) metadata.get("expertise_meta_desc"));
            conditionExpertise.setWcu((String) metadata.get("wcu"));
            conditionExpertise.setDocIntro((String) metadata.get("doc_intro"));

            List<String> specialties = new ArrayList<>();
            List<String> primarySpecialty = getPrimarySpecialty(version, languageList,conditionExpertise.getUid());
            List<String> specialty = getSpecialty(version, languageList,conditionExpertise.getUid());
            List<String> childSpecialty  = getChildSpecialty(version, languageList,conditionExpertise.getUid());
            if (!primarySpecialty.isEmpty()) {

                primarySpecialty = primarySpecialty.stream()
                        .distinct()
                        .collect(Collectors.toList());
                specialties.addAll(primarySpecialty);
            }
            if (!specialty.isEmpty()) {

                specialty = specialty.stream()
                        .distinct()
                        .collect(Collectors.toList());
                specialties.addAll(specialty);
            }
            if (!childSpecialty.isEmpty()) {

                childSpecialty = childSpecialty.stream()
                        .distinct()
                        .collect(Collectors.toList());
                specialties.addAll(childSpecialty);
            }
            conditionExpertise.setSpecialties(specialties);
        }
        completed(methodName);
        return conditionExpertise;
    }
    public ConditionExpertise getConditionDiseaseSd(Version version, List<String> languageList, String conditionItemUrl) {
        final String methodName = "getConditionDiseaseSd";
        start(methodName);

        String sql = "SELECT uid, language_code, publish_flag, created_dt, modified_dt FROM condition_disease_sd  " +
                " WHERE language_code IN(<languageList>) AND item_url = :item_url" +
                " AND publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        ConditionExpertise result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl);
            result = query.mapToBean(ConditionExpertise.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    private List<String> getPrimarySpecialty(Version version, List<String> languageList,String conditionDiseaseUid)
    {
        final String methodName = "getPrimarySpecialty";
        start(methodName);

        String sql = "SELECT s.specialty FROM specialty s " +
                "LEFT JOIN condition_disease_sd cds ON cds.language_code = s.language_code AND cds.primary_specialty_uid  = s.uid " +
                "WHERE cds.language_code IN(<languageList>) AND cds.publish_flag = {PUBLISHED} AND cds.uid  = :uid";

        sql = getPublishVersion(version, sql);

        List<String> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("uid", conditionDiseaseUid);
            result = query.mapTo(String.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    private List<String> getSpecialty(Version version, List<String> languageList,String conditionDiseaseUid)
    {
        final String methodName = "getSpecialty";
        start(methodName);

        String sql = "SELECT s.specialty FROM specialty s " +
                "INNER JOIN condition_disease_sd cds ON cds.language_code = s.language_code " +
                "INNER JOIN condition_disease_sd_other_specialty cdsos ON cdsos.condition_disease_sd_uid = cds.uid AND cdsos.specialty_uid = s.uid " +
                "WHERE cdsos.language_code IN(<languageList>) AND cdsos.publish_flag = {PUBLISHED} AND cds.uid  = :uid;";

        sql = getPublishVersion(version, sql);

        List<String> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("uid", conditionDiseaseUid);
            result = query.mapTo(String.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    private List<String> getChildSpecialty(Version version, List<String> languageList,String conditionDiseaseUid)
    {
        final String methodName = "getChildSpecialty";
        start(methodName);

        String sql = "SELECT cs.child_specialty from child_specialty cs " +
                "INNER JOIN condition_disease_sd cds ON cds.language_code = cs.language_code " +
                "INNER JOIN condition_disease_sd_other_child_specialty cdsocs ON cdsocs.condition_disease_sd_uid = cds.uid AND cdsocs.child_specialty_uid = cs.uid " +
                "WHERE cdsocs.language_code IN(<languageList>) AND cdsocs.publish_flag = {PUBLISHED} AND cds.uid  = :uid;";

        sql = getPublishVersion(version, sql);

        List<String> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("uid", conditionDiseaseUid);
            result = query.mapTo(String.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    public Map<String, Object> getExpertiseMetadata(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getExpertiseMetadata";
        start(methodName);

        String sql = "SELECT cdsm.expertise_meta_title, cdsm.expertise_meta_desc,cdsm.wcu, cdsm.doc_intro FROM condition_disease_sd cd " +
                " LEFT JOIN condition_disease_sd_metadata cdsm ON cd.uid = cdsm.condition_disease_sd_uid  " +
                " LEFT JOIN hospital h ON h.uid = cdsm.hospital_uid " +
                " WHERE cd.language_code IN(<languageList>) AND cd.item_url = :item_url AND h.hospital = :hospital" +
                " AND cd.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

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
    private ConditionFaq getCondition(Version version, List<String> languageList,String conditionItemUrl, String hospitalCode)
    {
        String methodName = "getCondition";
        String sql = "SELECT uid, language_code, publish_flag, created_dt, modified_dt,additional_resource FROM condition_disease_sd " +
                "WHERE language_code IN(<languageList>) AND item_url = :item_url" +
                " AND publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        ConditionFaq result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl);
            result = query.mapToBean(ConditionFaq.class).one();
        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }
        if (result != null) {
            Map<String, Object> metadataFaq = getMetadataFaq(version, languageList, conditionItemUrl, hospitalCode);
            result.setFaqTitle((String) metadataFaq.get("faq_title"));
            result.setFaqDesc((String) metadataFaq.get("faq_desc"));
        }
        return result;
    }


    public ConditionFaq getConditionFaq(Version version, List<String> languageList, String conditionItemUrl,String hospitalCode) {
        final String methodName = "getConditionFaq";
        start(methodName);

        ConditionFaq conditionFaq = getCondition(version, languageList, conditionItemUrl, hospitalCode);

        if (conditionFaq != null) {
            List<ConditionSdFaq> conditionSdFaqs = getConditionSdFaq(version, languageList, conditionItemUrl);

            conditionFaq.setFaqs(conditionSdFaqs);
        }

        completed(methodName);
        return conditionFaq;
    }

    private List<ConditionSdFaq> getConditionSdFaq(Version version, List<String> languageList, String conditionItemUrl)
    {
        final String methodName = "getConditionSdFaq";
        start(methodName);

        String sql = "SELECT cdsf.question, cdsf.answer, cdsf.display_order FROM condition_disease_sd cd " +
                " LEFT JOIN condition_disease_sd_faq cdsf ON cd.uid = cdsf.condition_disease_sd_uid  " +
                " WHERE cd.language_code IN(<languageList>) AND cd.item_url = :item_url" +
                " AND cd.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<ConditionSdFaq> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl);
            result = query.mapToBean(ConditionSdFaq.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }

    public Map<String, Object> getMetadataFaq(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getFaq";
        start(methodName);

        String sql = "SELECT cdsm.faq_title,cdsm.faq_desc FROM condition_disease_sd cd " +
                " LEFT JOIN condition_disease_sd_metadata cdsm ON cd.uid = cdsm.condition_disease_sd_uid  " +
                " LEFT JOIN hospital h ON h.uid = cdsm.hospital_uid " +
                " WHERE cd.language_code IN(<languageList>) AND cd.item_url = :item_url AND h.hospital = :hospital" +
                " AND cd.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

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

    public ConditionRelatedData getConditionRelatedData(Version version, List<String> languageList, String conditionItemUrl) {
        final String methodName = "getConditionRelatedData";
        start(methodName);

        ConditionRelatedData conditionRelatedData = getConditionDisease(version, languageList, conditionItemUrl);

        if (conditionRelatedData != null) {
            List<ConditionRelatedDataCondition> relatedConditions = getRelatedDataConditions(version,conditionRelatedData.getUid());
            List<ConditionRelatedDataTreatment> relatedTreatments = getRelatedTreatments(version, conditionRelatedData.getUid());

            conditionRelatedData.setRelatedCondition(relatedConditions);
            conditionRelatedData.setRelatedTreatments(relatedTreatments);
        }

        completed(methodName);
        return conditionRelatedData;
    }

    private ConditionRelatedData getConditionDisease(Version version, List<String> languageList,String conditionItemUrl)
    {
        String methodName = "getConditionDisease";
        String sql = "SELECT uid, language_code, publish_flag, created_dt, modified_dt FROM condition_disease_sd " +
                "WHERE language_code IN(<languageList>) AND item_url = :item_url" +
                " AND publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        ConditionRelatedData result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl);
            result = query.mapToBean(ConditionRelatedData.class).one();
        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }
        return result;
    }

    private List<ConditionRelatedDataCondition> getRelatedDataConditions(Version version, String uid)
    {
        String methodName = "getRelatedCondition";
        String relatedConditionSql = "SELECT condition_disease_uid FROM condition_disease_sd_related_condition cdsdrc " +
                " LEFT JOIN condition_disease_sd cd ON cd.uid = cdsdrc.condition_disease_sd_uid " +
                " WHERE cdsdrc.condition_disease_sd_uid =:uid " +
                " AND cd.publish_flag = {PUBLISHED}";

        String conditionDiseaseSql = "SELECT item_url, condition_h1_display FROM condition_disease_sd " +
                " WHERE primary_condition_uid = :primaryUid " +
                " AND publish_flag = {PUBLISHED}";

        relatedConditionSql = getPublishVersion(version, relatedConditionSql);
        conditionDiseaseSql = getPublishVersion(version, conditionDiseaseSql);

        List<ConditionRelatedDataCondition> result = new ArrayList<>();

        try (Handle h = getHandle()) {

            List<String> conditionUid = new ArrayList<>();
            Query query1 = h.createQuery(relatedConditionSql);
            query1.bind("uid", uid);
            conditionUid = query1.mapTo(String.class).list();
            if (!conditionUid.isEmpty()) {
                for (String primaryUid : conditionUid) {
                    Query query2 = h.createQuery(conditionDiseaseSql);
                    query2.bind("primaryUid", primaryUid);
                    result = query2.mapToBean(ConditionRelatedDataCondition.class).list();
                }
            }

        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }
        return result;
    }

    private List<ConditionRelatedDataTreatment> getRelatedTreatments(Version version,String uid)
    {
        String methodName = "getRelatedTreatments";
        String relatedTreatmentSql = "SELECT test_treatment_sd_uid FROM condition_disease_sd_related_treatment cdsdrt " +
                " LEFT JOIN condition_disease_sd cd ON cd.uid = cdsdrt.condition_disease_sd_uid " +
                " WHERE cdsdrt.condition_disease_sd_uid = :uid " +
                " AND cd.publish_flag = {PUBLISHED} ";

        String treatmentSql = "SELECT item_url, treatment_h1_display FROM test_treatment_sd " +
                " WHERE  primary_treatment_uid = :primaryUid " +
                " AND publish_flag = {PUBLISHED}";

        relatedTreatmentSql = getPublishVersion(version, relatedTreatmentSql);
        treatmentSql = getPublishVersion(version, treatmentSql);

        List<ConditionRelatedDataTreatment> result = new ArrayList<>();

        try (Handle h = getHandle()) {

            List<String> conditionUid = new ArrayList<>();
            Query query1 = h.createQuery(relatedTreatmentSql);
            query1.bind("uid", uid);
            conditionUid = query1.mapTo(String.class).list();
            if (!conditionUid.isEmpty()) {
                for (String primaryUid : conditionUid) {
                    Query query2 = h.createQuery(treatmentSql);
                    query2.bind("primaryUid", primaryUid);
                    result = query2.mapToBean(ConditionRelatedDataTreatment.class).list();
                }
            }
        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }
        return result;
    }
}
