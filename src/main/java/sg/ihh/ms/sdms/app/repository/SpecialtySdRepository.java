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
public class SpecialtySdRepository extends BaseRepository{
    public SpecialtySdRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "specialty_sd");
        tableMap.put(Version.PUBLISHED.getKey(), "specialty_sd_ro");

    }

    public List<SpecialtyDetail> getSpecialtyDetail(Version version, List<String> languageList, String specialtyItemUrl, String hospitalCode) {
        final String methodName = "getSpecialtyDetail";
        start(methodName);

        String sql = "SELECT ss.* FROM specialty_sd ss " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url ";

        sql = getTableVersion(version, tableMap, sql);

        List<SpecialtyDetail> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl);
            result = query.mapToBean(SpecialtyDetail.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        if (isHospitalValid(hospitalCode)) {
            for (SpecialtyDetail detail : result) {
                Map<String, Object> metadataDetails = getMetadataDetails(version, languageList, specialtyItemUrl, hospitalCode);
                if (metadataDetails.get("hospital_main_image") != null) {
                    detail.setMainImageUrl((String) metadataDetails.get("hospital_main_image"));
                }
                if (metadataDetails.get("hospital_main_text") != null) {
                    detail.setMainImageAltText((String) metadataDetails.get("hospital_main_text"));
                }
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

    public List<SpecialtyCta> getSpecialtyCta(Version version, List<String> languageList, String specialtyItemUrl) {
        final String methodName = "getSpecialtyCta";
        start(methodName);

        String sql = "SELECT ss.* FROM specialty_sd ss " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url ";

        sql = getTableVersion(version, tableMap, sql);

        List<SpecialtyCta> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl);
            result = query.mapToBean(SpecialtyCta.class).list();

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

    public List<SpecialtyOverview> getSpecialtyOverview(Version version, List<String> languageList, String specialtyItemUrl, String hospitalCode) {
        final String methodName = "getSpecialtyOverview";
        start(methodName);

        String sql = "SELECT ss.*, ssm.oai,ssm.oavu,ssm.wcu,ssm.wcuvu FROM specialty_sd ss " +
                " LEFT JOIN specialty_sd_metadata ssm ON ss.uid = ssm.specialty_sd_uid  " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url ";

        sql = getTableVersion(version, tableMap, sql);

        List<SpecialtyOverview> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl);
            result = query.mapToBean(SpecialtyOverview.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        // these 2 fields need to set separately as they should be null when hospitalCode dont match.
        // the other fields should still display if the hospitalCode doesn't match
        for(SpecialtyOverview overview : result) {
            Map<String, Object> metadata = getMetadata(version, languageList, specialtyItemUrl, hospitalCode);
            overview.setOverviewMetaTitle((String) metadata.get("overview_meta_title"));
            overview.setOverviewMetaDesc((String) metadata.get("overview_meta_desc"));
        }
        completed(methodName);
        return result;
    }

    public Map<String, Object> getMetadata(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getMetadata";
        start(methodName);

        String sql = "SELECT ssm.overview_meta_title,ssm.overview_meta_desc FROM specialty_sd ss " +
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

    public List<SpecialtyExpertise> getSpecialtyExpertise(Version version, List<String> languageList, String specialtyItemUrl, String hospitalCode) {
        final String methodName = "getSpecialtyExpertise";
        start(methodName);

        String sql = "SELECT ss.*, ssm.our_doc_intro FROM specialty_sd ss " +
                " LEFT JOIN specialty_sd_metadata ssm ON ss.uid = ssm.specialty_sd_uid  " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url ";

        sql = getTableVersion(version, tableMap, sql);

        List<SpecialtyExpertise> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl);
            result = query.mapToBean(SpecialtyExpertise.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        // these 2 fields need to set separately as they should be null when hospitalCode dont match.
        // the other fields should still display if the hospitalCode doesn't match
        for(SpecialtyExpertise expertise : result) {
            Map<String, Object> metadata = getMetadataOurDoc(version, languageList, specialtyItemUrl, hospitalCode);
            expertise.setOurDocMetaTitle((String) metadata.get("our_doc_meta_title"));
            expertise.setOurDocMetaDesc((String) metadata.get("our_doc_meta_desc"));
        }

        completed(methodName);
        return result;
    }

    public Map<String, Object> getMetadataOurDoc(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getMetadata";
        start(methodName);

        String sql = "SELECT ssm.our_doc_meta_title,ssm.our_doc_meta_desc FROM specialty_sd ss " +
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

    public List<SpecialtyFaq> getSpecialtyFaq(Version version, List<String> languageList, String specialtyItemUrl, String hospitalCode) {
        final String methodName = "getSpecialtyFaq";
        start(methodName);

        String sql = "SELECT ss.*, ssf.question, ssf.answer FROM specialty_sd ss " +
                " LEFT JOIN specialty_sd_faq ssf ON ss.uid = ssf.specialty_sd_uid  " +
                " WHERE ss.language_code IN(<languageList>) AND ss.item_url = :item_url ";


        sql = getTableVersion(version, tableMap, sql);

        List<SpecialtyFaq> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", specialtyItemUrl);
            result = query.mapToBean(SpecialtyFaq.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        // these 2 fields need to set separately as they should be null when hospitalCode dont match.
        // the other fields should still display if the hospitalCode doesn't match
        for(SpecialtyFaq faq : result) {
            Map<String, Object> metadata = getMetadataFaq(version, languageList, specialtyItemUrl, hospitalCode);
            faq.setFaqTitle((String) metadata.get("faq_title"));
            faq.setFaqDesc((String) metadata.get("faq_desc"));
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
