package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.mapper.JoinRow;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.*;
import sg.ihh.ms.sdms.app.repository.model.Pagination;
import sg.ihh.ms.sdms.app.repository.model.Sort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MDStaffRepository extends BaseRepository {

    private static final Map<String, String> SORT_MAP = new HashMap<>();

    public MDStaffRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "medical_professional");
        tableMap.put(Version.PUBLISHED.getKey(), "medical_professional_ro");
    }

    public List<MDStaffProvider> list() {
        final String methodName = "list";
        start(methodName);

        String sql = "SELECT * FROM mdstaff_providers ";

        List<MDStaffProvider> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            result = query.mapToBean(MDStaffProvider.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<MDStaffProvider> search(String searchTerm, List<Sort> sortList, Pagination pagination) {
        final String methodName = "search";
        start(methodName);

        String sql = "SELECT mdp.*, mddt.other_id as mcr_number FROM mdstaff_providers mdp"
                + " LEFT JOIN mdstaff_demographic mddt ON mdp.provider_id = mddt.provider_id"
                + " WHERE LOWER(name) LIKE CONCAT('%',:searchTermName,'%') "
                + " OR LOWER(other_id) LIKE CONCAT('%',:searchTermMcrNumber,'%') ";

        sortList = sortList.stream().map(sort -> new Sort(SORT_MAP.get(sort.getField()), sort.getModifier()))
                .collect(Collectors.toList());

        sql += generateSort(sortList);
        sql += generatePagination(pagination);

        List<MDStaffProvider> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {

            query.bind("searchTermName", searchTerm.toLowerCase());
            query.bind("searchTermMcrNumber", searchTerm.toLowerCase());
            result = query.mapToBean(MDStaffProvider.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<MDStaffSite> getProviderClinics(String mcrNumber) {
        final String methodName = "getProviderClinics";
        start(methodName);

        String sql = "SELECT mds.* FROM mdstaff_address ma" +
                " INNER JOIN mdstaff_sites mds ON ma.medical_group_id = mds.site_id " +
                " LEFT JOIN mdstaff_providers mp ON ma.provider_id = mp.provider_id " +
                " LEFT JOIN mdstaff_demographic mddt ON mp.provider_id = mddt.provider_id " +
                " WHERE mddt.other_id = :mcrNumber";

        List<MDStaffSite> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bind("mcrNumber", mcrNumber);
            result = query.mapToBean(MDStaffSite.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
}
