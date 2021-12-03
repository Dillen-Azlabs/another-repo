package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.jdbi.v3.core.statement.Update;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.MDStaffDemographic;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.rest.model.request.MDStaffDemographicRequest;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MDStaffDemographicRepository extends BaseRepository {
    private static final Map<String, String> SORT_MAP = new HashMap<>();
    private static final String PARAM_PROVIDER_ID = "providerId";
    public MDStaffDemographicRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "mdstaff_demographic");
        tableMap.put(Version.PUBLISHED.getKey(), "mdstaff_demographic");
    }

    public boolean validateMDStaffDemographic(String providerId){
        boolean result = false;
        final String methodName = "validateMDStaffDemographic";
        start(methodName);
        final String sql = "SELECT if(COUNT(*)>0,'true','false') FROM mdstaff_demographic WHERE provider_id = :providerId";
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            result = query.bind(PARAM_PROVIDER_ID, providerId).mapTo(Boolean.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
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

    public MDStaffDemographic deleteDemographicProviderId(String providerId) {
        final String methodName = "deleteDemographicProviderId";
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

    public  boolean updateMDStaffDemographic(String providerId, MDStaffDemographicRequest request)
    {
        String methodName = "updateMDStaffDemographic";
        start(methodName);
        boolean result = false;
        String sql = "UPDATE mdstaff_demographic SET first_name=:firstName,last_name=:lastName ,salutation=:salutation,other_id=:otherId,formatted_name=:formattedName WHERE provider_id=:providerId;";
        try (Handle handle = getHandle(); Update update = handle.createUpdate(sql)) {
            int row = update.bind("providerId", providerId).bindBean(request).execute();

            if(row != 0)
            {
                result = true;
            }

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }
    public  boolean delete(String providerId)
    {
        String methodName = "delete";
        start(methodName);
        boolean result = false;
        String sql = "DELETE FROM mdstaff_demographic WHERE provider_id=:providerId;";
        try (Handle handle = getHandle(); Update update = handle.createUpdate(sql)) {
            int row = update.bind("providerId", providerId).execute();

            if(row != 0)
            {
                result = true;
            }

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }
    public boolean addMDStaffDemographic(MDStaffDemographicRequest request) {
        String methodName = "addMDStaffDemographic";
        start(methodName);
        boolean result = false;

        String sql = "INSERT INTO sdmsDB.mdstaff_demographic " +
                "(provider_id, first_name, last_name, salutation, other_id, formatted_name)" +
                "VALUES" +
                "( :providerId, :firstName,:lastName,:salutation,:otherId,:formattedName);";

        try (Handle handle = getHandle(); Update update = handle.createUpdate(sql)) {
            int row = update.bindBean(request).execute();

            if(row != 0)
            {
                result = true;
            }

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }

}
