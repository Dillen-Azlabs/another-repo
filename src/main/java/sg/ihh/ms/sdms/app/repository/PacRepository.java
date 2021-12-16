package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.Pac;
import sg.ihh.ms.sdms.app.model.Version;

import java.util.HashMap;
import java.util.List;

@Repository
public class PacRepository extends BaseRepository {

    public PacRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "patient_assistance_centre");
        tableMap.put(Version.PUBLISHED.getKey(), "patient_assistance_centre_ro");
    }

    public List<Pac> list(Version version, List<String> languageList) {
        return super.list(version, languageList, Pac.class);
    }

    public List<Pac> searchByCountry(Version version, List<String> languageList, String country) {
        final String methodName = "list";
        start(methodName);

        String sql = "SELECT pac.*, c.country FROM patient_assistance_centre pac LEFT JOIN country c ON pac.country_uid = c.uid WHERE pac.language_code IN(<languageList>) AND c.country = country;";

        sql = getTableVersion(version, tableMap, sql);

        List<Pac> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("country", country);
            result = query.mapToBean(Pac.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<Pac> searchPacByItemUrl(Version version, List<String> languageList, String itemUrl, String excludeCountry) {
        final String methodName = "searchByItemUrl";
        start(methodName);

        String sql = "SELECT pac.*, mp.display_name, c.country FROM patient_assistance_centre pac " +
                        "LEFT JOIN medical_professional_pac mppac ON pac.uid = mppac.pac_uid " +
                        "LEFT JOIN medical_professional mp ON mppac.medical_professional_uid = mp.uid " +
                        "LEFT JOIN country c ON c.uid = pac.country_uid " +
                        "WHERE pac.language_code IN(<languageList>) AND mp.item_url = :item_url AND c.country <> :exclude_country";

        sql = getTableVersion(version, tableMap, sql);

        List<Pac> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", itemUrl).bind("exclude_country", excludeCountry);
            result = query.mapToBean(Pac.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
}
