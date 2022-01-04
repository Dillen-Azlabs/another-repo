package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.ServiceProviderMeta;
import sg.ihh.ms.sdms.app.model.Version;

import java.util.List;

@Repository
public class ServiceProviderMetaRepository extends BaseRepository{
    public ServiceProviderMetaRepository() {
        log = getLogger(this.getClass());
    }
    public List<ServiceProviderMeta> list(Version version, List<String> languageList) {
        final String methodName = "list";
        start(methodName);
        String sql = "SELECT A.uid AS uid, A.language_code AS language_code, A.meta_cta_value AS meta_cta_value, " +
                "B.hospital AS hospital, A.display_order AS display_order, A.publish_flag AS publish_flag, " +
                "A.created_dt AS created_dt, A.modified_dt AS modified_dt FROM service_provider_metadata A" +
                " LEFT JOIN hospital B ON A.hospital_uid = B.uid ;";

        List<ServiceProviderMeta> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            result = query.mapToBean(ServiceProviderMeta.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
}
