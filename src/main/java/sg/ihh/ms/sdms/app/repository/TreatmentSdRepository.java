package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;

import sg.ihh.ms.sdms.app.model.*;

import java.util.List;

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
}
