package sg.ihh.ms.sdms.app.repository;

import java.util.List;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;

import sg.ihh.ms.sdms.app.model.Pac;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class HPacRepository extends BaseRepository {

    public HPacRepository() {
        log = getLogger(this.getClass());
        tableName = "patient_assistance_centre";
    }

    public List<Pac> list(Version version, List<String> languageList, String country) {
        return (country == null || country.trim().isEmpty())
                ? listPacByAllCountries(version, languageList)
                : listPacByOneCountry(version, languageList, country);
    }

    private List<Pac> listPacByAllCountries(Version version, List<String> languageList) {
        final String methodName = "listPacByAllCountries";
        start(methodName);

        String sql = "SELECT pac.*, c.country " +
                "FROM patient_assistance_centre pac " +
                "LEFT JOIN country c ON pac.country_uid = c.uid " +
                "WHERE pac.language_code IN(<languageList>) " +
                "AND pac.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<Pac> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            result = query
                    .bindList("languageList", languageList)
                    .mapToBean(Pac.class)
                    .list();
        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }

    private List<Pac> listPacByOneCountry(Version version, List<String> languageList, String country) {
        final String methodName = "listPacByOneCountry";
        start(methodName);

        String sql = "SELECT pac.*, c.country " +
                "FROM patient_assistance_centre pac " +
                "LEFT JOIN country c ON pac.country_uid = c.uid " +
                "WHERE pac.language_code IN(<languageList>) " +
                "AND pac.publish_flag = {PUBLISHED} " +
                "AND c.country = :country";

        sql = getPublishVersion(version, sql);

        List<Pac> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            result = query
                    .bindList("languageList", languageList)
                    .bind("country", country)
                    .mapToBean(Pac.class)
                    .list();
        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }
}
