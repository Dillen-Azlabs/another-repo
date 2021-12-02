package sg.ihh.ms.sdms.app.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Query;
import org.jdbi.v3.core.statement.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.repository.model.Pagination;
import sg.ihh.ms.sdms.app.repository.model.Sort;

public class BaseRepository {

    @Autowired
    protected Jdbi jdbi;

    protected Logger log;

    protected Map<String, String> tableMap;

    public BaseRepository() {
        // Empty Constructor
    }

    protected Handle getHandle() {
        return jdbi.open();
    }

    protected boolean executeUpdate(Update update) {
        return update.execute() >= 1;
    }

    protected int executeCount(Query query) {
        return query.mapTo(Integer.class).one();
    }

    protected Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    protected void start(String methodName) {
        log.debug("[{}] Start", methodName);
    }

    protected void completed(String methodName) {
        log.debug("[{}] Completed", methodName);
    }

    protected boolean isValid(List<?> list) {
        return list != null && !list.isEmpty();
    }

    protected boolean isValid(String str) {
        return str != null && !str.isEmpty();
    }

    protected boolean isValid(int value, int min) {
        return value >= min;
    }

    protected boolean isValid(int value, int min, int max) {
        return value >= min && value <= max;
    }

    protected boolean isValid(LocalDate value) {
        return value != null;
    }

    protected boolean isValid(Pagination pagination) {
        return pagination != null && pagination.getOffset() > -1 && pagination.getPageSize() > 0;
    }

    protected String generateSort(List<Sort> sortList) {
        StringBuilder stringBuilder = new StringBuilder();

        if (!sortList.isEmpty()) {
            stringBuilder.append(" ORDER BY ");
            stringBuilder.append(sortList.stream().map(sort -> sort.getField() + " " + sort.getModifier())
                    .collect(Collectors.joining(", ")));
        }

        return stringBuilder.toString();
    }

    protected String generatePagination(Pagination pagination) {
        String statement = "";
        if (isValid(pagination)) {
            statement = " LIMIT " + pagination.getPageSize() + " OFFSET " + pagination.getOffset();
        }
        return statement;
    }

    protected String getTableVersion(Version version, Map<String, String> tableMap, String sql) {

        String table;
        if (tableMap.containsKey(version.getKey())) {
            table = tableMap.get(version.getKey());
        } else {
            table = tableMap.get(Version.DRAFT.getKey());
        }
        return sql.replace("{TABLE}", table);
    }

    protected <T> List<T> list(Version version, List<String> languageList, Class<T> clazz) {
        final String methodName = "list";
        start(methodName);

        String sql = "SELECT * FROM {TABLE} WHERE language_code IN(<languageList>);";

        sql = getTableVersion(version, tableMap, sql);

        List<T> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList);
            result = query.mapToBean(clazz).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    protected <T> List<T> list(Version version, Class<T> clazz) {
        final String methodName = "list";
        start(methodName);

        String sql = "SELECT * FROM {TABLE};";

        sql = getTableVersion(version, tableMap, sql);

        List<T> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {

            result = query.mapToBean(clazz).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
}
