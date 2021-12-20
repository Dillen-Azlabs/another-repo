package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.ConditionCta;
import sg.ihh.ms.sdms.app.model.ConditionExpertise;
import sg.ihh.ms.sdms.app.model.ConditionSymptom;
import sg.ihh.ms.sdms.app.model.Version;

import java.util.HashMap;
import java.util.List;

@Repository
public class ConditionRepository extends BaseRepository {
    public ConditionRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "condition_disease");
        tableMap.put(Version.PUBLISHED.getKey(), "condition_disease_ro");

    }
    public List<ConditionCta> getCta(Version version, List<String> languageList, String conditionItemUrl) {
        final String methodName = "getDetails";
        start(methodName);

        String sql = "SELECT c.* FROM condition_disease_sd c " +
                " WHERE c.language_code IN(<languageList>) AND c.item_url = :item_url " +
                " GROUP BY c.uid, c.language_code";

        sql = getTableVersion(version, tableMap, sql);

        List<ConditionCta> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl);
            result = query.mapToBean(ConditionCta.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<ConditionSymptom> getSymptom(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getSymptom";
        start(methodName);

        String sql = "SELECT cd.*, cdsm.symptoms_meta_title,cdsm.symptoms_meta_desc FROM condition_disease_sd cd " +
                " LEFT JOIN condition_disease_sd_metadata cdsm ON cd.uid = cdsm.condition_disease_sd_uid  " +
                " LEFT JOIN hospital h ON h.uid = cdsm.hospital_uid " +
                " WHERE cd.language_code IN(<languageList>) AND cd.item_url = :item_url AND h.hospital = :hospital";

        sql = getTableVersion(version, tableMap, sql);

        List<ConditionSymptom> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl).bind("hospital", hospitalCode);
            result = query.mapToBean(ConditionSymptom.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<ConditionExpertise> getExpertise(Version version, List<String> languageList, String conditionItemUrl, String hospitalCode) {
        final String methodName = "getExpertise";
        start(methodName);

        String sql = "SELECT cd.*, cdsm.wcu,cdsm.doc_intro, cdsm.expertise_meta_title,cdsm.expertise_meta_desc FROM condition_disease_sd cd " +
                " LEFT JOIN condition_disease_sd_metadata cdsm ON cd.uid = cdsm.condition_disease_sd_uid  " +
                " LEFT JOIN hospital h ON h.uid = cdsm.hospital_uid " +
                " WHERE cd.language_code IN(<languageList>) AND cd.item_url = :item_url AND h.hospital = :hospital";

        sql = getTableVersion(version, tableMap, sql);

        List<ConditionExpertise> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", conditionItemUrl).bind("hospital", hospitalCode);
            result = query.mapToBean(ConditionExpertise.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
}
