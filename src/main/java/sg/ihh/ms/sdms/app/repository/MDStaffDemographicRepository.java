package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.MDStaffDemographic;
import sg.ihh.ms.sdms.app.model.Version;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MDStaffDemographicRepository extends BaseRepository {
    private static final Map<String, String> SORT_MAP = new HashMap<>();

    public MDStaffDemographicRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "mdstaff_demographic");
        tableMap.put(Version.PUBLISHED.getKey(), "mdstaff_demographic");
    }

    public List<MDStaffDemographic> list(Version version) {
        return super.list(version, MDStaffDemographic.class);
    }

    public MDStaffDemographic getDemographicProviderId(String providerId) {
        final String methodName = "getDemographicProviderId";
        start(methodName);

        String sql = "SELECT * FROM mdstaff_demographic ma WHERE provider_id = :providerId";

        MDStaffDemographic result = new MDStaffDemographic();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bind("providerId", providerId);
            result = query.mapToBean(MDStaffDemographic.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

}
