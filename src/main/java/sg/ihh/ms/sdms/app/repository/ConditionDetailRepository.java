package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.ConditionDetail;
import sg.ihh.ms.sdms.app.model.Version;
import java.util.HashMap;
import java.util.List;

@Repository
public class ConditionDetailRepository extends BaseRepository{
    public ConditionDetailRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "condition_disease_sd");
        tableMap.put(Version.PUBLISHED.getKey(), "condition_disease_sd_ro");
    }
    public List<ConditionDetail> list(Version version, List<String> languageList) {
        return super.list(version, languageList, ConditionDetail.class);
    }
    public List<ConditionDetail> getDetails(Version version, List<String> languageList, String ConditionItemUrl, String hospitalCode) {
        final String methodName = "getDetails";
        start(methodName);

//        String sql = "SELECT cd.*,cdsm.hospital_main_image,cdsm.hospital_main_text,h.hospital FROM condition_disease_sd cd" +
//                "LEFT JOIN condition_disease_sd_metadata cdsm ON cd.uid = cdsm.condition_disease_sd_uid" +
//                "LEFT JOIN hospital h ON cdsm.hospital_uid = h.uid"+
//                " WHERE cd.language_code IN(<languageList>) AND cd.item_url = :item_url ";

        String sql = "SELECT cd.*, cdsm.hospital_main_image,cdsm.hospital_main_text,h.hospital FROM condition_disease_sd cd " +
                " LEFT JOIN condition_disease_sd_metadata cdsm ON cd.uid = cdsm.condition_disease_sd_uid  " +
                "LEFT JOIN hospital h ON cdsm.hospital_uid = h.uid"+
                " WHERE cd.language_code IN(<languageList>) AND cd.item_url = :item_url ";


        sql = getTableVersion(version, tableMap, sql);

        List<ConditionDetail> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", ConditionItemUrl);
            result = query.mapToBean(ConditionDetail.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

}
