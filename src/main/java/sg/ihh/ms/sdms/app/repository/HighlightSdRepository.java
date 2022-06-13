package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.HighlightsSearch;
import sg.ihh.ms.sdms.app.model.Version;

import java.util.ArrayList;
import java.util.List;


@Repository
public class HighlightSdRepository extends  BaseRepository {

    public HighlightSdRepository() {
        log = getLogger(this.getClass());
    }

    //START - Highlight Search
    public List<HighlightsSearch> getHighlightSearch(Version version, List<String> languageList, String publishDateFrom, String publishDateTo){
        final String methodName = "getHighlightSearch";
        start(methodName);

        String sql = "SELECT hs.uid, hs.language_code, hs.image, hs.title, hs.link, hs.linkType, cor.cor, coc.coc, hs.display_order, hs.publish_flag,hs.created_dt, hs.modified_dt, hs.publish_date  FROM highlights_sd hs " +
                "LEFT JOIN country_of_residence cor ON cor.uid = hs.country_of_residence_uid " +
                "LEFT JOIN country_of_care coc ON coc.uid = hs.country_of_care_uid " +
                "WHERE hs.language_code IN(<languageList>) AND hs.publish_date BETWEEN :publishDateFrom AND :publishDateTo " +
                "AND hs.publish_flag = {PUBLISHED} " +
                "ORDER BY hs.display_order ";
        sql = getPublishVersion(version, sql);

        List<HighlightsSearch> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("publishDateFrom", publishDateFrom).bind("publishDateTo", publishDateTo);
            result = query.mapToBean(HighlightsSearch.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
}
