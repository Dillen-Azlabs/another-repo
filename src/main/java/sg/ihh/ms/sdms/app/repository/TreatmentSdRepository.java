package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;

import sg.ihh.ms.sdms.app.model.*;

import java.util.HashMap;
import java.util.List;
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
