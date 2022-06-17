package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.Pac;
import sg.ihh.ms.sdms.app.model.Version;

import java.util.List;

@Repository
public class PacRepository extends BaseRepository {

    public PacRepository() {
        log = getLogger(this.getClass());
        tableName = "patient_assistance_centre";
    }

    public List<Pac> list(Version version, List<String> languageList) {
        final String methodName = "list";
        start(methodName);

        String sql = "SELECT pac.*, c.country FROM patient_assistance_centre pac " +
                " LEFT JOIN country c ON pac.country_uid = c.uid " +
                " WHERE pac.language_code IN(<languageList>) " +
                " AND pac.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<Pac> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList);
            result = query.mapToBean(Pac.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<Pac> searchByCountry(Version version, List<String> languageList, String country) {
        final String methodName = "searchByCountry";
        start(methodName);

        String sql = "SELECT pac.*, c.country FROM patient_assistance_centre pac " +
                " LEFT JOIN country c ON pac.country_uid = c.uid " +
                " WHERE pac.language_code IN(<languageList>) AND c.country = :country " +
                " AND pac.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

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
                        "LEFT JOIN medical_professional_pac mppac ON pac.uid = mppac.pac_uid AND pac.language_code = mppac.language_code AND pac.status = mppac.status " +
                        "LEFT JOIN medical_professional mp ON mppac.medical_professional_uid = mp.uid AND mppac.language_code = mp.language_code AND mppac.status = mp.status " +
                        "LEFT JOIN country c ON c.uid = pac.country_uid " +
                        "WHERE pac.language_code IN(<languageList>) AND mp.item_url = :item_url AND c.country <> :exclude_country" +
                        " AND pac.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

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
