package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.LocationSd;
import sg.ihh.ms.sdms.app.model.LocationSdContact;
import sg.ihh.ms.sdms.app.model.Version;

import java.util.ArrayList;
import java.util.List;


@Repository
public class LocationSdRepository  extends BaseRepository {

    public LocationSdRepository() {
        log = getLogger(this.getClass());
    }

    //START - Get Locations by Centre & Service
    public  List<LocationSd> getLocationByItemUrl(Version version, List<String> languageList, List<String> itemUrls, String hospitalCode){
        final String methodName = "getLocationByItemUrl";
        start(methodName);
        List<LocationSd> result = new ArrayList<>();

        for (String itemUrl : itemUrls){
            List<LocationSd> ls = getLocationSd(version, languageList, itemUrl, hospitalCode);
            List<LocationSdContact> lsc = getLocationSdContact(version, languageList, itemUrl, hospitalCode);
            for (LocationSd lsResult : ls){
                lsResult.setContactNumbers(lsc);
                result.add(lsResult);
            }
        }
        completed(methodName);
        return result;
    }


    public List<LocationSd> getLocationSd(Version version, List<String> languageList, String itemUrls, String hospitalCode){
        final String methodName = "getLocationByItemUrl";
        start(methodName);
        String sql ="SELECT ls.uid, ls.language_code, ls.location_title, ls.address1, ls.address2, ls.city , ls.state, ls.postal_code, cor.cor , ls.whatsapp_number, ls.fax, ls.email, ls.display_order, ls.publish_flag, ls.created_dt, ls.modified_dt FROM location_sd ls " +
                "LEFT JOIN country_of_residence cor ON ls.cor_uid  = cor.uid " +
                "LEFT JOIN location_sd_hospital lsh ON ls.uid  = lsh.location_sd_uid AND ls.status = lsh.status AND ls.language_code = lsh.language_code " +
                "LEFT JOIN hospital h ON lsh.hospital_uid  = h.uid " +
                "WHERE ls.language_code IN(<languageList>) AND ls.item_url = :itemUrls AND h.hospital = :hospital " +
                "AND ls.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        List<LocationSd> result = new ArrayList<>();

        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrls", itemUrls).bind("hospital", hospitalCode);
            result = query.mapToBean(LocationSd.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }

    private List<LocationSdContact> getLocationSdContact(Version version, List<String> languageList, String itemUrls, String hospitalCode){
        final String methodName = "getLocationSdContact";
        start(methodName);
        String sql ="SELECT lsc.contact_header, lsc.contact_number, lsc.display_order  FROM location_sd ls " +
                "LEFT JOIN location_sd_contact lsc  ON ls.uid = lsc.location_sd_uid " +
                "LEFT JOIN country_of_residence cor ON ls.cor_uid  = cor.uid " +
                "LEFT JOIN location_sd_hospital lsh ON ls.uid  = lsh.location_sd_uid " +
                "LEFT JOIN hospital h ON lsh.hospital_uid  = h.uid " +
                "WHERE ls.language_code IN(<languageList>) AND ls.item_url = :itemUrls AND h.hospital = :hospital " +
                "AND ls.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<LocationSdContact> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrls", itemUrls).bind("hospital", hospitalCode);
            result = query.mapToBean(LocationSdContact.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);

        return result;
    }
    //END - Get Locations by Centre & Service

    //START - Get Locations by Centre & Service
    public List<LocationSd> getLocationByCentreService(Version version, List<String> languageList, String itemUrlMain,String itemUrlSub, String hospitalCode){
        final String methodName = "getLocationByCentreService";
        start(methodName);
        String sql =" SELECT ls.uid, ls.language_code, ls.location_title, ls.address1, ls.address2, ls.city , ls.state, ls.postal_code, cor.cor , ls.whatsapp_number, ls.fax, ls.email, ls.display_order, ls.publish_flag, ls.created_dt, ls.modified_dt FROM centre_service_sub_sd csss " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid = csss.centre_service_main_sd_uid " +
                "LEFT JOIN centre_service_sub_sd_location csssl ON csss.uid = csssl.centre_service_sub_sd_uid " +
                "LEFT JOIN location_sd ls  ON ls.uid = csssl.location_uid " +
                "LEFT JOIN country_of_residence cor ON ls.cor_uid  = cor.uid " +
                "LEFT JOIN centre_service_sub_sd_location_hospital cssslh ON csssl.uid  = cssslh.centre_service_sub_sd_location_uid " +
                "LEFT JOIN hospital h ON cssslh.hospital_uid  = h.uid " +
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
                "AND ls.publish_flag = {PUBLISHED} ";

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
}
