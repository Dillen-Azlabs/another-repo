package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.ContentHubMainBasicDetail;
import sg.ihh.ms.sdms.app.model.ContentHubMainCta;
import sg.ihh.ms.sdms.app.model.ContentHubMainBodySection;
import sg.ihh.ms.sdms.app.model.Version;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ContentHubMainSdRepository extends BaseRepository {

    public ContentHubMainSdRepository() {
        log = getLogger(this.getClass());
    }

    //START - Content Hub Main Basic Detail Block
    public ContentHubMainBasicDetail getContentHubMainBasicDetail(Version version, List<String> languageList, String contentHubMUrl, String hospitalCode) {
        final String methodName = "getContentHubMainBasicDetail";
        start(methodName);

        String sql = "SELECT chms.*, chmsm.social_summary FROM content_hub_main_sd chms " +
                "LEFT JOIN content_hub_main_sd_metadata chmsm  ON chms.uid = chmsm.content_hub_main_sd_uid   " +
                "WHERE chms.language_code IN(<languageList>) AND chms.item_url = :item_url " +
                "AND chms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        ContentHubMainBasicDetail result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", contentHubMUrl);
            result = query.mapToBean(ContentHubMainBasicDetail.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        if (result != null) {
            Map<String, Object> metadataDetails = getMetadataBasicDetail(version, languageList, contentHubMUrl, hospitalCode);
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
    public Map<String, Object> getMetadataBasicDetail(Version version, List<String> languageList, String contentHubMUrl, String hospitalCode) {
        final String methodName = "getMetadataBasicDetail";
        start(methodName);

        String sql = "SELECT chmsm.hospital_main_image, chmsm.hospital_main_image_alt_text, chmsm.social_summary, chmsm.meta_title, chmsm.meta_description  FROM content_hub_main_sd chms " +
                "LEFT JOIN content_hub_main_sd_metadata chmsm  ON chms.uid = chmsm.content_hub_main_sd_uid " +
                "LEFT JOIN hospital h ON chmsm.hospital_uid  = h.uid " +
                "WHERE chms.language_code IN(<languageList>) AND chms.item_url = :item_url AND h.hospital = :hospital " +
                "AND chms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", contentHubMUrl).bind("hospital", hospitalCode);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Content Hub Main Basic Detail Block

    //START - Content Hub Main CTA  Block
    public ContentHubMainCta getContentHubMainCta(Version version, List<String> languageList, String contentHubMUrl) {
        final String methodName = "getContentHubMainCta";
        start(methodName);

        String sql = "SELECT chms.* FROM content_hub_main_sd chms " +
                "WHERE chms.language_code IN(<languageList>) AND chms.item_url = :item_url " +
                "AND chms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        ContentHubMainCta result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", contentHubMUrl);
            result = query.mapToBean(ContentHubMainCta.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }
    //END - Content Hub Main CTA  Block


    //START - Content Hub Main Body Section Block
    public List<ContentHubMainBodySection> getContentHubMainBodySection(Version version, List<String> languageList, String contentHubMUrl, int sectionNumber) {
        final String methodName = "getContentHubMainBodySection";
        start(methodName);

        String sql = "SELECT chms.*, chmsb.content1,chmsb.video_url , chmsb.content2, chmsb.did_you_know_highlight FROM content_hub_main_sd chms " +
                "LEFT JOIN content_hub_main_sd_body chmsb  ON chms.uid = chmsb.content_hub_main_sd_uid " +
                "WHERE chms.language_code IN(<languageList>) AND chms.item_url = :item_url  AND chmsb.section  = :section " +
                "AND chms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<ContentHubMainBodySection> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", contentHubMUrl).bind("section", sectionNumber);
            result = query.mapToBean(ContentHubMainBodySection.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Content Hub Main Body Section Block
}
