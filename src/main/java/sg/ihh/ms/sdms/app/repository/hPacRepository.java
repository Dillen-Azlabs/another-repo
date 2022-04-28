package sg.ihh.ms.sdms.app.repository;

import java.util.List;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;

import sg.ihh.ms.sdms.app.model.Pac;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.model.hPac;

@Repository
public class hPacRepository extends BaseRepository {

	public hPacRepository() {
		log = getLogger(this.getClass());
		tableName = "patient_assistance_centre";
	}

	public List<hPac> list(Version version, List<String> languageList) {
		final String methodName = "list";
		start(methodName);

		String sql = "SELECT pac.*, c.country FROM patient_assistance_centre pac "
				+ " LEFT JOIN country c ON pac.country_uid = c.uid " + " WHERE pac.language_code IN(<languageList>) "
				+ " AND pac.publish_flag = {PUBLISHED}";

		sql = getPublishVersion(version, sql);

		List<hPac> result = null;
		try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
			query.bindList("languageList", languageList);
			result = query.mapToBean(hPac.class).list();

		} catch (Exception ex) {
			log.error(methodName, ex);
		}
		completed(methodName);
		return result;
	}

	public List<hPac> searchByCountry(Version version, List<String> languageList, String country) {
		final String methodName = "searchByCountry";
		start(methodName);

		String sql = "SELECT pac.*, c.country FROM patient_assistance_centre pac "
				+ " LEFT JOIN country c ON pac.country_uid = c.uid "
				+ " WHERE pac.language_code IN(<languageList>) AND c.country = :country "
				+ " AND pac.publish_flag = {PUBLISHED}";

		sql = getPublishVersion(version, sql);

		List<hPac> result = null;
		try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
			query.bindList("languageList", languageList).bind("country", country);
			result = query.mapToBean(hPac.class).list();

		} catch (Exception ex) {
			log.error(methodName, ex);
		}
		completed(methodName);
		return result;
	}
}