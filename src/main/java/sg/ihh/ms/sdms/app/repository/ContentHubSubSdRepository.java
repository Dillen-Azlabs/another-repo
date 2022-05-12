package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ContentHubSubSdRepository extends BaseRepository{

    public ContentHubSubSdRepository() {
        log = getLogger(this.getClass());
    }

    //START - Content Hub Sub CTA  Block
    public ContentHubSubCta getContentHubSubCta(Version version, List<String> languageList, String contentHubSUrl, String contentHubMUrl) {
        final String methodName = "getContentHubSubCta";
        start(methodName);

        String sql = "SELECT chss.* FROM content_hub_sub_sd chss " +
                "LEFT JOIN content_hub_main_sd chms ON chss.content_hub_main_sd_uid = chms.uid " +
                "WHERE chss.language_code IN(<languageList>) AND chss.item_url = :itemUrlSub AND chms.item_url = :itemUrlMain " +
                "AND chss.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        ContentHubSubCta result = new ContentHubSubCta();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlSub", contentHubSUrl).bind("itemUrlMain", contentHubMUrl);
            result = query.mapToBean(ContentHubSubCta.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }
    //END - Content Hub Sub CTA  Block

    //START - Content Hub Sub Basic Detail Block
    public ContentHubSubBasicDetail getContentHubSubBasicDetail(Version version, List<String> languageList,  String contentHubSUrl, String contentHubMUrl, String hospitalCode) {
        final String methodName = "getContentHubSubBasicDetail";
        start(methodName);

        String sql = "SELECT chss.*  FROM content_hub_sub_sd chss " +
                "LEFT JOIN content_hub_main_sd chms ON chss.content_hub_main_sd_uid = chms.uid " +
                "WHERE chss.language_code IN(<languageList>) AND chss.item_url = :itemUrlSub AND chms.item_url = :itemUrlMain " +
                "AND chss.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        ContentHubSubBasicDetail result = new ContentHubSubBasicDetail();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlSub", contentHubSUrl).bind("itemUrlMain", contentHubMUrl);
            result = query.mapToBean(ContentHubSubBasicDetail.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        if (result != null) {
            Map<String, Object> metadataDetails = getMetadataBasicDetail(version, languageList, contentHubSUrl,contentHubMUrl, hospitalCode);
            Map<String, Object> contentHubMain = getContentHubMain(version, languageList, contentHubSUrl,contentHubMUrl);
            if (metadataDetails.get("hospital_main_image") != null && !metadataDetails.get("hospital_main_image").equals("")) {
                result.setMainImage((String) metadataDetails.get("hospital_main_image"));
            }
            if (metadataDetails.get("hospital_main_image_alt_text") != null && !metadataDetails.get("hospital_main_image_alt_text").equals("")) {
                result.setMainImageAltText((String) metadataDetails.get("hospital_main_image_alt_text"));
            }
            result.setSocialSummary((String) metadataDetails.get("social_summary"));
            result.setOverview((String) metadataDetails.get("overview"));
            result.setRelatedMPageDisplay((String) contentHubMain.get("page_title"));
            result.setMetaTitle((String) metadataDetails.get("meta_title"));
            result.setMetaDescription((String) metadataDetails.get("meta_description"));
        }

        completed(methodName);
        return result;
    }
    public Map<String, Object> getContentHubMain(Version version, List<String> languageList, String contentHubSUrl, String contentHubMUrl) {
        final String methodName = "getContentHubMain";
        start(methodName);

        String sql = "SELECT  chms.page_title FROM content_hub_sub_sd chss " +
                "LEFT JOIN content_hub_main_sd chms ON chss.content_hub_main_sd_uid = chms.uid " +
                "WHERE chss.language_code IN(<languageList>) AND chss.item_url = :itemUrlSub AND chms.item_url = :itemUrlMain " +
                "AND chss.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlSub", contentHubSUrl).bind("itemUrlMain", contentHubMUrl);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    public Map<String, Object> getMetadataBasicDetail(Version version, List<String> languageList, String contentHubSUrl,String contentHubMUrl, String hospitalCode) {
        final String methodName = "getMetadataBasicDetail";
        start(methodName);

        String sql = "SELECT chssm.hospital_main_image, chssm.hospital_main_image_alt_text, chssm.social_summary, chssm.meta_title, chssm.meta_description, chssm.overview FROM content_hub_sub_sd chss " +
                "LEFT JOIN content_hub_sub_sd_metadata chssm  ON chss.uid = chssm.content_hub_sub_sd_uid AND chss.language_code = chssm.language_code AND chss.status = chssm.status " +
                "LEFT JOIN content_hub_main_sd chms ON chss.content_hub_main_sd_uid = chms.uid " +
                "LEFT JOIN hospital h ON chssm.hospital_uid  = h.uid " +
                "WHERE chss.language_code IN(<languageList>) AND chss.item_url = :itemUrlSub AND chms.item_url = :itemUrlMain AND h.hospital = :hospital " +
                "AND chss.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlSub", contentHubSUrl).bind("itemUrlMain", contentHubMUrl).bind("hospital", hospitalCode);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Content Hub Sub Basic Detail Block

    //START - Content Hub Main Body Section Block
    public List<ContentHubSubBodySection> getContentHubSubBodySection(Version version, List<String> languageList, String contentHubSUrl, String contentHubMUrl) {
        final String methodName = "getContentHubSubBodySection";
        start(methodName);

        String sql = "SELECT chss.* ,chssb.content1,chssb.video_url, chssb.content2, chssb.did_you_know_highlight FROM content_hub_sub_sd chss " +
                "LEFT JOIN content_hub_main_sd chms ON chss.content_hub_main_sd_uid = chms.uid " +
                "LEFT JOIN content_hub_sub_sd_body chssb  ON (chss.uid = chssb.content_hub_sub_sd_uid AND chss.status = chssb.status AND chss.language_code = chssb.language_code)  " +
                "WHERE chss.language_code IN(<languageList>) AND chss.item_url = :itemUrlSub AND chms.item_url = :itemUrlMain " +
                "AND chss.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<ContentHubSubBodySection> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlSub", contentHubSUrl).bind("itemUrlMain", contentHubMUrl);
            result = query.mapToBean(ContentHubSubBodySection.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Content Hub Main Body Section Block

    //START - Content Hub Main Accordion Block
    public List<ContentHubSubAccordion> getContentHubSubAccordion(Version version, List<String> languageList, String contentHubSUrl, String contentHubMUrl) {
        final String methodName = "getContentHubSubAccordion";
        start(methodName);

        String sql = "SELECT chssa.uid, chssa.language_code, chssa.created_dt, chssa.modified_dt, chssa.publish_flag, chssa.section_intro, chssa.title, chssa.content, chssa.anchor_id, chssa.display_order FROM content_hub_sub_sd chss " +
                "LEFT JOIN content_hub_main_sd chms ON chss.content_hub_main_sd_uid = chms.uid " +
                "LEFT JOIN content_hub_sub_sd_accordion chssa ON chss.uid = chssa.content_hub_sub_sd_uid " +
                "WHERE chss.language_code IN(<languageList>) AND chss.item_url = :itemUrlSub AND chms.item_url = :itemUrlMain " +
                "AND chss.publish_flag = {PUBLISHED}";


        sql = getPublishVersion(version, sql);

        List<ContentHubSubAccordion> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlSub", contentHubSUrl).bind("itemUrlMain", contentHubMUrl);
            result = query.mapToBean(ContentHubSubAccordion.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Content Hub Main Accordion Block

}
