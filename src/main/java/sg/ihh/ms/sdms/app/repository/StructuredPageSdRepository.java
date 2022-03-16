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

    //START - Structured Page Award Block
    public List<StructuredPageAward> getStructuredPageAward(Version version, List<String> languageList,String structuredPageUrl,int sectionNumber, String hospitalCode, String country) {
        final String methodName = "getStructuredPageAward";
        start(methodName);

        String sql = "SELECT spsa.*, spsas.award_intro FROM structured_page_sd sps " +
                "LEFT JOIN structured_page_sd_awards spsa  ON sps.uid = spsa.structured_page_sd_uid " +
                "LEFT JOIN structured_page_sd_award_section spsas  ON sps.uid = spsas.structured_page_sd_uid " +
                "LEFT JOIN structured_page_sd_awards_country spsac  ON spsa.uid = spsac.structured_page_sd_awards_uid  " +
                "LEFT JOIN structured_page_sd_awards_hospital spsah ON spsa.uid = spsah.structured_page_sd_awards_uid " +
                "LEFT JOIN country_of_residence c ON c.uid = spsac.cor_uid " +
                "LEFT JOIN hospital h ON spsah.hospital_uid = h.uid " +
                "WHERE sps.language_code IN(<languageList>) AND sps.item_url = :item_url AND h.hospital = :hospital AND spsas.`section` = :section AND c.cor  = :countryOfResidence " +
                "AND sps.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<StructuredPageAward> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredPageUrl).bind("section",sectionNumber).bind("hospital", hospitalCode).bind("countryOfResidence", country);
            result = query.mapToBean(StructuredPageAward.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        for (StructuredPageAward structuredPageAward : result) {
            structuredPageAward.setAwardItem(getStructuredPageAwardItem(version,languageList,structuredPageUrl,sectionNumber,hospitalCode,country));
        }
        completed(methodName);
        return result;
    }
    private List<StructuredPageAwardItem> getStructuredPageAwardItem(Version version, List<String> languageList,String structuredPageUrl,int sectionNumber, String hospitalCode, String country)
    {
        String methodName = "getStructuredPageAwardItem";

        String structuredPageSql = "SELECT sps.uid  FROM structured_page_sd sps " +
                "LEFT JOIN structured_page_sd_awards spsa  ON sps.uid = spsa.structured_page_sd_uid " +
                "LEFT JOIN structured_page_sd_award_section spsas  ON sps.uid = spsas.structured_page_sd_uid " +
                "LEFT JOIN structured_page_sd_awards_country spsac  ON spsa.uid = spsac.structured_page_sd_awards_uid  " +
                "LEFT JOIN structured_page_sd_awards_hospital spsah ON spsa.uid = spsah.structured_page_sd_awards_uid " +
                "LEFT JOIN country_of_residence c ON c.uid = spsac.cor_uid " +
                "LEFT JOIN hospital h ON spsah.hospital_uid = h.uid " +
                "WHERE sps.language_code IN(<languageList>) AND sps.item_url = :item_url AND h.hospital = :hospital AND spsas.`section` = :section AND c.cor  = :countryOfResidence " +
                "AND sps.publish_flag = {PUBLISHED}";

        String AwardSql = "SELECT spsa.heading, spsa.icon, spsa.description , spsas.display_order FROM structured_page_sd sps  " +
                "LEFT JOIN structured_page_sd_awards spsa  ON sps.uid = spsa.structured_page_sd_uid " +
                "LEFT JOIN structured_page_sd_award_section spsas  ON sps.uid = spsas.structured_page_sd_uid " +
                " WHERE spsa.structured_page_sd_uid = :sdUid " +
                " AND sps.publish_flag = {PUBLISHED}";

        structuredPageSql = getPublishVersion(version, structuredPageSql);
        AwardSql = getPublishVersion(version, AwardSql);

        List<StructuredPageAwardItem> result = new ArrayList<>();

        try (Handle h = getHandle()) {

            List<String> structuredPageUid = new ArrayList<>();
            Query query1 = h.createQuery(structuredPageSql);
            query1.bindList("languageList", languageList).bind("item_url", structuredPageUrl).bind("section",sectionNumber).bind("hospital", hospitalCode).bind("countryOfResidence", country);
            structuredPageUid = query1.mapTo(String.class).list();
            if (!structuredPageUid.isEmpty()) {
                for (String sdUid : structuredPageUid) {
                    Query query2 = h.createQuery(AwardSql);
                    query2.bind("sdUid", sdUid);
                    result = query2.mapToBean(StructuredPageAwardItem.class).list();
                }
            }

        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }
        return result;
    }
    //END - Structured Page Award Block

    //START - Structured Page Why Choose Us Block
    public List<StructuredPageWhyChooseUs> getStructuredPageWcu(Version version, List<String> languageList, String structuredPageUrl,String hospitalCode) {
        final String methodName = "getStructuredPageWcu";
        start(methodName);

        String sql = "SELECT sps.*, spsm.why_choose_us FROM structured_page_sd sps " +
                "LEFT JOIN structured_page_sd_metadata spsm ON sps.uid = spsm.structured_page_sd_uid " +
                "LEFT JOIN hospital h ON spsm.hospital_uid = h.uid  " +
                "WHERE sps.language_code IN(<languageList>) AND sps.item_url = :item_url AND h.hospital = :hospital " +
                "AND sps.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<StructuredPageWhyChooseUs> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredPageUrl).bind("hospital",hospitalCode);
            result = query.mapToBean(StructuredPageWhyChooseUs.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Structured Page Why Choose Us Block

    //START - Structured Page Card Carousel Block
    public List<StructuredPageCardCarousel> getStructuredPageCardCarousel(Version version, List<String> languageList, String structuredPageUrl) {
        final String methodName = "getStructuredPageCardCarousel";
        start(methodName);

        String sql = "SELECT spsc.* FROM structured_page_sd sps " +
                "LEFT JOIN structured_page_sd_card spsc  ON sps.uid = spsc.structured_page_sd_uid  " +
                "WHERE sps.language_code IN(<languageList>) AND sps.item_url = :item_url " +
                "AND sps.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<StructuredPageCardCarousel> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredPageUrl);
            result = query.mapToBean(StructuredPageCardCarousel.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        for (StructuredPageCardCarousel structuredPageCardCarousel : result) {
            structuredPageCardCarousel.setCarouselItems(getStructuredPageCardCarouselItem(version,languageList,structuredPageUrl));
        }
        completed(methodName);
        return result;
    }

    private List<StructuredPageCardCarouselItem> getStructuredPageCardCarouselItem(Version version,List<String> languageList, String structuredPageUrl)
    {
        String methodName = "getStructuredPageCardCarouselItem";
        String relatedConditionSql = "SELECT sps.uid  FROM structured_page_sd sps " +
                " WHERE sps.language_code IN(<languageList>) AND sps.item_url = :item_url " +
                "AND sps.publish_flag = {PUBLISHED}";

        String conditionDiseaseSql = "SELECT spsc.* FROM structured_page_sd_card spsc  " +
                " WHERE spsc.structured_page_sd_uid = :sdUid " +
                " AND publish_flag = {PUBLISHED}";

        relatedConditionSql = getPublishVersion(version, relatedConditionSql);
        conditionDiseaseSql = getPublishVersion(version, conditionDiseaseSql);

        List<StructuredPageCardCarouselItem> result = new ArrayList<>();

        try (Handle h = getHandle()) {

            List<String> structuredPageUid = new ArrayList<>();
            Query query1 = h.createQuery(relatedConditionSql);
            query1.bindList("languageList", languageList).bind("item_url", structuredPageUrl);
            structuredPageUid = query1.mapTo(String.class).list();
            if (!structuredPageUid.isEmpty()) {
                for (String sdUid : structuredPageUid) {
                    Query query2 = h.createQuery(conditionDiseaseSql);
                    query2.bind("sdUid", sdUid);
                    result = query2.mapToBean(StructuredPageCardCarouselItem.class).list();
                }
            }

        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }
        return result;
    }
    //END - Structured Page Card Carousel Block

    //START - Structured Page Faq Block
    public List<StructuredPageFaq> getStructuredPageFaq(Version version, List<String> languageList, String structuredPageUrl) {
        final String methodName = "getStructuredPageFaq";
        start(methodName);

        String sql = "SELECT spsf.* FROM structured_page_sd sps " +
                "LEFT JOIN structured_page_sd_faq spsf  ON sps.uid = spsf.structured_page_sd_uid  " +
                "WHERE sps.language_code IN(<languageList>) AND sps.item_url = :item_url " +
                "AND sps.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<StructuredPageFaq> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredPageUrl);
            result = query.mapToBean(StructuredPageFaq.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Structured Page Faq Block

    //START - Structured Page Photo Gallery Block
    public List<StructuredPagePhotoGallery> getStructuredPagePhotoGallery(Version version, List<String> languageList, String structuredPageUrl) {
        final String methodName = "getStructuredPagePhotoGallery";
        start(methodName);

        String sql = "SELECT spspg.*, spsmc.section_intro FROM structured_page_sd sps " +
                "LEFT JOIN structured_page_sd_photo_gallery spspg  ON sps.uid = spspg.structured_page_sd_uid " +
                "LEFT JOIN structured_page_sd_media_card spsmc  ON sps.uid = spsmc.structured_page_sd_uid  " +
                "WHERE sps.language_code IN(<languageList>) AND sps.item_url = :item_url " +
                "AND sps.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<StructuredPagePhotoGallery> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredPageUrl);
            result = query.mapToBean(StructuredPagePhotoGallery.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        for (StructuredPagePhotoGallery structuredPagePhotoGallery : result) {
            structuredPagePhotoGallery.setMediaCardItems(getStructuredPagePhotoGalleryItem(version,languageList,structuredPageUrl));
        }
        completed(methodName);
        return result;
    }

    private List<StructuredPagePhotoGalleryItem> getStructuredPagePhotoGalleryItem(Version version,List<String> languageList, String structuredPageUrl)
    {
        String methodName = "getStructuredPagePhotoGalleryItem";
        String q1 = "SELECT sps.uid  FROM structured_page_sd sps " +
                " WHERE sps.language_code IN(<languageList>) AND sps.item_url = :item_url " +
                "AND sps.publish_flag = {PUBLISHED}";

        String q2 = "SELECT spspg.*,spsmc.title FROM structured_page_sd sps " +
                "LEFT JOIN structured_page_sd_photo_gallery spspg  ON sps.uid = spspg.structured_page_sd_uid " +
                "LEFT JOIN structured_page_sd_media_card spsmc  ON sps.uid = spsmc.structured_page_sd_uid  " +
                " WHERE spspg.structured_page_sd_uid = :spsUid " +
                " AND sps.publish_flag = {PUBLISHED}";

        q1 = getPublishVersion(version, q1);
        q2 = getPublishVersion(version, q2);

        List<StructuredPagePhotoGalleryItem> result = new ArrayList<>();

        try (Handle h = getHandle()) {

            List<String> structuredPageUid = new ArrayList<>();
            Query query1 = h.createQuery(q1);
            query1.bindList("languageList", languageList).bind("item_url", structuredPageUrl);
            structuredPageUid = query1.mapTo(String.class).list();
            if (!structuredPageUid.isEmpty()) {
                for (String spsUid : structuredPageUid) {
                    Query query2 = h.createQuery(q2);
                    query2.bind("spsUid", spsUid);
                    result = query2.mapToBean(StructuredPagePhotoGalleryItem.class).list();
                }
            }

        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }
        return result;
    }
    //END - Structured Page Photo Gallery Block
}
