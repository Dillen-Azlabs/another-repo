package sg.ihh.ms.sdms.app.repository;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;

import sg.ihh.ms.sdms.app.model.SpecialtyCta;
import sg.ihh.ms.sdms.app.model.Version;

import java.util.HashMap;
import java.util.List;

@Repository
public class SpecialtySdRepository extends BaseRepository{
    public SpecialtySdRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "specialty_sd");
        tableMap.put(Version.PUBLISHED.getKey(), "specialty_sd_ro");

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

}
