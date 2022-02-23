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

    //START - Content Hub Main Award Block

    public List<ContentHubMainAward> list(Version version, List<String> languageList,String contentHubMUrl, String country) {
        final String methodName = "list";
        start(methodName);

        String sql = "SELECT chmsa.* ,chmsas.section_intro  FROM content_hub_main_sd chms " +
                "LEFT JOIN content_hub_main_sd_awards chmsa  ON chms.uid = chmsa.content_hub_main_sd_uid " +
                "LEFT JOIN content_hub_main_sd_award_section chmsas  ON chms.uid = chmsas.content_hub_main_sd_uid  " +
                "WHERE chmsa.language_code IN(<languageList>) " +
                "AND chmsa.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<ContentHubMainAward> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList);
            result = query.mapToBean(ContentHubMainAward.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        for (ContentHubMainAward contentHubMainAward : result) {
            contentHubMainAward.setAwardItem(getAwardList(version,languageList,contentHubMUrl,country));
        }
        completed(methodName);
        return result;
    }
    private List<ContentHubMainAwardItem> getAwardList(Version version, List<String> languageList,String contentHubMUrl, String country)
    {
        String methodName = "getAwardList";
        String sql = "SELECT chmsa.* FROM content_hub_main_sd chms " +
                "LEFT JOIN content_hub_main_sd_awards chmsa  ON chms.uid = chmsa.content_hub_main_sd_uid " +
                "LEFT JOIN content_hub_main_sd_award_section chmsas  ON chms.uid = chmsas.content_hub_main_sd_uid  " +
                "LEFT JOIN content_hub_main_sd_awards_country chmsac ON chmsa.uid = chmsac.content_hub_main_sd_awards_uid " +
                "LEFT JOIN country_of_residence c ON c.uid = chmsac.cor_uid " +
                "WHERE chms.language_code IN(<languageList>) AND chms.item_url = :item_url  AND c.cor  = :countryOfResidence " +
                "AND chms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<ContentHubMainAwardItem> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", contentHubMUrl).bind("countryOfResidence", country);
            result = query.mapToBean(ContentHubMainAwardItem.class).list();
        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }
        return result;
    }
    public List<ContentHubMainAward> getContentHubMainAward(Version version, List<String> languageList,String contentHubMUrl, String hospitalCode, String country) {
        final String methodName = "getContentHubMainAward";
        start(methodName);

        String sql = "SELECT chmsa.*, chmsas.section_intro FROM content_hub_main_sd chms " +
                "LEFT JOIN content_hub_main_sd_awards chmsa  ON chms.uid = chmsa.content_hub_main_sd_uid " +
                "LEFT JOIN content_hub_main_sd_award_section chmsas  ON chms.uid = chmsas.content_hub_main_sd_uid  " +
                "LEFT JOIN content_hub_main_sd_awards_country chmsac ON chmsa.uid = chmsac.content_hub_main_sd_awards_uid " +
                "LEFT JOIN content_hub_main_sd_awards_hospital chmsah ON chmsa.uid = chmsah.content_hub_main_sd_awards_uid " +
                "LEFT JOIN country_of_residence c ON c.uid = chmsac.cor_uid " +
                "LEFT JOIN hospital h ON chmsah.hospital_uid  = h.uid " +
                "WHERE chms.language_code IN(<languageList>) AND chms.item_url = :item_url AND h.hospital = :hospital AND c.cor  = :countryOfResidence " +
                "AND chms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<ContentHubMainAward> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", contentHubMUrl).bind("hospital", hospitalCode).bind("countryOfResidence", country);
            result = query.mapToBean(ContentHubMainAward.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        for (ContentHubMainAward contentHubMainAward : result) {
            contentHubMainAward.setAwardItem(getAward(version,languageList,contentHubMUrl,hospitalCode,country));
        }
        completed(methodName);
        return result;
    }

    private List<ContentHubMainAwardItem> getAward(Version version, List<String> languageList, String contentHubMUrl, String hospitalCode, String country)
    {
        String methodName = "getAward";
        String sql = "SELECT chmsa.* FROM content_hub_main_sd chms " +
                "LEFT JOIN content_hub_main_sd_awards chmsa  ON chms.uid = chmsa.content_hub_main_sd_uid " +
                "LEFT JOIN content_hub_main_sd_award_section chmsas  ON chms.uid = chmsas.content_hub_main_sd_uid  " +
                "LEFT JOIN content_hub_main_sd_awards_country chmsac ON chmsa.uid = chmsac.content_hub_main_sd_awards_uid " +
                "LEFT JOIN content_hub_main_sd_awards_hospital chmsah ON chmsa.uid = chmsah.content_hub_main_sd_awards_uid " +
                "LEFT JOIN country_of_residence c ON c.uid = chmsac.cor_uid " +
                "LEFT JOIN hospital h ON chmsah.hospital_uid  = h.uid " +
                "WHERE chms.language_code IN(<languageList>) AND chms.item_url = :item_url AND h.hospital = :hospital AND c.cor  = :countryOfResidence " +
                "AND chms.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<ContentHubMainAwardItem> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", contentHubMUrl).bind("hospital", hospitalCode).bind("countryOfResidence", country);
            result = query.mapToBean(ContentHubMainAwardItem.class).list();
        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }
        return result;
    }

    //END - Content Hub Main Award Block


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
