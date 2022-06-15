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
public class CentreServiceSubSdRepository extends BaseRepository {

    public CentreServiceSubSdRepository() {
        log = getLogger(this.getClass());
    }

    //START - Get Locations by Centre & Service
    public List<LocationSd> getLocationByCentreService(Version version, List<String> languageList, String itemUrlMain,String itemUrlSub, String hospitalCode){
        final String methodName = "getLocationByCentreService";
        start(methodName);
        String sql ="SELECT ls.uid, ls.language_code, ls.location_title, ls.address1, ls.address2, ls.city , ls.state, ls.postal_code, cor.cor , ls.whatsapp_number, ls.fax, ls.email, ls.display_order, ls.publish_flag, ls.created_dt, ls.modified_dt FROM centre_service_sub_sd csss  " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid = csss.centre_service_main_sd_uid AND csss.status = csms.status AND csss.language_code = csms.language_code  " +
                "LEFT JOIN centre_service_sub_sd_location csssl ON csss.uid = csssl.centre_service_sub_sd_uid AND csss.status = csssl.status AND csss.language_code = csssl.language_code  " +
                "LEFT JOIN location_sd ls  ON ls.uid = csssl.location_uid  " +
                "LEFT JOIN country_of_residence cor ON ls.cor_uid  = cor.uid  " +
                "LEFT JOIN centre_service_sub_sd_location_hospital cssslh ON csssl.uid  = cssslh.centre_service_sub_sd_location_uid AND cssslh.status = csssl.status AND cssslh.language_code = csssl.language_code  " +
                "LEFT JOIN hospital h ON cssslh.hospital_uid  = h.uid  " +
                "WHERE ls.language_code IN(<languageList>)AND csms.item_url = :itemUrlMain AND csss.item_url = :itemUrlSub  AND h.hospital = :hospital " +
                "AND ls.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        List<LocationSd> result = new ArrayList<>();

        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", itemUrlMain).bind("itemUrlSub", itemUrlSub).bind("hospital", hospitalCode);
            result = query.mapToBean(LocationSd.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        for (LocationSd locationSd : result) {

            locationSd.setContactNumbers(getLocationSdContact(version,languageList,itemUrlMain,itemUrlSub,hospitalCode));
        }

        completed(methodName);
        return result;
    }

    private List<LocationSdContact> getLocationSdContact(Version version, List<String> languageList, String itemUrlMain,String itemUrlSub, String hospitalCode){
        final String methodName = "getLocationSdContact";
        start(methodName);
        String sql ="SELECT lsc.contact_header, lsc.contact_number, lsc.display_order  FROM centre_service_sub_sd csss " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid = csss.centre_service_main_sd_uid " +
                "LEFT JOIN centre_service_sub_sd_location csssl ON csss.uid = csssl.centre_service_sub_sd_uid " +
                "LEFT JOIN location_sd ls  ON ls.uid = csssl.location_uid " +
                "LEFT JOIN location_sd_contact lsc  ON ls.uid = lsc.location_sd_uid " +
                "LEFT JOIN centre_service_sub_sd_location_hospital cssslh ON csssl.uid  = cssslh.centre_service_sub_sd_location_uid " +
                "LEFT JOIN hospital h ON cssslh.hospital_uid  = h.uid " +
                "WHERE ls.language_code IN(<languageList>)AND csms.item_url = :itemUrlMain AND csss.item_url = :itemUrlSub  AND h.hospital = :hospital " +
                "AND ls.publish_flag = {PUBLISHED} " +
                "GROUP BY ls.uid ";

        sql = getPublishVersion(version, sql);

        List<LocationSdContact> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", itemUrlMain).bind("itemUrlSub", itemUrlSub).bind("hospital", hospitalCode);
            result = query.mapToBean(LocationSdContact.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }


        completed(methodName);

        return result;
    }
    //END - Get Locations by Centre & Service

    //Start Get Centre & Service Sub Award List
    public CentreServiceSubAward getCentreServiceSubAward(Version version, List<String> languageList,String centreServiceMUrl,String centreServiceSUrl, String hospitalCode) {
        final String methodName = "getCentreServiceSubAward";
        start(methodName);

        String sql = "SELECT csss.uid, csss.language_code, csss.publish_flag, csss.created_dt, csss.modified_dt FROM centre_service_sub_sd csss    " +
                "LEFT JOIN centre_service_main_sd csms ON csss.centre_service_main_sd_uid  = csms.uid  AND csss.status = csms.status AND csss.language_code = csms.language_code   " +
                "LEFT JOIN centre_service_sub_sd_award_section csssas  ON csss.uid = csssas.centre_service_sub_sd_uid AND csss.status = csssas.status AND csss.language_code = csssas.language_code  " +
                "LEFT JOIN centre_service_sub_sd_award_section_hospital csssash  ON csssas.uid = csssash.centre_service_sub_sd_award_section_uid  AND csssash.status = csssas.status AND csssash.language_code = csssas.language_code " +
                "LEFT JOIN hospital h ON csssash.hospital_uid = h.uid " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND h.hospital = :hospital AND csms.item_url = :itemUrlMain  " +
                "AND csss.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        CentreServiceSubAward result = new CentreServiceSubAward();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", centreServiceMUrl).bind("hospital", hospitalCode).bind("itemUrlSub", centreServiceSUrl);
            result = query.mapToBean(CentreServiceSubAward.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

            result.setAwardItem(getAward(version,languageList,centreServiceMUrl,hospitalCode,centreServiceSUrl));
            result.setSectionIntro(getCentreServiceAwardSection(version,languageList,centreServiceMUrl,hospitalCode,centreServiceSUrl));

        completed(methodName);
        return result;
    }

    public String getCentreServiceAwardSection(Version version, List<String> languageList, String centreServiceMUrl, String hospitalCode, String centreServiceSUrl) {
        final String methodName = "getCentreServiceAwardSection";
        start(methodName);

        String sql = "SELECT csssas.section_intro  FROM centre_service_sub_sd csss  " +
                "LEFT JOIN centre_service_main_sd csms ON csss.centre_service_main_sd_uid  = csms.uid  AND csss.status = csms.status AND csss.language_code = csms.language_code   " +
                "LEFT JOIN centre_service_sub_sd_award_section csssas  ON csss.uid = csssas.centre_service_sub_sd_uid AND csss.status = csssas.status AND csss.language_code = csssas.language_code  " +
                "LEFT JOIN centre_service_sub_sd_award_section_hospital csssash  ON csssas.uid = csssash.centre_service_sub_sd_award_section_uid  AND csssash.status = csssas.status AND csssash.language_code = csssas.language_code   " +
                "LEFT JOIN hospital h ON csssash.hospital_uid = h.uid " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND h.hospital = :hospital AND csms.item_url = :itemUrlMain " +
                "AND csss.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        String result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", centreServiceMUrl).bind("hospital", hospitalCode).bind("itemUrlSub", centreServiceSUrl);
            result = query.mapTo(String.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    private List<CentreServiceSubAwardItem> getAward(Version version, List<String> languageList, String centreServiceMUrl, String hospitalCode, String centreServiceSUrl)
    {
        String methodName = "getAward";
        String sql = "SELECT csssa.heading, csssa.icon, csssa.description, csssa.display_order FROM centre_service_sub_sd csss   " +
                "LEFT JOIN centre_service_main_sd csms ON csss.centre_service_main_sd_uid = csms.uid AND csss.status = csms.status AND csss.language_code = csms.language_code " +
                "LEFT JOIN centre_service_sub_sd_award csssa  ON csss.uid = csssa.centre_service_sub_sd_uid AND csss.status = csssa.status AND csss.language_code = csssa.language_code  " +
                "LEFT JOIN centre_service_sub_sd_award_hospital csssah  ON csssa.uid = csssah.centre_service_sub_sd_award_uid AND csssah.status = csssa.status AND csssah.language_code = csssa.language_code  " +
                "LEFT JOIN hospital h ON csssah.hospital_uid  = h.uid " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND h.hospital = :hospital AND csms.item_url = :itemUrlMain " +
                "AND csss.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<CentreServiceSubAwardItem> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", centreServiceMUrl).bind("hospital", hospitalCode).bind("itemUrlSub", centreServiceSUrl);
            result = query.mapToBean(CentreServiceSubAwardItem.class).list();
        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }

        return result;
    }
    //END getCentreServiceSubAward

    //START - Centre Service Sub CTA  Block
    public CentreServiceSubCta getCentreServiceSubCta(Version version, List<String> languageList, String centerServiceSUrl, String centerServiceMUrl, String hospitalCode) {
        final String methodName = "getCentreServiceSubCta";
        start(methodName);

        String sql = "SELECT csssm.* FROM centre_service_main_sd csms  " +
                "LEFT JOIN centre_service_sub_sd csss ON csms.uid  = csss.centre_service_main_sd_uid AND csss.status = csms.status AND csss.language_code = csms.language_code   " +
                "LEFT JOIN centre_service_sub_sd_metadata csssm ON csssm.centre_service_sub_sd_uid  = csss.uid  AND csss.status = csssm.status AND csss.language_code = csssm.language_code  " +
                "LEFT JOIN centre_service_sub_sd_metadata_hospital csssmh ON csssm.uid  = csssmh.centre_service_sub_sd_metadata_uid  " +
                "LEFT JOIN hospital h  ON h.uid  = csssmh.hospital_uid   " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND h.hospital = :hospital AND csms.item_url = :itemUrlMain  " +
                "AND csss.publish_flag = {PUBLISHED} GROUP BY csss.uid ";

        sql = getPublishVersion(version, sql);

        CentreServiceSubCta result = new CentreServiceSubCta();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlSub", centerServiceSUrl).bind("hospital", hospitalCode).bind("itemUrlMain", centerServiceMUrl);
            result = query.mapToBean(CentreServiceSubCta.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }
    //END - Centre Service Sub CTA  Block


    //START - Centre Service Main Accordion Block
    public List<CentreServiceSubAccordion> getCentreServiceSubAccordion(Version version, List<String> languageList, String centerServiceSUrl, String centerServiceMUrl, String hospitalCode) {
        final String methodName = "getCentreServiceSubAccordion";
        start(methodName);

        String sql = "SELECT csss.uid, csss.language_code, csssa.section_intro, csssa.title, csssa.body, csssa.anchor_id, csssa.display_order, csss.publish_flag, csss.created_dt, csss.modified_dt FROM centre_service_sub_sd csss " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid  = csss.centre_service_main_sd_uid AND csss.status = csms.status AND csss.language_code = csms.language_code " +
                "LEFT JOIN centre_service_sub_sd_accordion csssa ON csss.uid = csssa.centre_service_sub_sd_uid  AND csss.status = csssa.status AND csss.language_code = csssa.language_code " +
                "LEFT JOIN centre_service_sub_sd_accordion_hospital csssah ON csssa.uid = csssah.centre_service_sub_sd_accordion_uid AND csssa.status = csssah.status AND csssa.language_code = csssah.language_code " +
                "LEFT JOIN hospital h ON csssah.hospital_uid = h.uid " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND h.hospital = :hospital AND csms.item_url = :itemUrlMain " +
                "AND csss.publish_flag = {PUBLISHED}";


        sql = getPublishVersion(version, sql);

        List<CentreServiceSubAccordion> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlSub", centerServiceSUrl).bind("hospital", hospitalCode).bind("itemUrlMain", centerServiceMUrl);
            result = query.mapToBean(CentreServiceSubAccordion.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Centre Service Sub Accordion Block

    //START - Centre Service Sub Photo Gallery Block
    public CentreServicePhotoGallery getCentreServicePagePhotoGallery(Version version, List<String> languageList, String centerServiceSUrl, String centerServiceMUrl, String hospitalCode) {
        final String methodName = "getCentreServicePagePhotoGallery";
        start(methodName);

        CentreServicePhotoGallery centreServicePhotoGallery = getCentreServicePhoto(version, languageList, centerServiceSUrl, centerServiceMUrl, hospitalCode);

        if (centreServicePhotoGallery != null) {
            List<CentreServicePhotoGalleryItem> centreServicePhotoGalleryItems = getCentreServicePhotoGalleryItem(version, languageList, centerServiceSUrl, centerServiceMUrl, hospitalCode);

            centreServicePhotoGallery.setGalleryItems(centreServicePhotoGalleryItems);
        }

        completed(methodName);
        return centreServicePhotoGallery;
    }
    public CentreServicePhotoGallery getCentreServicePhoto(Version version, List<String> languageList, String centerServiceSUrl, String centerServiceMUrl, String hospitalCode) {
        final String methodName = "getCentreServicePhoto";
        start(methodName);

        String sql = "SELECT csss.*, csssps.section_intro FROM centre_service_sub_sd csss " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid  = csss.centre_service_main_sd_uid AND csss.status = csms.status AND csss.language_code = csms.language_code " +
                "LEFT JOIN centre_service_sub_sd_photo_section csssps ON csss.uid = csssps.centre_service_sub_sd_uid AND csss.status = csssps.status AND csss.language_code = csssps.language_code " +
                "LEFT JOIN centre_service_sub_sd_photo_section_hospital cssspsh ON csssps.uid  = cssspsh.centre_service_sub_sd_photo_section_uid  AND csssps.status = cssspsh.status AND csssps.language_code = cssspsh.language_code " +
                "LEFT JOIN hospital h  ON h.uid  = cssspsh.hospital_uid " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND h.hospital = :hospital AND csms.item_url = :itemUrlMain " +
                "AND csss.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        CentreServicePhotoGallery result = new CentreServicePhotoGallery();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlSub", centerServiceSUrl).bind("hospital", hospitalCode).bind("itemUrlMain", centerServiceMUrl);
            result = query.mapToBean(CentreServicePhotoGallery.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    private List<CentreServicePhotoGalleryItem> getCentreServicePhotoGalleryItem(Version version, List<String> languageList, String centerServiceSUrl, String centerServiceMUrl, String hospitalCode)
    {
        String methodName = "getCentreServicePhotoGalleryItem";
        String sql = "SELECT csssp.* FROM centre_service_sub_sd csss  " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid  = csss.centre_service_main_sd_uid AND csss.status = csms.status AND csss.language_code = csms.language_code " +
                "LEFT JOIN centre_service_sub_sd_photo csssp ON csss.uid = csssp.centre_service_sub_sd_uid AND csss.status = csssp.status AND csss.language_code = csssp.language_code  " +
                "LEFT JOIN centre_service_sub_sd_photo_hospital csssph ON csssp.uid  = csssph.centre_service_sub_sd_photo_uid AND csssph.status = csssp.status AND csssph.language_code = csssp.language_code " +
                "LEFT JOIN hospital h  ON h.uid  = csssph.hospital_uid " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND h.hospital = :hospital AND csms.item_url = :itemUrlMain " +
                "AND csss.publish_flag = {PUBLISHED}";


        sql = getPublishVersion(version, sql);

        List<CentreServicePhotoGalleryItem> result = new ArrayList<>();

        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlSub", centerServiceSUrl).bind("hospital", hospitalCode).bind("itemUrlMain", centerServiceMUrl);
            result = query.mapToBean(CentreServicePhotoGalleryItem.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        return result;
    }
    //END - Centre Service Sub Photo Gallery Block


    //START - Centre Service Sub Body Section Block
    public List<CentreServiceSubBodySection> getCentreServiceSubBodySection(Version version, List<String> languageList, String centerServiceSUrl, String centerServiceMUrl, String hospitalCode, int sectionNumber) {
        final String methodName = "getCentreServiceSubBodySection";
        start(methodName);

        String sql = "SELECT csssb.*  FROM centre_service_sub_sd csss " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid  = csss.centre_service_main_sd_uid AND csss.status = csms.status AND csss.language_code = csms.language_code " +
                "LEFT JOIN centre_service_sub_sd_body csssb ON csss.uid = csssb.centre_service_sub_sd_uid  AND csss.status = csssb.status AND csss.language_code = csssb.language_code " +
                "LEFT JOIN centre_service_sub_sd_body_hospital csssbh ON csssb.uid  = csssbh.centre_service_sub_sd_body_uid AND csssb.status = csssbh.status AND csssb.language_code = csssbh.language_code " +
                "LEFT JOIN hospital h  ON h.uid  = csssbh.hospital_uid " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND h.hospital = :hospital AND csssb.section = :section AND csms.item_url = :itemUrlMain " +
                "AND csss.publish_flag = {PUBLISHED}";


        sql = getPublishVersion(version, sql);

        List<CentreServiceSubBodySection> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlSub", centerServiceSUrl).bind("hospital", hospitalCode).bind("section", sectionNumber).bind("itemUrlMain", centerServiceMUrl);
            result = query.mapToBean(CentreServiceSubBodySection.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Centre Service Sub Body Section Block

    //START - Centre Service Sub Basic Detail Block
    public CentreServiceSubBasicDetail getCentreServiceSubBasicDetail(Version version, List<String> languageList,  String centreServiceSUrl, String centreServiceMUrl, String hospitalCode) {
        final String methodName = "getCentreServiceSubBasicDetail";
        start(methodName);

        String sql = "SELECT csss.*  FROM centre_service_sub_sd csss    " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid  = csss.centre_service_main_sd_uid AND csss.status = csms.status AND csss.language_code = csms.language_code  " +
                "LEFT JOIN centre_service_sub_sd_metadata csssm ON csss.uid = csssm.centre_service_sub_sd_uid  AND csss.status = csssm.status AND csss.language_code = csssm.language_code  " +
                "LEFT JOIN centre_service_sub_sd_metadata_hospital csssmh ON csssm.uid  = csssmh.centre_service_sub_sd_metadata_uid    " +
                "LEFT JOIN hospital h  ON h.uid  = csssmh.hospital_uid " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND csms.item_url = :itemUrlMain AND h.hospital = :hospital " +
                "AND csss.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        CentreServiceSubBasicDetail result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlSub", centreServiceSUrl).bind("itemUrlMain", centreServiceMUrl).bind("hospital", hospitalCode);
            result = query.mapToBean(CentreServiceSubBasicDetail.class).one();
        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        if (result != null) {
            Map<String, Object> metadataDetails = getMetadataBasicDetail(version, languageList, centreServiceSUrl,centreServiceMUrl, hospitalCode);
            Map<String, Object> centreServiceMain = getCentreServiceMain(version, languageList, centreServiceSUrl,centreServiceMUrl,hospitalCode );
            if (metadataDetails.get("hospital_main_image") != null && !metadataDetails.get("hospital_main_image").equals("")) {
                result.setMainImage((String) metadataDetails.get("hospital_main_image"));
            }
            if (metadataDetails.get("hospital_main_image_alt_text") != null && !metadataDetails.get("hospital_main_image_alt_text").equals("")) {
                result.setMainImageAltText((String) metadataDetails.get("hospital_main_image_alt_text"));
            }
            result.setCentreServiceMPageTitle((String) centreServiceMain.get("page_title"));
            result.setSummary((String) centreServiceMain.get("summary"));
            result.setHideHeroImage((boolean) centreServiceMain.get("hide_hero_image"));
            result.setMetaTitle((String) metadataDetails.get("meta_title"));
            result.setMetaDescription((String) metadataDetails.get("meta_description"));
            result.setSocialSummary((String) metadataDetails.get("social_summary"));
        }else{
            result = new CentreServiceSubBasicDetail();
        }


        completed(methodName);
        return result;
    }

    public Map<String, Object> getCentreServiceMain(Version version, List<String> languageList, String centreServiceSUrl, String centreServiceMUrl, String hospitalCode) {
        final String methodName = "getCentreServiceMain";
        start(methodName);

        String sql = "SELECT  csms.page_title, csms.summary, csms.hide_hero_image FROM centre_service_sub_sd csss   " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid  = csss.centre_service_main_sd_uid AND csss.status = csms.status AND csss.language_code = csms.language_code  " +
                "LEFT JOIN centre_service_sub_sd_metadata csssm ON csss.uid = csssm.centre_service_sub_sd_uid  AND csss.status = csssm.status AND csss.language_code = csssm.language_code  " +
                "LEFT JOIN centre_service_sub_sd_metadata_hospital csssmh ON csssm.uid  = csssmh.centre_service_sub_sd_metadata_uid    " +
                "LEFT JOIN hospital h  ON h.uid  = csssmh.hospital_uid " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND csms.item_url = :itemUrlMain AND h.hospital = :hospital " +
                "AND csss.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlSub", centreServiceSUrl).bind("itemUrlMain", centreServiceMUrl).bind("hospital", hospitalCode);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    public Map<String, Object> getMetadataBasicDetail(Version version, List<String> languageList, String centreServiceSUrl,String centreServiceMUrl, String hospitalCode) {
        final String methodName = "getMetadataBasicDetail";
        start(methodName);

        String sql = "SELECT csmsm.hospital_main_image, csmsm.hospital_main_image_alt_text, csmsm.social_summary, csssm.meta_title, csssm.meta_description FROM centre_service_sub_sd csss   " +
                "LEFT JOIN centre_service_main_sd csms ON csss.centre_service_main_sd_uid  = csms.uid  AND csss.status = csms.status AND csss.language_code = csms.language_code  " +
                "LEFT JOIN centre_service_main_sd_metadata csmsm ON csms.uid = csmsm.centre_service_main_sd_uid    " +
                "LEFT JOIN centre_service_sub_sd_metadata csssm ON csss.uid = csssm.centre_service_sub_sd_uid AND csss.status = csssm.status AND csss.language_code = csssm.language_code  " +
                "LEFT JOIN centre_service_sub_sd_metadata_hospital csssmh ON csssm.uid  = csssmh.centre_service_sub_sd_metadata_uid    " +
                "LEFT JOIN hospital hs  ON hs.uid  = csssmh.hospital_uid   " +
                "LEFT JOIN hospital hm  ON hm.uid  = csmsm.hospital_uid " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND csms.item_url = :itemUrlMain AND hs.hospital = :hospital AND hm.hospital = :hospital " +
                "AND csss.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlSub", centreServiceSUrl).bind("itemUrlMain", centreServiceMUrl).bind("hospital", hospitalCode);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    //END - Centre Service Sub Basic Detail Block

    //START - Get Locations by Centre & Service
    public List<CentreServiceSubRelatedSpecialties> getCentreServiceRelatedSpecialties(Version version, List<String> languageList, String itemUrlMain,String itemUrlSub, String hospitalCode){
        final String methodName = "getCentreServiceRelatedSpecialties";
        start(methodName);
        String sql ="  SELECT ss.* FROM centre_service_sub_sd csss " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid = csss.centre_service_main_sd_uid AND csss.status = csms.status AND csss.language_code = csms.language_code  " +
                "LEFT JOIN centre_service_main_sd_specialty csmss ON csms.uid = csmss.centre_service_main_sd_uid  AND csms.status = csmss.status AND csms.language_code = csmss.language_code " +
                "LEFT JOIN specialty s ON s.uid = csmss.specialty_uid  " +
                "LEFT JOIN specialty_sd ss  ON s.uid = ss.specialty_uid " +
                "LEFT JOIN specialty_sd_metadata ssm ON ss.uid  = ssm.specialty_sd_uid  " +
                "LEFT JOIN hospital h ON ssm.hospital_uid  = h.uid " +
                "WHERE ss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND csms.item_url = :itemUrlMain  AND h.hospital = :hospital " +
                "AND ss.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        List<CentreServiceSubRelatedSpecialties> result = new ArrayList<>();

        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", itemUrlMain).bind("itemUrlSub", itemUrlSub).bind("hospital", hospitalCode);
            result = query.mapToBean(CentreServiceSubRelatedSpecialties.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }

    //END - Get Locations by Centre & Service

    //START - Get Centre & Service (S) Medical Professionals
    public CentreServiceSubMedicalProfessionals getCentreServiceMedicalProfessionals(Version version, List<String> languageList, String itemUrlMain,String itemUrlSub, String hospitalCode){
        final String methodName = "getCentreServiceMedicalProfessionals";
        start(methodName);
        String sql ="  SELECT csss.uid, csss.language_code, csssmd.specialist_section_intro, csms.specialist_listing, csms.ahp_listing, csssmd.display_specialist, csssmd.display_ahp, csssmd.ahp_section_intro, csss.display_order, csss.publish_flag, csss.created_dt, csss.modified_dt FROM centre_service_sub_sd csss " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid = csss.centre_service_main_sd_uid AND csss.status = csms.status AND csss.language_code = csms.language_code  " +
                "LEFT JOIN centre_service_sub_sd_metadata csssmd ON csssmd.centre_service_sub_sd_uid = csss.uid AND csss.status = csssmd.status AND csss.language_code = csssmd.language_code   " +
                "LEFT JOIN centre_service_sub_sd_metadata_hospital csssmh ON csssmd.uid  = csssmh.centre_service_sub_sd_metadata_uid AND csssmh.status = csssmd.status AND csssmh.language_code = csssmd.language_code   " +
                "LEFT JOIN hospital h  ON h.uid  = csssmh.hospital_uid " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND csms.item_url = :itemUrlMain  AND h.hospital = :hospital " +
                "AND csss.publish_flag = {PUBLISHED} ";

        Map<String, Object> param = new HashMap<>();
        param.put("version", version);
        param.put("languageCode", languageList);
        param.put("centreServiceMUrl", itemUrlMain);
        param.put("centreServiceSUrl", itemUrlSub);
        param.put("hospitalCode", hospitalCode);

        log.debug(param.toString());

        sql = getPublishVersion(version, sql);

        CentreServiceSubMedicalProfessionals result = new CentreServiceSubMedicalProfessionals();

        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", itemUrlMain).bind("itemUrlSub", itemUrlSub).bind("hospital", hospitalCode);
            result = query.mapToBean(CentreServiceSubMedicalProfessionals.class).first();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        if (result != new CentreServiceSubMedicalProfessionals()) {
            List<CentreServiceSubMedicalProfessional> specialistList = new ArrayList<>();
            if (result.isDisplaySpecialist()) {
                if(result.getSpecialistListing().equals("By Specialty / Service Provider Type")) {
                    specialistList = getSpecialists(version, languageList, itemUrlMain);
                } else if (result.getSpecialistListing().equals("By Selection")) {
                    specialistList = getSpecialistsByCentreService(version, languageList, itemUrlMain, hospitalCode);
                }
            }

            result.setSpecialists(specialistList);

            // there is mapping to specialty L1 and child specialty (L2)
            List<String> specialtiesList = getSpecialties(version, languageList, itemUrlMain, itemUrlSub);
            for (String childSpecialty : getChildSpecialties(version, languageList, itemUrlMain, itemUrlSub)) {
                specialtiesList.add(childSpecialty);
            }
            result.setSpecialties(specialtiesList);

            List<CentreServiceSubMedicalProfessional> ahpList = new ArrayList<>();
            if (result.isDisplayAhp()) {
                if (result.getAhpListing().equals("By Specialty / Service Provider Type")) {
                    ahpList = getAhps(version, languageList, itemUrlMain);
                } else if (result.getAhpListing().equals("By Selection")) {
                    ahpList = getAhpsByCentreService(version, languageList, itemUrlMain, hospitalCode);
                }
            }

            result.setAhps(ahpList);
            result.setServiceProviderTypes(getServiceProviderTypes(version, languageList, itemUrlMain, itemUrlSub));

        }
        completed(methodName);
        return result;
    }

    private List<CentreServiceSubMedicalProfessional> getSpecialists(Version version, List<String> languageList, String centreServiceMUrl)
    {
        String methodName = "getSpecialists";
        String sql ="  SELECT mp.uid, mp.language_code, mp.item_url, mp.display_name, mp.salutation, mp.designation, mp.profile_photo_url, mp.profile_photo_alt_text, mp.display_order, mp.publish_flag, mp.created_dt, mp.modified_dt FROM centre_service_main_sd csms " +
                "LEFT JOIN centre_service_main_sd_specialty csmss ON csms.uid = csmss.centre_service_main_sd_uid  " +
                "LEFT JOIN specialty s ON s.uid = csmss.specialty_uid  " +
                "LEFT JOIN medical_professional_specialty mps ON s.uid = mps.specialty_uid  " +
                "LEFT JOIN medical_professional mp ON mp.uid = mps.medical_professional_uid  " +
                "LEFT JOIN medical_professional_type mpt ON mpt.uid = mp.medical_professional_type_uid  " +
                "WHERE csms.language_code IN(<languageList>) AND csms.item_url = :itemUrlMain AND mpt.profession = 'Specialists' " +
                "AND csms.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        List<CentreServiceSubMedicalProfessional> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", centreServiceMUrl);
            result = query.mapToBean(CentreServiceSubMedicalProfessional.class).list();
        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }

        return result;
    }

    private List<CentreServiceSubMedicalProfessional> getSpecialistsByCentreService(Version version, List<String> languageList, String centreServiceMUrl, String hospitalCode)
    {
        String methodName = "getSpecialistsByCentreService";
        String sql ="  SELECT mp.uid, mp.language_code, mp.item_url, mp.display_name, mp.salutation, mp.designation, mp.profile_photo_url, mp.profile_photo_alt_text, mp.display_order, mp.publish_flag, mp.created_dt, mp.modified_dt FROM centre_service_main_sd csms " +
                "LEFT JOIN medical_professional_centre_service mpcs ON csms.uid = mpcs.centre_service_main_sd_uid  " +
                "LEFT JOIN medical_professional_centre_service_hospital mpcsh ON mpcs.uid = mpcsh.medical_professional_centre_service_uid  " +
                "LEFT JOIN hospital h ON h.uid = mpcsh.hospital_uid  " +
                "LEFT JOIN medical_professional mp ON mp.uid = mpcs.medical_professional_uid  " +
                "LEFT JOIN medical_professional_type mpt ON mpt.uid = mp.medical_professional_type_uid  " +
                "WHERE csms.language_code IN(<languageList>) AND csms.item_url = :itemUrlMain AND mpt.profession = 'Specialists' AND h.hospital = :hospital " +
                "AND csms.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        List<CentreServiceSubMedicalProfessional> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", centreServiceMUrl).bind("hospital", hospitalCode);
            result = query.mapToBean(CentreServiceSubMedicalProfessional.class).list();
        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }

        return result;
    }

    private List<String> getSpecialties(Version version, List<String> languageList, String centreServiceMUrl, String centreServiceSUrl)
    {
        String methodName = "getSpecialties";
        String sql ="  SELECT s.specialty FROM centre_service_sub_sd csss " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid = csss.centre_service_main_sd_uid " +
                "LEFT JOIN centre_service_main_sd_specialty csmss ON csms.uid = csmss.centre_service_main_sd_uid  " +
                "LEFT JOIN specialty s ON s.uid = csmss.specialty_uid  " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND csms.item_url = :itemUrlMain " +
                "AND csss.publish_flag = {PUBLISHED} AND s.specialty IS NOT NULL";

        sql = getPublishVersion(version, sql);

        List<String> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", centreServiceMUrl).bind("itemUrlSub", centreServiceSUrl);
            result = query.mapTo(String.class).list();
        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }

        return result;
    }

    private List<String> getChildSpecialties(Version version, List<String> languageList, String centreServiceMUrl, String centreServiceSUrl)
    {
        String methodName = "getChildSpecialties";
        String sql ="  SELECT cs.child_specialty FROM centre_service_sub_sd csss " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid = csss.centre_service_main_sd_uid " +
                "LEFT JOIN centre_service_main_sd_child_specialty csmscs ON csms.uid = csmscs.centre_service_main_sd_uid  " +
                "LEFT JOIN child_specialty cs ON cs.uid = csmscs.child_specialty_uid  " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND csms.item_url = :itemUrlMain " +
                "AND csss.publish_flag = {PUBLISHED} AND cs.child_specialty IS NOT NULL";

        sql = getPublishVersion(version, sql);

        List<String> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", centreServiceMUrl).bind("itemUrlSub", centreServiceSUrl);
            result = query.mapTo(String.class).list();
        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }

        return result;
    }

    private List<CentreServiceSubMedicalProfessional> getAhps(Version version, List<String> languageList, String centreServiceMUrl)
    {
        String methodName = "getAhps";
        String sql ="  SELECT mp.uid, mp.language_code, mp.item_url, mp.display_name, mp.salutation, mp.designation, mp.profile_photo_url, mp.profile_photo_alt_text, mp.display_order, mp.publish_flag, mp.created_dt, mp.modified_dt FROM centre_service_main_sd csms " +
                "LEFT JOIN centre_service_main_sd_specialty csmss ON csms.uid = csmss.centre_service_main_sd_uid  " +
                "LEFT JOIN specialty s ON s.uid = csmss.specialty_uid  " +
                "LEFT JOIN medical_professional_specialty mps ON s.uid = mps.specialty_uid  " +
                "LEFT JOIN medical_professional mp ON mp.uid = mps.medical_professional_uid  " +
                "LEFT JOIN medical_professional_type mpt ON mpt.uid = mp.medical_professional_type_uid  " +
                "WHERE csms.language_code IN(<languageList>) AND csms.item_url = :itemUrlMain AND mpt.profession = 'Allied health Professionals' " +
                "AND csms.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        List<CentreServiceSubMedicalProfessional> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", centreServiceMUrl);
            result = query.mapToBean(CentreServiceSubMedicalProfessional.class).list();
        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }

        return result;
    }

    private List<CentreServiceSubMedicalProfessional> getAhpsByCentreService(Version version, List<String> languageList, String centreServiceMUrl, String hospitalCode)
    {
        String methodName = "getSpecialistsByCentreService";
        String sql ="  SELECT mp.uid, mp.language_code, mp.item_url, mp.display_name, mp.salutation, mp.designation, mp.profile_photo_url, mp.profile_photo_alt_text, mp.display_order AS order, mp.publish_flag, mp.created_dt, mp.modified_dt FROM centre_service_main_sd csms " +
                "LEFT JOIN medical_professional_centre_service mpcs ON csms.uid = mpcs.centre_service_main_sd_uid  " +
                "LEFT JOIN medical_professional_centre_service_hospital mpcsh ON mpcs.uid = mpcs.medical_professional_centre_service_uid  " +
                "LEFT JOIN hospital h ON h.uid = mpcsh.hospital_uid  " +
                "LEFT JOIN medical_professional mp ON mp.uid = mpcs.medical_professional_uid  " +
                "LEFT JOIN medical_professional_type mpt ON mpt.uid = mp.medical_professional_type_uid  " +
                "WHERE csms.language_code IN(<languageList>) AND csms.item_url = :itemUrlMain AND mpt.profession = 'Allied health Professionals' AND h.hospital = :hospital " +
                "AND csms.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        List<CentreServiceSubMedicalProfessional> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", centreServiceMUrl).bind("hospital", hospitalCode);
            result = query.mapToBean(CentreServiceSubMedicalProfessional.class).list();
        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }

        return result;
    }

    private List<String> getServiceProviderTypes(Version version, List<String> languageList, String centreServiceMUrl, String centreServiceSUrl)
    {
        String methodName = "getServiceProviderTypes";
        String sql ="  SELECT spt.type FROM centre_service_sub_sd csss " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid = csss.centre_service_main_sd_uid " +
                "LEFT JOIN centre_service_main_sd_service_provider csmssp ON csms.uid = csmssp.centre_service_main_sd_uid  " +
                "LEFT JOIN service_provider_type spt ON spt.uid = csmssp.service_provider_type_uid  " +
                "WHERE csss.language_code IN(<languageList>) AND csss.item_url = :itemUrlSub AND csms.item_url = :itemUrlMain " +
                "AND csss.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        List<String> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", centreServiceMUrl).bind("itemUrlSub", centreServiceSUrl);
            result = query.mapTo(String.class).list();
        }
        catch (Exception ex) {
            log.error(methodName, ex);
        }

        return result;
    }


    //END - Get Centre & Service (S) Medical Professionals
}
