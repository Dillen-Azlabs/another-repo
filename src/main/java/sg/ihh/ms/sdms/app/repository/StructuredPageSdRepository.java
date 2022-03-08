package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.*;

import java.util.*;

@Repository
public class StructuredPageSdRepository extends BaseRepository {

    public StructuredPageSdRepository() {
        log = getLogger(this.getClass());
    }
    //START - Structured Page Basic Detail Block
    public StructuredPageBasicDetail getStructuredPageBasicDetail(Version version, List<String> languageList, String structuredPageUrl, String hospitalCode) {
        final String methodName = "getStructuredPageBasicDetail";
        start(methodName);

        String sql = "SELECT sps.*, spsm.social_summary, spsm.overview FROM structured_page_sd sps " +
                "LEFT JOIN structured_page_sd_metadata spsm ON sps.uid = spsm.structured_page_sd_uid " +
                "WHERE sps.language_code IN(<languageList>) AND sps.item_url = :item_url " +
                "AND sps.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        StructuredPageBasicDetail result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredPageUrl);
            result = query.mapToBean(StructuredPageBasicDetail.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        if (result != null) {
            Map<String, Object> metadataDetails = getMetadataBasicDetail(version, languageList, structuredPageUrl, hospitalCode);
            Map<String, Object> expiredDate = getExpiredDate(version, languageList, structuredPageUrl);
            Date TodayDate = new Date();
            Date ExpiredDate = (Date) expiredDate.get("hero_highlight_expiry");

            if(TodayDate.after(ExpiredDate)){
                result.setHeroHighlight((String) metadataDetails.get("hero_highlight"));
            }
            if (metadataDetails.get("hospital_main_image") != null && !metadataDetails.get("hospital_main_image").equals("")) {
                result.setMainImage((String) metadataDetails.get("hospital_main_image"));
            }
            if (metadataDetails.get("hospital_main_image_alt_text") != null && !metadataDetails.get("hospital_main_image_alt_text").equals("")) {
                result.setMainImageAltText((String) metadataDetails.get("hospital_main_image_alt_text"));
            }
            result.setMetaTitle((String) metadataDetails.get("meta_title"));
            result.setMetaDescription((String) metadataDetails.get("meta_description"));
        }

        completed(methodName);
        return result;
    }
    public Map<String, Object> getMetadataBasicDetail(Version version, List<String> languageList, String structuredPageUrl, String hospitalCode) {
        final String methodName = "getMetadataBasicDetail";
        start(methodName);

        String sql = "SELECT spsm.hospital_main_image, spsm.hospital_main_image_alt_text, spsm.social_summary, spsm.meta_title, spsm.meta_description, spsm.overview  FROM structured_page_sd sps " +
                "LEFT JOIN structured_page_sd_metadata spsm ON sps.uid = spsm.structured_page_sd_uid " +
                "LEFT JOIN hospital h ON spsm.hospital_uid  = h.uid " +
                "WHERE sps.language_code IN(<languageList>) AND sps.item_url = :item_url AND h.hospital = :hospital " +
                "AND sps.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredPageUrl).bind("hospital", hospitalCode);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    public Map<String, Object> getExpiredDate(Version version, List<String> languageList, String structuredPageUrl) {
        final String methodName = "getExpiredDate";
        start(methodName);

        String sql = "SELECT sps.hero_highlight_expiry FROM structured_page_sd sps " +
                "WHERE sps.language_code IN(<languageList>) AND sps.item_url = :item_url " +
                "AND sps.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredPageUrl);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Structured Page Basic Detail Block

    //START - Structured Page CTA  Block
    public StructuredPageCta getStructuredPageCta(Version version, List<String> languageList, String structuredPageUrl) {
        final String methodName = "getStructuredPageCta";
        start(methodName);

        String sql = "SELECT sps.* FROM structured_page_sd sps  " +
                "WHERE sps.language_code IN(<languageList>) AND sps.item_url = :item_url " +
                "AND sps.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        StructuredPageCta result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredPageUrl);
            result = query.mapToBean(StructuredPageCta.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }
    //END - Structured Page CTA  Block

    //START - Content Hub Main Body Section Block
    public List<StructuredPageBodySection> getStructuredPageBodySection(Version version, List<String> languageList, String structuredPageUrl, int sectionNumber) {
        final String methodName = "getStructuredPageBodySection";
        start(methodName);

        String sql = "SELECT sps.*, spsb.content1,spsb.video_url , spsb.content2, spsb.button_label_1,spsb.button_url_1 , spsb.button_1_newtab , spsb.button_label_2 , spsb.button_url_2 , spsb.button_2_newtab , spsb.did_you_know_highlight, spsb.note_highlight , spsb.download_highlight FROM structured_page_sd sps " +
                "LEFT JOIN structured_page_sd_body spsb  ON sps.uid = spsb.structured_page_sd_uid " +
                "WHERE sps.language_code IN(<languageList>) AND sps.item_url = :item_url  AND spsb.section  = :section " +
                "AND sps.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<StructuredPageBodySection> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredPageUrl).bind("section", sectionNumber);
            result = query.mapToBean(StructuredPageBodySection.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Content Hub Main Body Section Block

}
